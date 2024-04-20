package com.hatertruck.RedeBaratto.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hatertruck.RedeBaratto.factory.ConnectionFactory;
import com.hatertruck.RedeBaratto.model.Cliente;

@Component
public class ClienteJdbc {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteJdbc.class);
    private final JdbcTemplate jdbcTemplate;

    public ClienteJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Cliente> rowMapper = (rs, rowNum) -> {
        Cliente cliente = new Cliente(
            rs.getString("cpf_cliente"),
            rs.getString("prim_nome"),
            rs.getString("ult_nome"),
            rs.getString("senha"),
            rs.getBoolean("is_flamengo"),
            rs.getBoolean("one_piece_fan"),
            rs.getBoolean("sousense")
        );
        return cliente;
    };
	
    public void create(Cliente cliente) {
    	 try (Connection conn = ConnectionFactory.createConnection()) {
             CallableStatement stmt = conn.prepareCall("CALL InserirCliente(?, ?, ?, ?, ?, ?, ?, ?)");

             stmt.setString(1, cliente.getCpf());
             stmt.setString(2, cliente.getPrimeiroNome());
             stmt.setString(3, cliente.getUltimoNome());
             stmt.setString(4, cliente.getSenha());
             stmt.setBoolean(5, cliente.isFlamengo());
             stmt.setBoolean(6, cliente.isOnePieceFan());
             stmt.setBoolean(7, cliente.isSousense());

             stmt.registerOutParameter(8, Types.VARCHAR);
             
             stmt.execute();

             String cpfNovo = (String) stmt.getObject(8);
             log.info("Cliente novo {}", cpfNovo);
             conn.close();

         } catch (SQLException e) {
        	 log.info("Cliente não foi inserido no banco de dados.");
             e.printStackTrace();
         }
    }
	
    public List<Cliente> read() {
        List<Cliente> clientes = null;
        
        try {
        	String sql = "SELECT * FROM cliente";
        	clientes = jdbcTemplate.query(sql, rowMapper);  
	        if(clientes.isEmpty())
	        	log.info("Não há clientes cadastrados.");
	        
        } catch(Exception e) {
        	log.info("Não há clientes cadastrados.");
        }
        
        return clientes;
    }
    
    public void update(Cliente cliente, String cpf) {
    	try (Connection conn = ConnectionFactory.createConnection()) {
            CallableStatement stmt = conn.prepareCall("CALL AtualizarCliente(?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getPrimeiroNome());
            stmt.setString(3, cliente.getUltimoNome());
            stmt.setString(4, cliente.getSenha());
            stmt.setBoolean(5, cliente.isFlamengo());
            stmt.setBoolean(6, cliente.isOnePieceFan());
            stmt.setBoolean(7, cliente.isSousense());

            stmt.execute();

            log.info("Cliente {} atualizado no banco de dados.", cliente.getCpf());
            conn.close();
        } catch (SQLException e) {
        	log.info("Cliente não encontrado.");
            e.printStackTrace();
        }
   }

    public void delete(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf_cliente = ?";
        int delete = jdbcTemplate.update(sql, cpf);
        if (delete == 1) {
            log.info("Cliente {} foi removido do banco de dados.", cpf);
        }
    }
    
    public Optional<Cliente> selectByCpf(String cpf) {
    	String sql = "SELECT * FROM ConsultarClientePorCPF(?)";
    	Cliente cliente = null;
    	
    	try {
    		cliente = jdbcTemplate.queryForObject(sql, rowMapper, cpf);
            log.info("Cliente {} encontrado no banco de dados.", cliente.getCpf());
            
        } catch (DataAccessException e) {
        	log.info("Cliente não encontrado.");
        }
    	
    	return Optional.ofNullable(cliente);
    }
    
	public List<Cliente> selectByString(String s) {
		String sql = "SELECT * FROM cliente WHERE LOWER(prim_nome) LIKE LOWER('%' || ? || '%')";
		return jdbcTemplate.query(sql, rowMapper, s);
	}

}
