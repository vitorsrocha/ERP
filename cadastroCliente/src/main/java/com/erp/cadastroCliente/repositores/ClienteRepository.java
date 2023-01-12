package com.erp.cadastroCliente.repositores;

import com.erp.cadastroCliente.exeptions.ResourceNotFoundException;
import com.erp.cadastroCliente.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
