package com.apigestionregion.springjwt.repository;


import com.apigestionregion.springjwt.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface PaysRepository extends JpaRepository<Pays, Long> {
  /*  @Query(value = "SELECT regions.nom, population.annee, population.nb_habitant FROM pays,regions,population WHERE regions.id_pays =pays.id AND population.regions_id = regions.id AND regions.nom =:regions", nativeQuery = true )
    public Iterable<Object[]> FIND_PAYS_REGION_POPULATION_ANNEE_NBHABUTANT(String regions);*/
 Pays findByIdPays(Long id);

}
