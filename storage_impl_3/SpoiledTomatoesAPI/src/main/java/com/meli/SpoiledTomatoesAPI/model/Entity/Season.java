package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "seasons")
public class Season extends BaseEntity {

   @Column(name = "title")
   private String title;

   @Column(name = "number")
   private Integer number;

   @Column(name = "release_date")
   private LocalDate releaseDate;

   @Column(name = "end_date")
   private LocalDate endDate;

   // --- Relations ---
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "serie_id", referencedColumnName = "id", nullable = false)
   private Serie serieContainsSeason;

   @OneToMany(mappedBy = "seasonContainsEpisode", cascade = CascadeType.ALL)
   private Set<Episode> episodeOfSeason;
}
