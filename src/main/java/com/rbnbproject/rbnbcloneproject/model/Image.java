package com.rbnbproject.rbnbcloneproject.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represente Une Image de Logement
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "l'image de la pièce est recquise!!!")
    private String imageUrl;


    private String title;
}
