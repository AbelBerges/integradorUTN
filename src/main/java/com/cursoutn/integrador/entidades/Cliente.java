package com.cursoutn.integrador.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente extends Persona{
    @Column(name = "cuit")
    private long cuit;
    @Column(name = "razonSocial")
    private String razonSocial;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "activo")
    private boolean activo;
}
