package com.stackroute.springJdbc.repository;

import com.stackroute.springJdbc.domain.Student;
import com.stackroute.springJdbc.mapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository {
    private JdbcTemplate jdbcTemplate ;

    public SpringJdbcRepository(){}


//    @Autowired
//    public void SpringJdbcRepository(final DataSource dataSource) {
//        this.jdbcTemplate.setDataSource(dataSource);
//    }
    @Autowired
    public void  setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM STUDENT", new StudentRowMapper());
    }

    public int add(final String  id, final String firstName) {
        return jdbcTemplate.update("INSERT INTO STUDENT VALUES (?, ?)", id, firstName);
    }

    public int add(Student entity) {
        return jdbcTemplate.update("INSERT INTO STUDENT VALUES (?, ?)", entity.getId(), entity.getFirstName());
    }

    public Student get(final String id) {
        final String query = "SELECT * FROM STUDENT WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new StudentRowMapper());
    }

    public int update(Student entity) {
        return jdbcTemplate.update("UPDATE STUDENT SET FIRST_NAME=? WHERE ID=?", entity.getFirstName(), entity.getId());
    }


    public int delete(Student entity) {
        return jdbcTemplate.update("DELETE FROM STUDENT WHERE ID=?", entity.getId());
    }

}
