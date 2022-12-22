package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Commentaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface commentaireService {
    Commentaire creerCommentaire(Commentaire commentaire);

    List<Commentaire> afficherComment();
}
