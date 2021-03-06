package com.gladguys.polisapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class SubComentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private String usuarioId;

    private String usuarioNome;

    private LocalDateTime diaHora;

    private String postId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comentario comentarioPai;

    private boolean foiEditado;
}
