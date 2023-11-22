package com.dedae.m3.repositories.spring.jdbc.row.mapper;


import com.dedae.m3.dto.RolDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolRowMapper implements RowMapper<RolDTO> {


    @Override
    public RolDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RolDTO(
                rs.getInt("id"),
                rs.getString("name")
        );
    }
}
