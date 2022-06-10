package com.dmedinao.dispapeles.cliente.modelos;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellidos;

    private Integer edad;

    private String teleforno;

    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_identificacion", referencedColumnName = "id")
    private TipoIdentificaion tipoIdentificacion;

}
