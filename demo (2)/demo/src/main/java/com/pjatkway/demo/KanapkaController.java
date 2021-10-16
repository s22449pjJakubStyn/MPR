package com.pjatkway.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kanapka")


public class KanapkaController {
    @GetMapping("/example")

    public ResponseEntity<Kanapka> getExampleKanapka() {
        List<Skladniki> skladniki = new ArrayList<>();
        Kanapka poor2 = new Kanapka(null, "poor2", 2.0, 100, null, SandwichSize.MALA, "Wiosenna");
        return ResponseEntity.ok(poor2);

    }
    @GetMapping("/example2")
    public ResponseEntity<Kanapka> getNullKanapka() {
        List<Skladniki> skladniki = new ArrayList<>();
        Skladniki chleb = new Skladniki(null, "bialy chleb", 1.50, 100);
        Kanapka poor2 = new Kanapka(null, "poor", 2.0, 100, null, SandwichSize.MALA, "Wiosenna");
        return ResponseEntity.ok(poor2);
    }
}
