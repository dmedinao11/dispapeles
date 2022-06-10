package com.dmedinao.dispapeles.cliente.modelos;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_identificacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoIdentificaion {
    @Id
    private Long id;

    private String nombre;
}
