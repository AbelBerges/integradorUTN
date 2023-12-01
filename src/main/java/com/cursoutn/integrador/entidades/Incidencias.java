package com.cursoutn.integrador.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "incidencias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Incidencias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "fechaInicio")
//    private Date fechaIncio;
    @Column(name ="descripcion")
    private String descripcion;
    @Column(name = "cantidadHoras")
    private int cantidadHoras;
    @Column(name = "rangoHorario")
    private String rangoHorario;
    @Column(name = "finalizado")
    private boolean finalizado;
    //Armo las relaciones de la base de datos
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="idCliente")
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTecnico")
    private Tecnico tecnico;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCalificaciones")
    private Calificacion calificacion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstado")
    private Estado estado;
}
