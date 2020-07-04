package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, String> {}
