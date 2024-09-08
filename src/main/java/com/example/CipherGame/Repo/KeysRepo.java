package com.example.CipherGame.Repo;


import com.example.CipherGame.Entity.Keys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeysRepo extends JpaRepository<Keys, Integer> {
}
