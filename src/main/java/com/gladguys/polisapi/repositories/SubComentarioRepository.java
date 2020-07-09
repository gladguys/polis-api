package com.gladguys.polisapi.repositories;

import com.gladguys.polisapi.models.SubComentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubComentarioRepository extends JpaRepository<SubComentario, Long>, CustomSubComentarioRepository { }
