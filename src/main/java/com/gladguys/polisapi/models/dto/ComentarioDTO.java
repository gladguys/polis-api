package com.gladguys.polisapi.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gladguys.polisapi.models.Comentario;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class ComentarioDTO {

    private Long id;

    private String texto;

    private String usuarioId;

    private String usuarioNome;

    private LocalDateTime diaHora;

    private String postId;

    private boolean foiEditado;

}
