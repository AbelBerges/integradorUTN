package com.cursoutn.integrador.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tecnico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tecnico extends Persona{
    @Column(name = "area")
    private String area;
//    @Column(name = "fechaRangoInicio")
//    private Date fechaRangoIncio;
//    @Column(name = "fechaRangoFinal")
//    private Date fechaRangoFinal;
    @Column(name = "cobertura")
    private String cobertura;
    @Column(name = "curricula")
    private String curricula;
    @Column(name = "correo")
    private String correo;
}
