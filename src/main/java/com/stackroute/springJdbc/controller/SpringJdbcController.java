package com.stackroute.springJdbc.controller;

import com.stackroute.springJdbc.domain.Student;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;

    public ResponseEntity<String> executeShow() {
        Student entity = springJdbcRepository.get("L-105");
        return new ResponseEntity("Student: " + entity.getId()
                + ", " + entity.getFirstName(), HttpStatus.OK);
    }

    public ResponseEntity<String> insert() {
        Student entity = new Student("Xyz", "X-106");
        springJdbcRepository.add(entity);
        return new ResponseEntity("Student Add: " + entity.getId()
                + ", " + entity.getFirstName(), HttpStatus.OK);
    }

    public ResponseEntity<String> read() {
        Student entity = springJdbcRepository.get("A-106"
        );
        return new ResponseEntity("Student Get: " + entity.getId()
                + ", " + entity.getFirstName(), HttpStatus.OK);
    }

    public ResponseEntity<String> update() {
        Student entity = new Student("Kiran", "K-104");
        springJdbcRepository.update(entity);
        return new ResponseEntity("Student Update: " + entity.getId()
                + ", " + entity.getFirstName(), HttpStatus.OK);
    }

    public ResponseEntity<String> delete() {
        Student entity = new Student("Kiran", "K-104");
        springJdbcRepository.delete(entity);
        return new ResponseEntity("Student Delete: " + entity.getId()
                + ", " + entity.getFirstName(), HttpStatus.OK);
    }
    public ResponseEntity<?> getAll() {
        List<Student> studentList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
    }
}
