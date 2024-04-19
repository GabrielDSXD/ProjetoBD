package com.ci.hatertruck.CRUD.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ci.hatertruck.CRUD.model.Produto;

/* Classe Produto Data Access Object
*  responsavel por transformar os 
*  objetos em dados para o banco 
*  de dados
*/

@Component
public class ProdutoJdbcDao implements DAO<Produto>{

	private static final Logger log = LoggerFactory.getLogger(ProdutoJdbcDao.class);
	private final JdbcTemplate jdbcTemplate;
	
	public ProdutoJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	RowMapper<Produto> rowMapper = (rs,rowNum) -> {
        Produto produto = new Produto();
		produto.setNome(rs.getString("nome"));
		produto.setPreco(rs.getFloat("preco"));
		produto.setCategoria(Produto.CategoriaProduto.valueOf(rs.getString("categoria")));
		produto.setfab_mari(rs.getBoolean("fab_mari"));
		produto.setQuantidade(rs.getInt("qtd_produto"));
		return produto;
	};

	@Override
	public void create(Produto produto) {
		String sql = "INSERT INTO produtos(nome, preco, categoria, fab_mari, quantidade) VALUES (?, ?, ?, ?, ?)";
		int insert = jdbcTemplate.update(sql, produto.getNome(), produto.getPreco(), produto.getCategoria(), produto.isfab_mari(), produto.getQuantidade());
		
		if(insert == 1) {
			log.info(String.format("Produto (%s) adicionado no banco de dados.", produto.getNome()));
		}
	}

	@Override
	public List<Produto> read() {
		String sql = "SELECT * FROM produto";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void update(Produto produto, int id_produto) {
		String sql = "UPDATE produtos SET nome = ?, preco = ?, categoria = ?, fab_mari = ?,  quantidade = ? WHERE id_produto = ?";
		int update =jdbcTemplate.update(sql, produto.getNome(), produto.getPreco(), produto.getCategoria(), produto.isfab_mari(), produto.getQuantidade(), id_produto);
		
		if(update == 1) {
			log.info(String.format("Produto (%s) atualizado no banco de dados.", produto.getNome()));
		} else {
			log.info(String.format("Produto nao encontrado."));
		}
	}

	@Override
	public void delete(int id_produto) {
		String sql = "DELETE FROM produto WHERE id_produto = ?";
		int delete = jdbcTemplate.update(sql, id_produto);
		
		if(delete == 1) {
			log.info(String.format("Produto de id (%s) foi removido do banco de dados.", id_produto));
		} else {
			log.info("Produto nao encontrado.");
		}
	}
	
	@Override
	public List<Produto> selectByString(String nome) {
		String sql = "SELECT * FROM produto WHERE LOWER(nome) LIKE LOWER('%' || ? || '%')";
		return jdbcTemplate.query(sql, rowMapper, nome);
	}
	
	@Override
	public Optional<Produto> selectById(int codigo) {
		String sql = "SELECT id_produto, nome, preco, categoria, fab_mari, qtd_produto FROM produto WHERE codigo = ?";
		Produto produto = null;
		
		try {
			produto = jdbcTemplate.queryForObject(sql, rowMapper, codigo);
			
		} catch(DataAccessException e) {
			log.info("Produto não encontrado.");
		}

		return Optional.ofNullable(produto);
	}
}