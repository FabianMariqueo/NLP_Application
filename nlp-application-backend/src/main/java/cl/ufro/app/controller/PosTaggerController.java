/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.app.controller;

import cl.ufro.app.model.JSONRequest;
import cl.ufro.app.model.JSONResponse;
import cl.ufro.app.model.Token;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.ArrayList;
import java.util.Arrays;
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
     *
     * @param jsonTexto
     * @return
     */
    @PostMapping("/stanford-pos")
    @ResponseBody
    public ArrayList<JSONResponse> posTagger(@RequestBody JSONRequest jsonTexto) {

        ArrayList<JSONResponse> jsonResponse = new ArrayList();        

        //Se añade el idioma para aplicar las categorias gramaticales correspondientes
        MaxentTagger tagger = new MaxentTagger("taggers/spanish-distsim.tagger");        

        String[] palabras = jsonTexto.getTexto().split(" ");        
        Token[] token = new Token[palabras.length];
        
        for (int i = 0; i < palabras.length; i++) {
            token[i] = new Token(palabras[i]);
        }
        
        JSONResponse auxResponse;
        int i =0;               
        
        
        for (TaggedWord palabra : tagger.tagSentence(Arrays.asList(token))) {

            auxResponse = new JSONResponse(token[i++].word(), palabra.tag());

            jsonResponse.add(auxResponse);
        }

        return jsonResponse;
    }

    @PostMapping("/stanford-pos-file")
    public String posTaggerFile() {

        ArrayList<JSONResponse> jsonResponse = new ArrayList();

        return "";
    }

}
