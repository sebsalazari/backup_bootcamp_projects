package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@MappedSuperclass
public class BaseEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "created_at")
   @CreationTimestamp
   private LocalDateTime createdAt;

   @Column(name = "updated_at")
   @UpdateTimestamp
   private LocalDateTime updateAt;
}
