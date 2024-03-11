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
	private JdbcTemplate jdbcTemplate;
	
	public ProdutoJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	RowMapper<Produto> rowMapper = (rs,rowNum) -> {
		Produto produto = new Produto();
		produto.setCodigo(rs.getInt("codigo"));
		produto.setNome(rs.getString("nome"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setPreco(rs.getFloat("preco"));
		return produto;
	};
	
	@Override
	public void create(Produto produto) {
		String sql = "INSERT INTO produtos(nome, descricao, preco) VALUES (?, ?, ?)";
		int insert = jdbcTemplate.update(sql, produto.getNome(), produto.getDescricao(), produto.getPreco());
		
		if(insert == 1) {
			log.info(String.format("Produto (%s) adicionado no banco de dados.", produto.getNome()));
		}
	}

	@Override
	public List<Produto> read() {
		String sql = "SELECT * FROM produtos";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void update(Produto produto, int codigo) {
		String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ? WHERE codigo = ?";
		int update =jdbcTemplate.update(sql, produto.getNome(), produto.getDescricao(), produto.getPreco(), codigo);
		
		if(update == 1) {
			log.info(String.format("Produto (%s) atualizado no banco de dados.", produto.getNome()));
		} else {
			log.info(String.format("Produto nao encontrado."));
		}
	}

	@Override
	public void delete(int codigo) {
		String sql = "DELETE FROM produtos WHERE codigo = ?";
		int delete = jdbcTemplate.update(sql, codigo);
		
		if(delete == 1) {
			log.info(String.format("Produto de id (%s) foi removido do banco de dados.", codigo));
		} else {
			log.info("Produto nao encontrado.");
		}
	}
	
	@Override
	public List<Produto> selectByString(String nome) {
		String sql = "SELECT * FROM produtos WHERE LOWER(nome) LIKE LOWER('%' || ? || '%')";
		return jdbcTemplate.query(sql, rowMapper, nome);
	}
	
	@Override
	public Optional<Produto> selectById(int codigo) {
		String sql = "SELECT codigo, nome, descricao, preco FROM produtos WHERE codigo = ?";
		Produto produto = null;
		
		try {
			produto = jdbcTemplate.queryForObject(sql, rowMapper, codigo);
			
		} catch(DataAccessException e) {
			log.info("Produto não encontrado.");
		}

		return Optional.ofNullable(produto);
	}
}