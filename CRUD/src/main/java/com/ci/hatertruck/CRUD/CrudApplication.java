package com.ci.hatertruck.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ci.hatertruck.CRUD.dao.DAO;
import com.ci.hatertruck.CRUD.model.Produto;

@SpringBootApplication
public class CrudApplication {
	
	private static DAO<Produto> dao;
	
	public CrudApplication(DAO<Produto> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
