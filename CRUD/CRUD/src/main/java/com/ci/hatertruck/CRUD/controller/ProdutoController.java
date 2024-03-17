package com.ci.hatertruck.CRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ci.hatertruck.CRUD.dao.ProdutoJdbcDao;
import com.ci.hatertruck.CRUD.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
    private ProdutoJdbcDao produtoDAO;

	@ResponseBody
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
    public void cadastrarProduto(@RequestBody Produto produto) {
        produtoDAO.create(produto);
    }

	@ResponseBody
	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
    public List<Produto> listarProdutos() {
        return produtoDAO.read();
    }

	@ResponseBody
	@PutMapping("/{codigoProduto}/atualizar")
	@ResponseStatus(HttpStatus.OK)
    public void atualizarProduto(@PathVariable Integer codigoProduto, @RequestBody Produto produtoAtualizado) {
        produtoAtualizado.setCodigo(codigoProduto);
        produtoDAO.update(produtoAtualizado, produtoAtualizado.getCodigo());
    }

	@ResponseBody
	@DeleteMapping("/{codigoProduto}/deletar")
	@ResponseStatus(HttpStatus.OK)
    public void deletarProduto(@PathVariable Integer codigoProduto) {
        produtoDAO.delete(codigoProduto);
    }

	@ResponseBody
	@GetMapping("/listar/{nome}")
	@ResponseStatus(HttpStatus.OK)
    public List<Produto> listarProdutosPorNome(@PathVariable String nome) {
        return produtoDAO.selectByString(nome);
    }

	@ResponseBody
	@GetMapping("/{codigoProduto}")
	@ResponseStatus(HttpStatus.OK)
    public Optional<Produto> pegarProduto(@PathVariable Integer codigoProduto) {
        return produtoDAO.selectById(codigoProduto);
    }
}