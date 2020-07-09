package com.gladguys.polisapi.services;

import com.gladguys.polisapi.models.Comentario;
import com.gladguys.polisapi.models.SubComentario;
import com.gladguys.polisapi.models.dto.ComentarioDTO;
import com.gladguys.polisapi.repositories.ComentarioRepository;
import com.gladguys.polisapi.repositories.SubComentarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioService {

    private ComentarioRepository comentarioRepository;
    private SubComentarioRepository subComentarioRepository;


    public ComentarioService(ComentarioRepository comentarioRepository, SubComentarioRepository subComentarioRepository) {
        this.comentarioRepository = comentarioRepository;
        this.subComentarioRepository = subComentarioRepository;
    }

    public Comentario salvar(Comentario comentario) {
        comentario.setDiaHora(LocalDateTime.now());
        return this.comentarioRepository.save(comentario);
    }

    public List<ComentarioDTO> buscarComentariosPorPostId(String postId) {
        return this.comentarioRepository.getComentariosByPostId(postId);
    }

    public SubComentario salvarSubComentario(SubComentario subComentario) {
        subComentario.setDiaHora(LocalDateTime.now());
        return this.subComentarioRepository.save(subComentario);
    }

    public List<SubComentario> buscarSubComentariosDeComentario(Long comentarioId) {

        return this.subComentarioRepository.findByComentarioPaiId(comentarioId);
    }
}
