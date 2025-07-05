
package org.datamapping.springdatajpamapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonBackReference
    private College college;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private Address address;
}
