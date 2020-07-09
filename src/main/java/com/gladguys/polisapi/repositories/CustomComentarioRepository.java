package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.dto.ComentarioDTO;
import com.gladguys.polisapi.models.dto.SubComentarioDTO;

import java.util.List;

public interface CustomComentarioRepository {

    List<ComentarioDTO> getComentariosByPostId(String postId);
    List<SubComentarioDTO> getSubComentariosByComentarioId(Long comentarioId);
}
