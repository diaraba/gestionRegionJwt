package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Commentaire;
import com.apigestionregion.springjwt.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentaireServiceImpl implements commentaireService{
    @Autowired
    CommentaireRepository commentaireRepository;



    @Override
    public Commentaire creerCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> afficherComment() {
        return commentaireRepository.findAll();
    }
}
