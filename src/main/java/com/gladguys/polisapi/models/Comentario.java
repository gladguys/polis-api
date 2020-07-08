package com.gladguys.polisapi.models;

import lombok.Data;

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

    private String usuarioNome;

    private String diaHora;

    private String postId;

    private boolean foiEditado;

}
