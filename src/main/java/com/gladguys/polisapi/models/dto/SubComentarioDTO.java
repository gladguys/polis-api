package com.gladguys.polisapi.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubComentarioDTO {

    private Long id;

    private String texto;

    private String usuarioId;

    private String usuarioNome;

    private LocalDateTime diaHora;

    private String postId;

    private boolean foiEditado;

    private Long comentarioPaiId;
}
