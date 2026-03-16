package com.calculadora.calculadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculadora.calculadora.utils.OperacaoUtils;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

// Quem conta a lógica de negócio da aplicação é a classe de serviço, ou seja, ela é responsável por realizar as operações matemáticas e retornar os resultados para o controlador. O controlador, por sua vez, é responsável por receber as requisições HTTP, chamar os métodos do serviço e retornar as respostas para o cliente. A separação entre controlador e serviço é uma boa prática de design de software, pois permite uma melhor organização do código e facilita a manutenção e evolução da aplicação.

// @Service é uma anotação do Spring que indica que a classe é um serviço, ou seja, ela contém a lógica de negócio da aplicação. Ela é usada para marcar a classe como um componente gerenciado pelo Spring, permitindo que ela seja injetada em outras partes da aplicação, como controladores ou outros serviços.
@Service
public class CalcularService {
    
    // @Autowired ele pega o objeto que você precisa e coloca automaticamente dentro da sua classe, ou seja, ele faz a injeção de dependência para você, sem precisar criar um objeto manualmente.
    @Autowired
    private OperacaoUtils operacaoUtils;

    public String soma(double n1, double n2) {
        double resultado = operacaoUtils.soma(n1, n2);

        return "O resultado da soma é: " + resultado;

    }

    public String subtracao(double n1, double n2) {
        double resultado = operacaoUtils.subtracao(n1, n2);

        return "O resultado da subtração é: " + resultado;

    }

    public String multiplicacao(double n1, double n2) {
        double resultado = operacaoUtils.multiplicacao(n1, n2);

        return "O resultado da multiplicação é: " + resultado;

    }

    public String divisao(double n1, double n2) {
        double resultado = operacaoUtils.divisao(n1, n2);

        if (n2 == 0) {
            return "Erro: divisão por zero não é permitida.";
        }

        return "O resultado da divisão é: " + resultado;

    }

    
    public String taboada(double n1) {
        String resultado = "";
       
        for (int i = 1; i <= 10; i++) {
            resultado += n1 + " x " + i + " = " + (n1 * i) + "<br>" ;
        }

        return "Taboada de " + n1 +  " é: " + "<br>"  + resultado ;

    }
}
