package com.gladguys.polisapi.models;

import com.gladguys.polisapi.models.dto.SubComentarioDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public SubComentarioDTO toDTO() {
        SubComentarioDTO subComentarioDTO = new SubComentarioDTO();
        subComentarioDTO.setId(id);
        subComentarioDTO.setComentarioPaiId(comentarioPai.getId());
        subComentarioDTO.setDiaHora(diaHora);
        subComentarioDTO.setTexto(texto);
        subComentarioDTO.setPostId(postId);
        subComentarioDTO.setUsuarioNome(usuarioNome);
        subComentarioDTO.setFoiEditado(foiEditado);
        subComentarioDTO.setUsuarioId(usuarioId);
        return subComentarioDTO;
    }
}
