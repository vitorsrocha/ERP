package com.erp.cadastroCliente.controller;

import com.erp.cadastroCliente.models.Produto;
import com.erp.cadastroCliente.repositores.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class Produtos {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar(){
        return repository.findAll();
    }

    @PostMapping
    public Produto inserir(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @DeleteMapping(path = "{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
