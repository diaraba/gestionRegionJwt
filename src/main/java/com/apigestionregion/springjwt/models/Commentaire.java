package com.apigestionregion.springjwt.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Commentaire")/*Permet de donner un nom a notre table*/
@Getter
@Setter/*Permet de créer les setters de ma classe  Pays  grace la dependance lombok*/
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPays;
    private String contenu;
    @ManyToOne
    User user;
    @ManyToOne
    Regions regions;
}
