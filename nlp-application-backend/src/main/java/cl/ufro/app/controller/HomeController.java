/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Batman
 */
@RestController
public class HomeController {
    
    
    @RequestMapping("/")
    public String home(){
        return "Hello";
    }
    
}
