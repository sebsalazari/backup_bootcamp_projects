package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "series")
public class Serie extends BaseEntity {

   @Column(name = "title")
   private String title;

   @Column(name = "release_date")
   private LocalDate releaseDate;

   @Column(name = "end_date")
   private LocalDate endDate;

   // --- Relations ---
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "genre_id", referencedColumnName = "id")
   private Genre genreOfSerie;

   @OneToMany(mappedBy = "serieContainsSeason", cascade = CascadeType.ALL)
   private Set<Season> seasonsOfSerie;
}
