package com.rbnbproject.rbnbcloneproject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Lieu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String pays;

    private String ville;
}
