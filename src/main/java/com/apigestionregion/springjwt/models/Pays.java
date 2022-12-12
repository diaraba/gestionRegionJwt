package com.apigestionregion.springjwt.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*Là nous avons la classe Pays*/
@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Pays")/*Permet de donner un nom a notre table*/
@Data/*Permet de créer les setters de ma classe  Pays  grace la dependance lombok*/
@AllArgsConstructor/*Permet de créer un constructeur avec argument*/
@NoArgsConstructor/*Permet de créer un constructeur sans argument*/
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;


}