package com.example.CipherGame.Service;

import com.example.CipherGame.Entity.Keys;
import com.example.CipherGame.Repo.KeysRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KeysService {
    @Autowired
    private KeysRepo keysRepo;

    public KeysService() {
    }

    public List<Keys> getAllKeys() {
        return keysRepo.findAll();
    }

    public Keys getKeyById(int id) {
        return keysRepo.findById(id).orElse(null);
    }

    public void saveKey(Keys key) {
        keysRepo.save(key);
    }

    public void deleteKeyById(int id) {
        keysRepo.deleteById(id);
    }
}
