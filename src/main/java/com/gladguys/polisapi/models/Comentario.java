package com.gladguys.polisapi.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Lob
    private String texto;

    private LocalDateTime diaHora;

    private String postId;

    @ManyToOne
    private Comentario comentarioPai;

    @OneToMany(mappedBy = "comentarioPai")
    private List<Comentario> comentariosFilhos;

}
