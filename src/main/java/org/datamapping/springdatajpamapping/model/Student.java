
package org.datamapping.springdatajpamapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @ManyToMany
    @JoinTable(name = "student_college",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "college_id"))
    @JsonBackReference
    private Set<College> college = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private Address address;
}
