package com.example.inovation.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "user")
public class User {

    @Id
    private BigInteger _id;
    private String nom;
    private String prenom;
    private String age;
    private String adresse;

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public BigInteger get_id() {
        return _id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAge() {
        return age;
    }

    public void set_id(BigInteger _id) {
        this._id = _id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + _id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
