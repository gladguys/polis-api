package com.gladguys.polisapi.services;

import com.gladguys.polisapi.models.Comentario;
import com.gladguys.polisapi.models.SubComentario;
import com.gladguys.polisapi.models.dto.ComentarioDTO;
import com.gladguys.polisapi.models.dto.SubComentarioDTO;
import com.gladguys.polisapi.repositories.ComentarioRepository;
import com.gladguys.polisapi.repositories.SubComentarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioService {

    private ComentarioRepository comentarioRepository;
    private SubComentarioRepository subComentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository,
                             SubComentarioRepository subComentarioRepository) {
        this.comentarioRepository = comentarioRepository;
        this.subComentarioRepository = subComentarioRepository;
    }

    public Comentario salvar(Comentario comentario) {
        if (comentario.getId() != null) return atualizarComentario(comentario);
        else return criarComentario(comentario);
    }

    public List<ComentarioDTO> buscarComentariosPorPostId(String postId) {
        return this.comentarioRepository.getComentariosByPostId(postId);
    }

    public SubComentarioDTO salvarSubComentario(SubComentarioDTO subComentarioDTO) throws Exception {
        SubComentario subComentario = subComentarioDTO.toEntity();
        SubComentario subComentarioSalvo;

        if (subComentario.getId() != null) subComentarioSalvo = atualizarSubComentario(subComentario);
        else subComentarioSalvo = criarSubComentario(subComentario);

        if (subComentarioSalvo != null) return subComentarioSalvo.toDTO();
        else throw new Exception();
    }

    public List<SubComentarioDTO> buscarSubComentariosDeComentario(Long comentarioId) {
        return this.subComentarioRepository.getSubComentariosByComentarioId(comentarioId);
    }

    private Comentario criarComentario(Comentario comentario) {
        comentario.setDiaHora(LocalDateTime.now());
        return this.comentarioRepository.save(comentario);
    }

    private Comentario atualizarComentario(Comentario comentario) {
        comentario.setDiaHora(LocalDateTime.now());
        comentario.setFoiEditado(true);
        return this.comentarioRepository.save(comentario);
    }

    public void deletarComentarioById(Long comentarioId) {
        this.comentarioRepository.deleteById(comentarioId);
    }

    public void deletarSubComentarioById(Long subId) {
        this.subComentarioRepository.deleteById(subId);
    }

    private SubComentario criarSubComentario (SubComentario subComentario) {
        subComentario.setDiaHora(LocalDateTime.now());
        return this.subComentarioRepository.save(subComentario);
    }

    private SubComentario atualizarSubComentario(SubComentario subComentario) {
        subComentario.setDiaHora(LocalDateTime.now());
        subComentario.setFoiEditado(true);
        return this.subComentarioRepository.save(subComentario);
    }
}
