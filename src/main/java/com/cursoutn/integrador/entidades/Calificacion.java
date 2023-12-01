package com.cursoutn.integrador.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "calificacion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Calificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "califica")
    private int califica;
    @Column(name = "comentario")
    private String comentario;
    //Construyo las relaciones
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTecnico")
    private Tecnico tecnico;
}
