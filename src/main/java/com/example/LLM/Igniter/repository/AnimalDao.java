package com.example.LLM.Igniter.repository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnimalDao {

    JdbcTemplate jdbcTemplate;

    private static final String GET_ANIMAL_QUERY = "SELECT " +
            "nome FROM animais WHERE id = ?";

    public String getAnimal(int id) {

        String animal = jdbcTemplate.query(GET_ANIMAL_QUERY, new Object[]{id}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("nome");  // Retorna o nome do animal
            }
        }).stream().findFirst().orElse(null);

        log.info("O animal selecionado foi o(a) '{}', id={}", animal, id);
        return animal;
    }



}
