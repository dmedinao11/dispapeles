package com.dmedinao.dispapeles.cliente.daos;

import com.dmedinao.dispapeles.cliente.modelos.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {

}
