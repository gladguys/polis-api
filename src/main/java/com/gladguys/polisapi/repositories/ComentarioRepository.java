package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>, CustomComentarioRepository {

    List<Comentario> findByPostId(String postId);
}
