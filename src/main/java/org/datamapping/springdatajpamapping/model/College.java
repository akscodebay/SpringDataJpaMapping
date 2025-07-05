package org.datamapping.springdatajpamapping.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    private String state;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Student> student = new ArrayList<>();
}
