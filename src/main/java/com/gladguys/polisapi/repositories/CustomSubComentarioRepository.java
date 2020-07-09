package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.dto.ComentarioDTO;
import com.gladguys.polisapi.models.dto.SubComentarioDTO;

import java.util.List;

public interface CustomSubComentarioRepository {
    List<SubComentarioDTO> getSubComentariosByComentarioId(Long comentarioId);
}
