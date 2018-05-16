/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.app.controller;

import cl.ufro.app.model.JSONRequest;
import cl.ufro.app.model.JSONResponse;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Batman
 */
@RestController
public class PosTaggerController {
    
    /**
     * Metodo para realizar el etiquetado de las palabras
     * @param jsonTexto
     * @return 
     */
    @PostMapping("/stanford-pos") 
    @ResponseBody
    private ArrayList<JSONResponse> posTagger(@RequestBody JSONRequest jsonTexto){
        
        ArrayList<JSONResponse> jsonResponse = new ArrayList();
        
        //Se añade el idioma para aplicar las categorias gramaticales correspondientes
        MaxentTagger tagger = new MaxentTagger(
                                "taggers/spanish-distsim.tagger");
        
        String tagged = tagger.tagString(jsonTexto.getTexto());
        
        String [] tokens = jsonTexto.getTexto().split(" ");
        
        List<TaggedWord> palabras = tagger.tagSentence(Arrays.asList(tokens));
                               
        JSONResponse auxResponse;
        for (int i = 0; i < tokens.length; i++) {
            auxResponse = new JSONResponse(tokens[i], palabras.get(i).tag());
            
            jsonResponse.add(auxResponse);
        }
        
        return jsonResponse;                        
    }
    
    
    @PostMapping("/stanford-pos-file")
    private ArrayList<JSONResponse> posTaggerFile(){
        
        ArrayList<JSONResponse> jsonResponse = new ArrayList();
        
        return jsonResponse;
    }
    
}
