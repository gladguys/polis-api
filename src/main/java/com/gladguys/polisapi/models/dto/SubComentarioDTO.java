package com.gladguys.polisapi.models.dto;

import com.gladguys.polisapi.models.Comentario;
import com.gladguys.polisapi.models.SubComentario;
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

    public SubComentario toEntity() {
        SubComentario subComentario = new SubComentario();
        subComentario.setId(id);
        subComentario.setFoiEditado(foiEditado);
        subComentario.setDiaHora(diaHora);
        subComentario.setPostId(postId);
        subComentario.setUsuarioId(usuarioId);
        subComentario.setTexto(texto);
        subComentario.setUsuarioNome(usuarioNome);

        Comentario comentario = new Comentario();
        comentario.setId(comentarioPaiId);
        subComentario.setComentarioPai(comentario);

        return subComentario;
    }
}
