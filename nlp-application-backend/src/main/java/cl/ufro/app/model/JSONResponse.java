/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.app.model;

/**
 *
 * @author Batman
 */
public class JSONResponse {
    
    
    private String palabra;
    private String tag;

    public JSONResponse(String palabra, String tag) {
        this.palabra = palabra;
        this.tag = tag;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getTag() {
        return tag;
    }
        
}
