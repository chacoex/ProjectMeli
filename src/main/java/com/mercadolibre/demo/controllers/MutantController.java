package com.mercadolibre.demo.controllers;

import com.mercadolibre.demo.entities.Dna;
import com.mercadolibre.demo.entities.Stats;
import com.mercadolibre.demo.services.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @RequestMapping(method = RequestMethod.POST, value = "/ismutant/")
    @ResponseBody
    public ResponseEntity isMutant(@RequestBody Dna dna){

        Map<String, Object> body = new HashMap<>();
        System.out.println("Response: "+ dna);
        String[] mydna = dna.getDna().toArray((new String[0]));
        boolean isMutant = mutantService.isMutant(mydna);

        ResponseEntity response;

        if (isMutant) {
            body.put("StatusCode", "200");
            response = (ResponseEntity) ResponseEntity.status(HttpStatus.OK).body(body);

        } else {
            body.put("StatusCode:", "403");
            response = (ResponseEntity) ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
        }
        System.out.println("Response: "+ response);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stats")
    public ResponseEntity getStats() {
        Stats stats = mutantService.getStats();
        Map<String, Object> body = new HashMap<>();
        body.put("count_human_dna",(int) stats.getCount_human_dna()) ;
        body.put("count_mutant_dna", (int) stats.getCount_mutant_dna());
        body.put("ratio", stats.getRatio());
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
