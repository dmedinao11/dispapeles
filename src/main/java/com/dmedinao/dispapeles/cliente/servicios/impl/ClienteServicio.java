package com.dmedinao.dispapeles.cliente.servicios.impl;

import com.dmedinao.dispapeles.cliente.daos.ClienteDAO;
import com.dmedinao.dispapeles.cliente.modelos.Cliente;
import com.dmedinao.dispapeles.cliente.modelos.TipoIdentificaion;
import com.dmedinao.dispapeles.cliente.modelos.dto.ClienteDTO;
import com.dmedinao.dispapeles.cliente.servicios.ClienteServicioInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteServicio implements ClienteServicioInterface {
    private final ClienteDAO clienteDAO;

    @Override
    public List<ClienteDTO> obtenerTodo() {
        try {
            final List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();
            return clientes.stream().map(ClienteDTO::crearDesdeEntidad).collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error desconocido");
        }
    }

    @Override
    public ClienteDTO obtenerPorId(Long id) {
        try {
            final List<Cliente> clientes = (List<Cliente>) clienteDAO.findAllById(Collections.singleton(id));
            final Cliente cliente =
                    clientes
                            .stream()
                            .findFirst()
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
            return ClienteDTO.crearDesdeEntidad(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error desconocido");
        }
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO cliente) {
        try {
            final Cliente clienteAGuardar = ClienteDTO.convertirAEntidad(cliente);
            final Cliente clienteGuardado = clienteDAO.save(clienteAGuardar);
            clienteAGuardar.setId(clienteGuardado.getId());
            return ClienteDTO.crearDesdeEntidad(clienteAGuardar);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error desconocido");
        }
    }

    @Override
    public ClienteDTO actualizarCliente(Long id, ClienteDTO cliente) {
        try {
            final List<Cliente> clientes = (List<Cliente>) clienteDAO.findAllById(Collections.singleton(id));
            final Cliente clienteGuardado =
                    clientes
                            .stream()
                            .findFirst()
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));

            actualizarClienteDesdeDTO(clienteGuardado, cliente);

            clienteDAO.save(clienteGuardado);
            return cliente;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error desconocido");
        }
    }

    @Override
    public Long eliminarClientePorId(Long id) {
        try {
            clienteDAO.delete(Cliente.builder().id(id).build());
            return id;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error desconocido");
        }
    }

    private void actualizarClienteDesdeDTO(Cliente clienteGuardado, ClienteDTO cliente) {
        clienteGuardado.setNombre(cliente.getNombre());
        clienteGuardado.setApellidos(cliente.getApellidos());
        clienteGuardado.setEdad(cliente.getEdad());
        clienteGuardado.setTeleforno(cliente.getTeleforno());
        clienteGuardado.setDireccion(cliente.getDireccion());
        clienteGuardado.setTipoIdentificacion(TipoIdentificaion.builder().id(cliente.getTipoIdentificacion()).build());
    }

}
