package com.example.CipherGame.Service;

import com.example.CipherGame.Entity.CryptoText;
import com.example.CipherGame.Repo.CryptoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CryptoService {
    @Autowired
    private CryptoRepo cryptoRepo;



    public List<CryptoText> findAll() {
        return cryptoRepo.findAll();
    }

    public CryptoText findById(int id) {
        return cryptoRepo.findById(id).orElse(null);
    }

    public CryptoText saveEntity(CryptoText cryptoText) {
        return cryptoRepo.save(cryptoText);
    }

    public void deleteById(int id) {
        cryptoRepo.deleteById(id);
    }

}
