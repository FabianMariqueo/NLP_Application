/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase para modelar un objeto JSON que se debe recibir en la aplicación,
 * el cual debe contener la información o texto que se desea aplicar los tag
 * @author Batman
 */
public class JSONRequest {
    
    //Variable idioma que representa el idioma del texto que se introdujo
    @JsonProperty(value = "IDIOMA", required= true)
    private String idioma;
    
    //Variable texto que representa el texto para aplicar los tag
    @JsonProperty(value = "TEXTO", required = true)
    private String texto;

    public String getIdioma() {
        return idioma;
    }

    public String getTexto() {
        return texto;
    }
    
    
    
    
}
