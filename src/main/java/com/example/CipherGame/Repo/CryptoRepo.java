package com.example.CipherGame.Repo;


import com.example.CipherGame.Entity.CryptoText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepo extends JpaRepository<CryptoText, Integer> {
}
