package com.apigestionregion.springjwt.repository;

import com.apigestionregion.springjwt.models.Commentaire;
import com.apigestionregion.springjwt.models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByRegions(Regions id);


}
