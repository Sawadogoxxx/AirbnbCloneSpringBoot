package com.rbnbproject.rbnbcloneproject.model;

import com.rbnbproject.rbnbcloneproject.enums.TypeVoyageur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Voyageur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "le type de voyageur est recquis!!!")
    private TypeVoyageur typeVoyageur;

    @NotNull(message = "le nombre de personnes est recquis!!!")
    @Positive(message = "le nombre de personne doit etre positif")
    private Integer nbplace;

}
