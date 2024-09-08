package com.example.CipherGame.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.springframework.beans.factory.annotation.Autowired;


@Entity(name = "cryptotext")
public class CryptoText {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "super_key")
    private int superKey;

    @Column(name = "big_text")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuperKey() {
        return superKey;
    }

    public void setSuperKey(int superKey) {
        this.superKey = superKey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
