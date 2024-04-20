package com.hatertruck.RedeBaratto.controller;

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

import com.hatertruck.RedeBaratto.dao.VendedorJdbc;
import com.hatertruck.RedeBaratto.model.Vendedor;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorJdbc vendedorJdbc;

    @ResponseBody
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarVendedor(@RequestBody Vendedor vendedor) {
        vendedorJdbc.create(vendedor);
    }

    @ResponseBody
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Vendedor> listarVendedores() {
        return vendedorJdbc.read();
    }

    @ResponseBody
    @PutMapping("/atualizar/{cpfVendedor}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarVendedor(@PathVariable String cpfVendedor, @RequestBody Vendedor vendedorAtualizado) {
        vendedorAtualizado.setCpfVendedor(cpfVendedor);
        vendedorJdbc.update(vendedorAtualizado, cpfVendedor);
    }

    @ResponseBody
    @DeleteMapping("/deletar/{cpfVendedor}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarVendedor(@PathVariable String cpfVendedor) {
        vendedorJdbc.delete(cpfVendedor);
    }

    @ResponseBody
    @GetMapping("/listar/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vendedor> listarVendedoresPorNome(@PathVariable String nome) {
        return vendedorJdbc.selectByString(nome);
    }

    @ResponseBody
    @GetMapping("/{cpfVendedor}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Vendedor> pegarVendedor(@PathVariable String cpfVendedor) {
        return vendedorJdbc.selectByCpf(cpfVendedor);
    }
}
