package com.rbnbproject.rbnbcloneproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entité piece Represente Une pièce de l'appartement
 * par Exmple le salon ou la cuisine
 * Nous pouvons avoir plusieurs images de la pièce en question
 * Et Quand la pièce est supprimé les images associés doivent aussi etre supprimés
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Piece {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomPiece;


    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true)

    @Column(nullable = false)
    private List<Image>images;
}
