package org.datamapping.springdatajpamapping.service;

import jakarta.transaction.Transactional;
import org.datamapping.springdatajpamapping.dbrepository.AddressRepository;
import org.datamapping.springdatajpamapping.dbrepository.CollegeRepository;
import org.datamapping.springdatajpamapping.dbrepository.StudentRepository;
import org.datamapping.springdatajpamapping.model.Address;
import org.datamapping.springdatajpamapping.model.College;
import org.datamapping.springdatajpamapping.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    private final CollegeRepository collegeRepository;
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    public DataService(CollegeRepository collegeRepository,
                       StudentRepository studentRepository,
                       AddressRepository addressRepository) {
        this.collegeRepository = collegeRepository;
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void initializeData() {
        College college1 = new College();
        college1.setName("Dehradun University, Dehradun");
        college1.setCity("Dehradun");
        college1.setState("Uttarakhand");

        College college2 = new College();
        college2.setName("GLA University, Mathura");
        college2.setCity("Mathura");
        college2.setState("Uttar Pradesh");

        College college3 = new College();
        college3.setName("University of Mumbai, Mumbai");
        college3.setCity("Mumbai");
        college3.setState("Maharashtra");

        collegeRepository.save(college1);
        collegeRepository.save(college2);
        collegeRepository.save(college3);

        Address address1 = new Address();
        address1.setStreet("123, Main Street");
        address1.setCity("Dehradun");
        address1.setState("Uttarakhand");
        address1.setZip("260001");
        address1.setCountry("India");

        Address address2 = new Address();
        address2.setStreet("456, Main Street");
        address2.setCity("Mathura");
        address2.setState("Uttar Pradesh");
        address2.setZip("260002");
        address2.setCountry("India");

        Address address3 = new Address();
        address3.setStreet("789, Main Street");
        address3.setCity("Mumbai");
        address3.setState("Maharashtra");
        address3.setZip("400001");
        address3.setCountry("India");

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        Student student1 = new Student();
        student1.setName("Aayush");
        student1.setEmail("aayush@gmail.com>");
        student1.setPhone("9009909090");
        student1.setCollege(new HashSet<>(List.of(college1)));
        student1.setAddress(address1);

        Student student2 = new Student();
        student2.setName("Rajesh");
        student2.setEmail("rajesh@gmail.com");
        student2.setPhone("9009909091");
        student2.setCollege(new HashSet<>(List.of(college2)));
        student2.setAddress(address2);

        Student student3 = new Student();
        student3.setName("Manpreet");
        student3.setEmail("manpreet@gmail.com");
        student3.setPhone("9009909092");
        student3.setCollege(new HashSet<>(List.of(college1, college3)));
        student3.setAddress(address3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<College> getAllCollege() {
        return collegeRepository.findAll();
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
