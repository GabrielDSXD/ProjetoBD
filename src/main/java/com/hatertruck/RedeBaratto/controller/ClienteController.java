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

import com.hatertruck.RedeBaratto.dao.ClienteJdbc;
import com.hatertruck.RedeBaratto.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteJdbc clienteJdbc;

    @ResponseBody
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        clienteJdbc.create(cliente);
    }

    @ResponseBody
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientes() {
        return clienteJdbc.read();
    }

    @ResponseBody
    @PutMapping("/atualizar/{cpfCliente}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarCliente(@PathVariable String cpfCliente, @RequestBody Cliente clienteAtualizado) {
        clienteAtualizado.setCpf(cpfCliente);
        clienteJdbc.update(clienteAtualizado, cpfCliente);
    }

    @ResponseBody
    @DeleteMapping("/deletar/{cpfCliente}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCliente(@PathVariable String cpfCliente) {
        clienteJdbc.delete(cpfCliente);
    }

    @ResponseBody
    @GetMapping("/listar/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientesPorNome(@PathVariable String nome) {
        return clienteJdbc.selectByString(nome);
    }

    @ResponseBody
    @GetMapping("/{cpfCliente}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cliente> pegarCliente(@PathVariable String cpfCliente) {
        return clienteJdbc.selectByCpf(cpfCliente);
    }
}
