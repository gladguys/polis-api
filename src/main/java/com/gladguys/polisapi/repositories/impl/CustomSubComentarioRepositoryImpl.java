package com.gladguys.polisapi.repositories.impl;

import com.gladguys.polisapi.models.dto.ComentarioDTO;
import com.gladguys.polisapi.models.dto.SubComentarioDTO;
import com.gladguys.polisapi.repositories.CustomComentarioRepository;
import com.gladguys.polisapi.repositories.CustomSubComentarioRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomSubComentarioRepositoryImpl implements CustomSubComentarioRepository {

    private JdbcTemplate jdbcTemplate;

    public CustomSubComentarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SubComentarioDTO> getSubComentariosByComentarioId(Long comentarioId) {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM sub_comentario ")
                .append(" WHERE comentario_pai_id = ").append(comentarioId);

        return this.jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SubComentarioDTO.class));
    }
}
