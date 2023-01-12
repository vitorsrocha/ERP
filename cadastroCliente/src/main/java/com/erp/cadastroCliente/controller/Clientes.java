package com.erp.cadastroCliente.controller;

import com.erp.cadastroCliente.exeptions.ResourceNotFoundException;
import com.erp.cadastroCliente.models.Cliente;
import com.erp.cadastroCliente.repositores.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class Clientes {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente){
        return new ResponseEntity<>(repository.save(cliente), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        verificaCliente(id);
        repository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    private void verificaCliente(Long id){
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

}
