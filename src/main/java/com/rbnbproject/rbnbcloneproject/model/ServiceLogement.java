package com.rbnbproject.rbnbcloneproject.model;


import com.rbnbproject.rbnbcloneproject.enums.ServiceLogementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * represente :Ce que propose ce logement
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ServiceLogement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Represente le nom du service
     * par exempel : Wifi ,ou Cuisine
     */
    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    private ServiceLogementType service;
}
