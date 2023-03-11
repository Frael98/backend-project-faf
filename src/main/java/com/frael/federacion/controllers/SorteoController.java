package com.frael.federacion.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/sorteo")
public class SorteoController {
    
    @GetMapping(value = "/add-sorteo")
    String generarSorteo(){

        return "";
    }
}
