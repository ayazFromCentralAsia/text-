package com.example.CipherGame.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity(name = "cryptokey")
public class Keys {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "secret_key")
    String key;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
