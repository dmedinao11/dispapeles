package com.dmedinao.dispapeles.cliente.servicios;

import com.dmedinao.dispapeles.cliente.modelos.dto.ClienteDTO;

import java.util.List;

public interface ClienteServicioInterface {

    List<ClienteDTO> obtenerTodo();

    ClienteDTO obtenerPorId(Long id);

    ClienteDTO crearCliente(ClienteDTO cliente);

    ClienteDTO actualizarCliente(Long id, ClienteDTO cliente);

    Long eliminarClientePorId(Long id);
}
