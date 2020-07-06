package com.gladguys.polisapi.services;

import com.gladguys.polisapi.models.Comentario;
import com.gladguys.polisapi.models.SubComentario;
import com.gladguys.polisapi.repositories.ComentarioRepository;
import com.gladguys.polisapi.repositories.SubComentarioRepository;
import org.springframework.stereotype.Service;

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
        return this.comentarioRepository.save(comentario);
    }

    public List<Comentario> buscarComentariosPorPostId(String postId) {
        return this.comentarioRepository.findByPostId(postId);
    }

    public SubComentario salvarSubComentario(SubComentario subComentario) {
        return this.subComentarioRepository.save(subComentario);
    }

    public List<SubComentario> buscarSubComentariosDeComentario(Long comentarioId) {

        return this.subComentarioRepository.findByComentarioPaiId(comentarioId);
    }
}
