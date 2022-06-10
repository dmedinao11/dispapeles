package com.dmedinao.dispapeles.cliente.modelos.dto;

import com.dmedinao.dispapeles.cliente.modelos.Cliente;
import com.dmedinao.dispapeles.cliente.modelos.TipoIdentificaion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String teleforno;
    private String direccion;
    private Long tipoIdentificacion;
    private String tipoIdentificacionNombre;

    public static ClienteDTO crearDesdeEntidad(Cliente cliente){
        return ClienteDTO
                .builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellidos(cliente.getApellidos())
                .edad(cliente.getEdad())
                .teleforno(cliente.getTeleforno())
                .direccion(cliente.getDireccion())
                .tipoIdentificacion(cliente.getTipoIdentificacion().getId())
                .tipoIdentificacionNombre(cliente.getTipoIdentificacion().getNombre())
                .build();
    }

    public static Cliente convertirAEntidad(ClienteDTO clienteDTO){
        final TipoIdentificaion tipoIdentificaion =
                TipoIdentificaion.builder().id(clienteDTO.getTipoIdentificacion()).build();


        return Cliente
                .builder()
                .id(clienteDTO.getId())
                .nombre(clienteDTO.getNombre())
                .apellidos(clienteDTO.getApellidos())
                .edad(clienteDTO.getEdad())
                .teleforno(clienteDTO.getTeleforno())
                .direccion(clienteDTO.getDireccion())
                .tipoIdentificacion(tipoIdentificaion)
                .build();
    }
}
