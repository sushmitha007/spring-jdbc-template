package com.stackroute.springJdbc.mapper;

import com.stackroute.springJdbc.domain.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Student student = new Student();
        student.setId(rs.getString("ID"));
        student.setFirstName(rs.getString("FIRST_NAME"));
        return student;
    }
}
