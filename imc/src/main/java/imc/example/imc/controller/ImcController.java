package imc.example.imc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imc")
public class ImcController {
 
    record Resultado(double peso, double altura, String categoria, double imc) {
    }

    @GetMapping
    public ResponseEntity<Resultado> calcular(
            @RequestParam double peso,
            @RequestParam double altura) {

        if (peso <= 0 || altura <= 0) {
        return ResponseEntity.status(400).body(new Resultado(peso, altura, "Altura e peso devem ser maiores que zero!", 0));
        }
        double imc = peso / (altura * altura);

        String categoria;
        if (imc < 18.5) {
            categoria = "abaixo-do-peso";
        } else if (imc < 25) {
            categoria = "peso-normal";
        } else if (imc < 30) {
            categoria = "sobrepeso";
        } else if (imc < 35) {
            categoria = "obesidade-grau-1";
        } else if (imc < 40) {
            categoria = "obesidade-grau-2";
        } else {
            categoria = "obesidade-grau-3";
        }

        return ResponseEntity.ok(new Resultado(peso, altura, categoria, imc));
    }
}