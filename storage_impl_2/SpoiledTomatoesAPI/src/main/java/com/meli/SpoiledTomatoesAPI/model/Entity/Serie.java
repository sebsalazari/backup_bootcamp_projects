package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "series")
public class Serie {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "created_at")
   private LocalDateTime createdAt;

   @Column(name = "updated_at")
   private LocalDateTime updateAt;

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
