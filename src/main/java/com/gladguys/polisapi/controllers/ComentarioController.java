package com.gladguys.polisapi.controllers;

import com.gladguys.polisapi.models.Comentario;
import com.gladguys.polisapi.models.dto.ComentarioDTO;
import com.gladguys.polisapi.models.dto.SubComentarioDTO;
import com.gladguys.polisapi.services.ComentarioFirestoreService;
import com.gladguys.polisapi.services.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comentarios")
public class ComentarioController {

    private ComentarioService comentarioService;
    private ComentarioFirestoreService comentarioFirestoreService;

    public ComentarioController(ComentarioService comentarioService, ComentarioFirestoreService comentarioFirestoreService) {
        this.comentarioService = comentarioService;
        this.comentarioFirestoreService = comentarioFirestoreService;
    }

    @PostMapping
    public ResponseEntity<Comentario> salvar(@RequestBody Comentario comentario) {
        Comentario comentarioSalvo = comentarioService.salvar(comentario);
        comentarioFirestoreService.incrementarContadorComentarios(comentario);
        return ResponseEntity.ok(comentarioSalvo);
    }

    @PutMapping
    public ResponseEntity<Comentario> editar(@RequestBody Comentario comentario) {
        Comentario comentarioSalvo = comentarioService.salvar(comentario);
        return ResponseEntity.ok(comentarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> buscarComentariosDoPost(@RequestParam("postId") String postId) {
        List<ComentarioDTO> comentarios = comentarioService.buscarComentariosPorPostId(postId);
        return ResponseEntity.ok(comentarios);
    }

    @DeleteMapping(value = "/{comentarioId}")
    public ResponseEntity deletar(@PathVariable("comentarioId") Long comentarioId) {
        try {
            this.comentarioService.deletarComentarioById(comentarioId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/subs/{subId}")
    public ResponseEntity deletarSubComentario(@PathVariable("subId") Long subId) {
        try {
            this.comentarioService.deletarSubComentarioById(subId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/{comentarioId}/subs")
    public ResponseEntity<SubComentarioDTO> salvarSubComentario(@PathVariable("comentarioId") Long comentarioId,
                                                             @RequestBody SubComentarioDTO subComentarioDTO) throws Exception {
        SubComentarioDTO subComentarioDTOSalvo = comentarioService.salvarSubComentario(subComentarioDTO);
        return ResponseEntity.ok(subComentarioDTOSalvo);
    }

    @PutMapping(value = "/{comentarioId}/subs")
    public ResponseEntity<SubComentarioDTO> editarSubComentario(@PathVariable("comentarioId") Long comentarioId,
                                                             @RequestBody SubComentarioDTO subComentarioDTO) throws Exception {
        SubComentarioDTO subComentarioDTOSalvo = comentarioService.salvarSubComentario(subComentarioDTO);
        return ResponseEntity.ok(subComentarioDTOSalvo);
    }

    @GetMapping("/{comentarioId}/subs")
    public ResponseEntity<List<SubComentarioDTO>> buscarSubcomentariosDoComentario(@PathVariable("comentarioId") Long comentarioId) {
        List<SubComentarioDTO> subComentarios = comentarioService.buscarSubComentariosDeComentario(comentarioId);
        return ResponseEntity.ok(subComentarios);
    }
}