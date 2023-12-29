package com.rbnbproject.rbnbcloneproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Commentaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,
    columnDefinition = "TEXT")
    @Lob
    @NotEmpty(message = "le message du commentaire est obligatoire")
    private String message;

    @Column(nullable = false)
    @NotNull(message = "la date d'envoie est obligatoire")
    private Date dateEnvoie;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private House house;
}
