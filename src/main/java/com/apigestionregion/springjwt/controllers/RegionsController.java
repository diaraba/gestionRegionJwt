package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Pays;
import com.apigestionregion.springjwt.models.Regions;
import com.apigestionregion.springjwt.repository.PaysRepository;
import com.apigestionregion.springjwt.repository.RegionsRepository;
import com.apigestionregion.springjwt.security.services.ConfigImage;
import com.apigestionregion.springjwt.security.services.PaysService;
import com.apigestionregion.springjwt.security.services.RegionsService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth/regions")
@AllArgsConstructor
public class RegionsController {

    @Autowired
    private final RegionsService regionsService;

    @Autowired
    private final PaysService paysService;
    @Autowired
    private PaysRepository paysRepository;
    @Autowired
    private RegionsRepository regionsRepository;


    /*Permet creer une entrée pour */
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{nomPays}")
    public String creer( @Param("code_regions") String code_regions,
                         @Param("nom") String nom,
                         @Param("langue") String langue,
                         @Param("superficie_regions") String superficie_regions,
                         @Param("domaine_activite") String domaine_activite,
                         @Param("image")MultipartFile image,
                         @PathVariable("nomPays") String nomPays) throws IOException {

        Regions regions1=new Regions();
        regions1.setCodeRegions(code_regions);
        regions1.setNom(nom);
        regions1.setLangue(langue);
        regions1.setSuperficie_regions(superficie_regions);
        regions1.setDomaine_activite(domaine_activite);
        String img = StringUtils.cleanPath(image.getOriginalFilename());
        regions1.setImage(img);
        String uploaDir = "C:\\Users\\didiarra\\AngularGestionRegion\\jwtangularGestionRegion-main\\src\\assets\\image";
        ConfigImage.saveimg(uploaDir, img, image);
        //System.out.println(id_pays);

        //System.out.println(paysService.trouverParid(id_pays));
        //Pays pays= paysService.trouverParid(id_pays);
        Pays pay = paysRepository.findByNom(nomPays);
        regions1.setPays(pay);

   /*     try{
            regions1 = new JsonMapper().readValue(regions,Regions.class);
        }
        catch (Exception e){
           System.out.println("ererh");
        }
        try {
            regions1.setImage(SaveImage.save("regions",file,regions1.getNom()));
        }
        catch (Exception e){
            System.out.println("errer");
        }*/
        regionsService.creer(regions1);

        return "La population a été ajouté avec succcès";
    }






    /*Permet d'afficher la liste de toute les regions avec tout les chanmps de notre entités region */
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read")
    public List<Regions> lire() {
        return regionsService.afficher();
    }







    /*Permet d'afficher la liste de toute les regions sans le pays */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read1")
    public Iterable<Object[]> lireFIND_REGION_SANS_Pays() {
        return regionsService.lireFIND_REGION_SANS_Pays();
    }

    @GetMapping("/regionParid/{id}")
    public Regions regionParid(@PathVariable("id") Long id){
        return  regionsRepository.findByIdRegion(id);
    }






    /*Permet d'afficher la liste de toute les regions en fonction du pays */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read2/{pays}")
    public Iterable<Object[]> lireFIND_REGION_EN_FONCTION_DU_Pays(@PathVariable String pays) {
        return regionsService.lireFIND_REGION_EN_FONCTION_DU_Pays(pays);
    }






    /*Permet d'afficher la liste de toute les regions avec le pays correspondante */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read3")
    public Iterable<Object[]> lireFIND_ALLREGION_WITH_PAYS() {
        return regionsService. lireFIND_ALLREGION_WITH_PAYS();
    }









    /*Permet d'afficher la liste de toute les entrée d'une region donné avec le nombre d'habitant avec l'année correspondante */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read4/{regions}")
    public Iterable<Object[]> lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(@PathVariable String regions) {
        return regionsService.lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(regions);
    }








    /*Permet de modifier une regions donnée*/
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/update/{idRegions}")
    public Regions update(@PathVariable Long idRegions, @RequestBody Regions regions) {
        return regionsService.modifier(idRegions,regions);
    }






    /*Permet de supprimer une regions donnée*/
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{idRegions}")
    public String supprimer(@PathVariable Long idRegions) {
        return regionsService.supprimer(idRegions);
    }

}

