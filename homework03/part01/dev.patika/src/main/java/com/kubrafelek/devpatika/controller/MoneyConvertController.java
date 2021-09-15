package com.kubrafelek.devpatika.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class MoneyConvertController {

    RestTemplate restTemplate;

    @GetMapping("/methodOne")
    public String convertOperation() {
        String res1 = restTemplate.getForObject("http://localhost:8080/convert_money/tlToDollar", String.class);
        return res1;
    }

    @GetMapping("/methodTwo")
    public String convertOperation2() {
        String res2 = restTemplate.getForObject("http://localhost:8080/convert_money/dollarToTl", String.class);
        return res2;
    }
}
