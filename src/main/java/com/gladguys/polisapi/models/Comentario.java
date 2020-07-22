package com.gladguys.polisapi.models;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private String usuarioId;

    private String politicoId;

    private String usuarioNome;

    private LocalDateTime diaHora;

    private String postId;

    private boolean foiEditado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comentarioPai", cascade = CascadeType.REMOVE)
    private List<SubComentario> subComentarios;
}
