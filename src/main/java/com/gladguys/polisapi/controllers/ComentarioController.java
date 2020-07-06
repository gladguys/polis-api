package com.gladguys.polisapi.controllers;

import com.gladguys.polisapi.models.Comentario;
import com.gladguys.polisapi.models.SubComentario;
import com.gladguys.polisapi.services.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comentarios")
public class ComentarioController {

    private ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<Comentario> salvar(@RequestBody Comentario comentario) {
        Comentario comentarioSalvo = comentarioService.salvar(comentario);
        return ResponseEntity.ok(comentarioSalvo);
    }

    @PostMapping(value = "/{comentarioId}/subs")
    public ResponseEntity<SubComentario> salvarSubComentario(@PathVariable("comentarioId") Long comentarioId,
                                                             @RequestBody SubComentario subComentario) {

        SubComentario comentarioSalvo = comentarioService.salvarSubComentario(subComentario);
        return ResponseEntity.ok(comentarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> ComentariosDaAtividade(@RequestParam("postId") String postId) {
        List<Comentario> comentarios = comentarioService.buscarComentariosPorPostId(postId);
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/{comentarioId}/subs")
    public ResponseEntity<List<SubComentario>> subComentariosDoComentario(@PathVariable("comentarioId") Long comentarioId) {
        List<SubComentario> subComentarios = comentarioService.buscarSubComentariosDeComentario(comentarioId);
        return ResponseEntity.ok(subComentarios);
    }
}