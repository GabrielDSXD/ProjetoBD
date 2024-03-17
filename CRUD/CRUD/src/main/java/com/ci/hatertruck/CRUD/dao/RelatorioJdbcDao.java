package com.ci.hatertruck.CRUD.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ci.hatertruck.CRUD.model.Relatorio;

@Component
public class RelatorioJdbcDao implements DAO<Relatorio> {

	private static final Logger log = LoggerFactory.getLogger(ProdutoJdbcDao.class);
	private JdbcTemplate jdbcTemplate;

	public RelatorioJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	RowMapper<Relatorio> rowMapper = (rs, rowNum) -> {
		Relatorio relatorio = new Relatorio();
		relatorio.setCodigo(rs.getInt("codigo"));
		relatorio.setCodigoLoja(rs.getInt("codigoLoja"));
		relatorio.setFaturamento(rs.getFloat("faturamento"));
		relatorio.setEstoque(rs.getInt("estoque"));
		relatorio.setData(rs.getDate("data"));
		return relatorio;
	};

	@Override
	public void create(Relatorio relatorio) {
		String sql = "INSERT INTO RELATORIOS (codigo_loja, faturamento, estoque, data) VALUES (?, ?, ?, ?)";
		int insert = jdbcTemplate.update(sql, relatorio.getCodigoLoja(), relatorio.getFaturamento(), relatorio.getEstoque(), relatorio.getData());

		if (insert == 1) {
			log.info(String.format("Relatorio da loja com codigo (%d) adicionado no banco de dados.", relatorio.getCodigoLoja()));
		}
	}

	@Override
	public List<Relatorio> read() {
		String sql = "SELECT * FROM RELATORIOS";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void update(Relatorio relatorio, int codigo) {
		String sql = "UPDATE RELATORIOS SET codigo_loja = ?, faturamento = ?, estoque = ?, data = ? WHERE codigo = ?";
		int update = jdbcTemplate.update(sql, relatorio.getCodigoLoja(), relatorio.getFaturamento(), relatorio.getEstoque(), relatorio.getData(), codigo);

		if (update == 1) {
			log.info(String.format("Relatorio da loja com codigo (%d) atualizado no banco de dados.", relatorio.getCodigoLoja()));
		} else {
			log.info(String.format("Relatorio nao encontrado."));
		}
	}

	@Override
	public void delete(int codigo) {
		String sql = "DELETE FROM relatorios WHERE codigo = ?";
		int delete = jdbcTemplate.update(sql, codigo);

		if (delete == 1) {
			log.info(String.format("Relatorio com codigo (%d) foi removido do banco de dados.", codigo));
		} else {
			log.info("Relatorio nao encontrado.");
		}
	}

	@Override
	public List<Relatorio> selectByString(String nome) {
		String sql = "SELECT * FROM PRODUTOS WHERE LOWER(nome) LIKE LOWER('%' || ? || '%')";
		return jdbcTemplate.query(sql, rowMapper, nome);
	}

	@Override
	public Optional<Relatorio> selectById(int codigo) {
		String sql = "SELECT codigo, codigo_loja, faturamento, estoque, data FROM relatorios WHERE codigo = ?";
		Relatorio relatorio = null;

		try {
			relatorio = jdbcTemplate.queryForObject(sql, rowMapper, codigo);

		} catch (DataAccessException e) {
			log.info("Relatorio não encontrado.");
		}

		return Optional.ofNullable(relatorio);
	}
}
