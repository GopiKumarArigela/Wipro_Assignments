package com.gk.example;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(
        mappedBy = "users", 
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    private List<Post> posts;

    public User() {
        super();
    }

    
}
