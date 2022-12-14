package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.Commentaire;
import com.apigestionregion.springjwt.models.User;
import com.apigestionregion.springjwt.repository.CommentaireRepository;
import com.apigestionregion.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userServiImpl implements userServi{
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentaireRepository commentaireRepository;
    @Override
    public List<User> afficherUser() {
        return userRepository.findAll();
    }

}
