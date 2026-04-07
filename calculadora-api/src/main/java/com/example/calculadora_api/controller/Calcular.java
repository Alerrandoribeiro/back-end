package com.example.calculadora_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")
public class Calcular {

    record Resultado(double valor1, String operacao, double valor2, double resultado) {}

    @GetMapping("/{operacao}")
    public ResponseEntity<?> calcular(
            @PathVariable String operacao,
            @RequestParam double v1,
            @RequestParam double v2) {

        double resultado = switch (operacao.toLowerCase()) {
            case "soma" -> v1 + v2;
            case "subtracao" -> v1 - v2;
            case "multiplicacao" -> v1 * v2;
            case "divisao" -> {
                if (v2 == 0) throw new ArithmeticException("Divisão por zero não é permitida");
                yield v1 / v2;
            }
            default -> throw new IllegalArgumentException("Operação inválida: " + operacao);
        };

        return ResponseEntity.ok(new Resultado(v1, operacao.toLowerCase(), v2, resultado));
    }
}