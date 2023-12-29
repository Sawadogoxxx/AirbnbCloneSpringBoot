package com.rbnbproject.rbnbcloneproject.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class House {
    @Id
    private String id;


    @Column(nullable = false,unique = true)
    private String nom;
    /**
     * Une maison peut avoir plusieurs Categories
     * Represente les Catégories de ce logement
     */
    @ManyToMany(
            mappedBy = "houses",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Categorie> categories;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "house"
    )
    private List<Reservation>reservations=new ArrayList<>();
    /**
     * Represente les commentaires associés a ce Logement
     */
    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    mappedBy = "house",
    orphanRemoval = true)
    private List<Commentaire>commentaires;
    /**
     * Represente l'image de profil de ce logement
     */
    private String profileImage;
    /**
     * Represente le Lieu du Logement
     */
    @ManyToOne(fetch =FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Lieu lieu;

    /**
     * Represente les Service de ce logement
     * par Exemple:Wifi ,CUisine ,Climatisation
     */
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<ServiceLogement>serviceLogements=new ArrayList<>();
    /**
     * La Suppression d'une maison entraine la suppression des pièces associés
     */
    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Piece>pieces;

    @Column(name = "nombre_max_personnes",nullable = false)
    private Integer nbmaxPerso;

    @Column(nullable = false)
    private Integer nbChambres;

    @Column(nullable = false)
    private Integer nbLit;

    @Column(name = "nb_sale_bain",nullable = false)
    @NotNull(message = "le nombre de salle de bain est requis!!")
    //@Positive(message = "Cette Valuer doit etre postif")
    private Integer nbSalleDeBain;

    @Column(nullable = false)
    @NotEmpty(message = "la description est requise!!")
    private String descrption;

    @Column(nullable = false)
    @NotNull(message = "le prix de la nuit est obligatoire")
   // @Positive(message = "le prix doit etre posifif")
    private Double prixNuit;


   // @Positive(message = "Les frais doivent etre positifs")
    @NotNull(message = "Les frais sont recquis!!!")
    private Double fraisRbnb;

    @Override
    public String toString() {
        return "House{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", nbmaxPerso=" + nbmaxPerso +
                ", nbChambres=" + nbChambres +
                ", nbLit=" + nbLit +
                ", nbSalleDeBain=" + nbSalleDeBain +
                ", descrption='" + descrption + '\'' +
                ", prixNuit=" + prixNuit +
                ", fraisRbnb=" + fraisRbnb +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        return Objects.equals(getNom(), house.getNom())
                && Objects.equals(getProfileImage(),
                house.getProfileImage())
                && Objects.equals(getNbmaxPerso(),
                house.getNbmaxPerso())
                && Objects.equals(getNbChambres(),
                house.getNbChambres()) && Objects.equals(getNbLit(),
                house.getNbLit()) && Objects.equals(getNbSalleDeBain(),
                house.getNbSalleDeBain()) && Objects.equals(getDescrption(),
                house.getDescrption()) && Objects.equals(getPrixNuit(),
                house.getPrixNuit())
                && Objects.equals(getFraisRbnb(),
                house.getFraisRbnb());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(),
                getProfileImage(),
                getNbmaxPerso(),
                getNbChambres(),
                getNbLit(),
                getNbSalleDeBain(),
                getDescrption(),
                getPrixNuit(),
                getFraisRbnb());
    }



}
