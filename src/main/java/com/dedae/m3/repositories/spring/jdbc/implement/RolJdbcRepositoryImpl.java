package com.dedae.m3.repositories.spring.jdbc.implement;


import com.dedae.m3.dto.RolDTO;
import com.dedae.m3.repositories.spring.jdbc.RolJbdcRepository;
import com.dedae.m3.repositories.spring.jdbc.row.mapper.RolRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolJdbcRepositoryImpl implements RolJbdcRepository {

    private final JdbcTemplate jdbcTemplate;

    public RolJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<RolDTO> listRoles() {
        var sql = """
                SELECT id, name
                FROM rol;
                """;
        return jdbcTemplate.query(sql, new RolRowMapper());
    }

    @Override
    public Optional<RolDTO> getRolById(Integer id) {

        var sql = """
                SELECT id, name
                FROM rol
                WHERE id=?;
                """;
        return jdbcTemplate.query(sql, new RolRowMapper(),  id)
                .stream()
                .findFirst();
    }

    @Override
    public int save(RolDTO rolDTO) {

        var sql = """
                INSERT INTO rol (id, name) VALUES (nextval('rol_sequence'), ?);              
                """;
        return jdbcTemplate.update(sql, rolDTO.getName());
    }

    @Override
    public int delete(Integer id) {
        var sql = """
                DELETE FROM rol WHERE id=?;
                """;
        return jdbcTemplate.update(sql, id);
    }
}
