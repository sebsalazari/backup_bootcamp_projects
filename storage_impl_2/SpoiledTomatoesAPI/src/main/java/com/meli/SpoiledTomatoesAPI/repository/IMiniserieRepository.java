package com.meli.SpoiledTomatoesAPI.repository;

import com.meli.SpoiledTomatoesAPI.model.Entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {

}
