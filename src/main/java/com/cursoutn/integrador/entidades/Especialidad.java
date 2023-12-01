package com.cursoutn.integrador.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "especialidad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Especialidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "sistemaOperativo")
    private String sistemaOperativo;
    @Column(name = "activo")
    private boolean activo;

}
