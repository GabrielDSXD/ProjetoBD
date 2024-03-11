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

import com.ci.hatertruck.CRUD.dao.RelatorioJdbcDao;
import com.ci.hatertruck.CRUD.model.Relatorio;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioJdbcDao relatorioDAO;

    @ResponseBody
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarRelatorio(@RequestBody Relatorio relatorio) {
        relatorioDAO.create(relatorio);
    }

    @ResponseBody
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Relatorio> listarRelatorios() {
        return relatorioDAO.read();
    }

    @ResponseBody
    @PutMapping("/{codigoRelatorio}/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarRelatorio(@PathVariable Integer codigoRelatorio, @RequestBody Relatorio relatorioAtualizado) {
        relatorioAtualizado.setCodigo(codigoRelatorio);
        relatorioDAO.update(relatorioAtualizado, relatorioAtualizado.getCodigo());
    }

    @ResponseBody
    @DeleteMapping("/{codigoRelatorio}/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void deletarRelatorio(@PathVariable Integer codigoRelatorio) {
        relatorioDAO.delete(codigoRelatorio);
    }

    @ResponseBody
    @GetMapping("/{codigoRelatorio}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Relatorio> pegarRelatorio(@PathVariable Integer codigoRelatorio) {
        return relatorioDAO.selectById(codigoRelatorio);
    }
}
