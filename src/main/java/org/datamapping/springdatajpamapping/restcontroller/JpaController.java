package org.datamapping.springdatajpamapping.restcontroller;

import org.datamapping.springdatajpamapping.model.Address;
import org.datamapping.springdatajpamapping.model.College;
import org.datamapping.springdatajpamapping.model.Student;
import org.datamapping.springdatajpamapping.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JpaController {

    private final DataService dataService;
    public JpaController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(dataService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/getAllCollege")
    public ResponseEntity<List<College>> getAllCollege() {
        return new ResponseEntity<>(dataService.getAllCollege(), HttpStatus.OK);
    }

    @GetMapping("/getAllAddress")
    public ResponseEntity<List<Address>> getAllAddress() {
        return new ResponseEntity<>(dataService.getAllAddress(), HttpStatus.OK);
    }
}
