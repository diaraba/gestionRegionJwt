package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Regions;
import com.apigestionregion.springjwt.security.services.RegionsService;
import com.apigestionregion.springjwt.security.services.SaveImage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth/regions")
@AllArgsConstructor
public class RegionsController {

    @Autowired
    private final RegionsService regionsService;







    /*Permet creer une entrée pour */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String creer(@RequestParam(value = "file",required = false)MultipartFile file,
                        @RequestParam(value = "regions") String regions) throws JsonProcessingException {

        Regions regions1=null;
        try{
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
        }
        regionsService.creer(regions1);

        return "La population a été ajouté avec succcès";
    }






    /*Permet d'afficher la liste de toute les regions avec tout les chanmps de notre entités region */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read")
    public Iterable<Object[]> lire() {
        return regionsService.lire();
    }







    /*Permet d'afficher la liste de toute les regions sans le pays */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read1")
    public Iterable<Object[]> lireFIND_REGION_SANS_Pays() {
        return regionsService.lireFIND_REGION_SANS_Pays();
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

