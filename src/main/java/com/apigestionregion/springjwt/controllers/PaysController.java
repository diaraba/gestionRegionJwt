package com.apigestionregion.springjwt.controllers;

import com.apigestionregion.springjwt.models.Pays;
import com.apigestionregion.springjwt.models.Regions;
import com.apigestionregion.springjwt.security.services.ConfigImage;
import com.apigestionregion.springjwt.security.services.PaysService;
import com.apigestionregion.springjwt.security.services.SaveImage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("api/auth/pays")
@AllArgsConstructor
public class PaysController {

    /* Permet de creer une entrée pour*/
    @Autowired
    private final PaysService paysService;
 /*   @PostMapping("/create")
    public Pays creer(@RequestParam(value = "file",required = false) MultipartFile file, @RequestParam(value = "pays") String pays)throws JsonProcessingException {
*//*
        Pays pays1=null;
        try{
            pays1 = new JsonMapper().readValue(pays,Pays.class);
        }
        catch (Exception e){
            System.out.println("ererh");
        }
        try {
            pays1.setImage(SaveImage.save("regions",file,pays1.getNom()));
        }
        catch (Exception e){
            System.out.println("errer");
        }*//*
        return paysService.creer(pays1);
    }*/

    @PostMapping("/create")
    public Pays creer(  @Param("nom") String nom,
                        @Param("description") String description,
                        @Param("superficie") String superficie,
                        @Param("image")MultipartFile image) throws IOException {

        Pays pays=new Pays();
        pays.setNom(nom);
        pays.setDescription(description);
        pays.setSuperficie(superficie);
        String img = StringUtils.cleanPath(image.getOriginalFilename());
        pays.setImage(img);
        String uploaDir = "C:\\Users\\didiarra\\AngularGestionRegion\\jwtangularGestionRegion-main\\src\\assets\\image";
        ConfigImage.saveimg(uploaDir, img, image);
        /*
        Pays pays1=null;
        try{
            pays1 = new JsonMapper().readValue(pays,Pays.class);
        }
        catch (Exception e){
            System.out.println("ererh");
        }
        try {
            pays1.setImage(SaveImage.save("regions",file,pays1.getNom()));
        }
        catch (Exception e){
            System.out.println("errer");
        }*/
        return paysService.creer(pays);
    }






    /*Permet d'afficher la liste de toute les  pays*/
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/read")
    public List<Pays> lire() {
        return paysService.lire();
    }





    /*Permet de modifier un pays donné*/

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{idPays}")
    public Pays update(@PathVariable Long idPays, @RequestBody Pays pays) {
        return paysService.modifier(idPays,pays);
    }






    /*Permet de supprimer un pays donnée*/
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{idPays}")
    public String supprimer(@PathVariable Long idPays) {
        return paysService.supprimer(idPays);
    }
}
