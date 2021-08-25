package com.meli.SpoiledTomatoesAPI.repository;

import com.meli.SpoiledTomatoesAPI.model.Entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {
}
