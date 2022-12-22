package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Commentaire;
import com.apigestionregion.springjwt.models.Regions;
import com.apigestionregion.springjwt.repository.CommentaireRepository;
import com.apigestionregion.springjwt.repository.RegionsRepository;
import com.apigestionregion.springjwt.repository.UserRepository;
import com.apigestionregion.springjwt.security.services.RegionsService;
import com.apigestionregion.springjwt.security.services.commentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.synth.Region;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth/commentaire")
public class CommentaireController {

    @Autowired
    commentaireService commentaireService1;
    @Autowired
    RegionsService regionsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegionsRepository regionsRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @GetMapping("/afficher")
    public List<Commentaire> afficherComment(){
        return commentaireService1.afficherComment();
    }
    @PostMapping("/creer/{user}/{regions}")
    public  Commentaire creerComment(
            @Param("contenu") String contenu,
            @PathVariable("user") Long user,
            @PathVariable("regions") Long regions){
        Commentaire comment= new Commentaire();
        comment.setContenu(contenu);
        comment.setDate(new Date());
        comment.setUser(userRepository.findByIdUser(user));
        comment.setRegions(regionsRepository.findByIdRegion(regions));

        return  commentaireService1.creerCommentaire(comment);
    }
    @GetMapping("/afficherCommentRegion/{id}")
    public List<Commentaire> afficherCommentRegion(@PathVariable("id")Long id){
        Regions regions1=new Regions();
        regions1= regionsRepository.findByIdRegion(id);
        List<Commentaire> result =  commentaireRepository.findByRegions(regions1);
        return result;
    }
}
