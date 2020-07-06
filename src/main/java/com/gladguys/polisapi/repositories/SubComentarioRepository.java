package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.Comentario;
import com.gladguys.polisapi.models.SubComentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubComentarioRepository extends JpaRepository<SubComentario, Long> {

    List<SubComentario> findByComentarioPaiId(Long comentarioId);
}
