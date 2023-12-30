package com.rbnbproject.rbnbcloneproject.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Reservation {
    @Id
    private String id;
    @NotNull(message = "la date de debut est recquise!!!")
    private Date debut;

    @NotNull(message = "la date de fin est recquise!!!")
    private Date fin;

    @ManyToMany(fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private List<Voyageur>voyageurs=new ArrayList<>();

    @ManyToOne(
            fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private House house;
}
