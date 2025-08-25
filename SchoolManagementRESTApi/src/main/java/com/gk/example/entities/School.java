package com.gk.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String schoolName;
    private String schoolAdress;

    private Long teacherId; 
}
