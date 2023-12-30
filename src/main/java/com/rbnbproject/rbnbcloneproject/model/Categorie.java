package com.rbnbproject.rbnbcloneproject.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

/**
 * Represente la Categorie d'un Logement
 */
@DynamicUpdate
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Categorie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    @NotEmpty(message = "le nom de la catgégorie est Obligatoire!!!")
    private String  nomCategorie;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<House> houses;
}
