package com.whaply.Groccy.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    @Column(nullable = false,length = 100)
    public String name;

    @Column(nullable = false,length = 100)
    public String username;

    @Column(nullable = false,length = 100)
    public String password;
}
