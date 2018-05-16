/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.app.model;

import edu.stanford.nlp.ling.HasWord;

/**
 *
 * @author Batman
 */
public class Token implements HasWord {

    private String word;
    
    public Token(String word){
        this.word = word;
    }
    
    public Token(){
        
    }
    
    @Override
    public String word() {
        return this.word;
    }

    @Override
    public void setWord(String word) {
        this.word = word;
    }
    
}
