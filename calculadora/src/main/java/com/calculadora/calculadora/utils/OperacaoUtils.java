package com.calculadora.calculadora.utils;

import org.springframework.stereotype.Component;


// @Component é uma anotação do Spring que indica que a classe é um componente, ou seja, ela é um objeto gerenciado pelo Spring. Ela é usada para marcar a classe como um componente que pode ser injetado em outras partes da aplicação, como serviços ou controladores. A classe de utilidade é uma classe que contém métodos estáticos que realizam operações comuns e podem ser reutilizados em diferentes partes da aplicação. Ela não deve conter estado, ou seja, não deve ter atributos de instância, pois isso pode levar a problemas de concorrência e dificultar a manutenção do código.
@Component
public class OperacaoUtils {
    
    public double soma(double n1, double n2) {
        return n1 + n2;
    }
    
    public double subtracao(double n1, double n2) {
        return n1 - n2;
    }
    
    public double multiplicacao(double n1, double n2) {
        return n1 * n2;
    }
    
    public double divisao(double n1, double n2) {
        return n1 /  n2;
    }
}
