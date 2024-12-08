package com.ufps.seguimientoGraduados.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class OfertaEmpleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ofertaId;
    private String titulo;
    private String descripcion;
    private String imageUrl;
    private String contacto;
    private LocalDateTime createdAt;
    private boolean activeOferta;

    @ManyToMany @JoinTable( name = "oferta_user", joinColumns = @JoinColumn(name = "oferta_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserApp> userList = new ArrayList<>();
}
