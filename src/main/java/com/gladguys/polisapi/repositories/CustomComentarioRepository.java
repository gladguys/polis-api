package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.dto.ComentarioDTO;

import java.util.List;

public interface CustomComentarioRepository {
    List<ComentarioDTO> getComentariosByPostId(String postId);
}
