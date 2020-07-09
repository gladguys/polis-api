package com.gladguys.polisapi.repositories.impl;

import com.gladguys.polisapi.models.dto.ComentarioDTO;
import com.gladguys.polisapi.repositories.CustomComentarioRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomComentarioRepositoryImpl implements CustomComentarioRepository {

    private JdbcTemplate jdbcTemplate;

    public CustomComentarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ComentarioDTO> getComentariosByPostId(String postId) {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT count(sc.*) as qntSubComentarios, c.* FROM comentario c ")
                .append(" LEFT JOIN sub_comentario sc on c.id = sc.comentario_pai_id ")
                .append(" WHERE c.post_id = ").append(postId)
                .append(" GROUP BY (c.id) ");

        return this.jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(ComentarioDTO.class));
    }
}
