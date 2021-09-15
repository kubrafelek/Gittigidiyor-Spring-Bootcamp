package com.dev.patika.homework02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/convert_money")
public class Converter {

    @GetMapping("/tlToDollar")
    public ResponseEntity<String> TlToDollar() {
        return new ResponseEntity<>("1 TL = 0,1203 Dollar", HttpStatus.OK);
    }

    @GetMapping("/dollarToTl")
    public ResponseEntity<String> dollarToTl() {
        return new ResponseEntity<>("1 Dollar = 8.31 TL", HttpStatus.OK);
    }
}
