package org.datamapping.springdatajpamapping.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Student> student = new ArrayList<>();
}
