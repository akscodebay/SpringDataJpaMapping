package org.datamapping.springdatajpamapping.dbrepository;

import org.datamapping.springdatajpamapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
