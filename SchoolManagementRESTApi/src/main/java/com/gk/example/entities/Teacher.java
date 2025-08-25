package com.gk.example.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String teacherName;
    private String teacherAdress;

    @Enumerated(EnumType.STRING)
    private Qualification qualification;

    private int age;
    private LocalDate dob;
    private int experience;
}
