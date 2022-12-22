package com.apigestionregion.springjwt.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Commentaire")/*Permet de donner un nom a notre table*/
@Getter
@Setter/*Permet de créer les setters de ma classe  Pays  grace la dependance lombok*/
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private Date date;
    @ManyToOne
    User user;
    @ManyToOne
    Regions regions;
}
