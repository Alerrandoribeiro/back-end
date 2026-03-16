package com.calculadora.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.calculadora.service.CalcularService;

// O controlador é a camada responsável por receber as requisições HTTP, processá-las e retornar as respostas para o cliente. Ele é responsável por mapear as rotas da aplicação e chamar os métodos do serviço para realizar as operações matemáticas. O controlador deve ser simples e não conter lógica de negócio, pois essa responsabilidade é do serviço. Ele deve apenas receber os dados da requisição, chamar o serviço e retornar a resposta para o cliente.

// @RestController é uma anotação do Spring que indica que a classe é um controlador REST, ou seja, ela é responsável por receber as requisições HTTP e retornar as respostas para o cliente. Ela é usada para marcar a classe como um componente gerenciado pelo Spring, permitindo que ela seja injetada em outras partes da aplicação, como serviços ou outros controladores.
@RestController
public class CalcularController {

   @Autowired
   private CalcularService calcularService;

   // GetMapping é uma anotação do Spring que indica que o método é responsável por lidar com requisições HTTP GET.
   public String teste() {

      return "teste";
   }

   // PathVariable é uma anotação do Spring que indica que o valor da variável na URL deve ser mapeado para o parâmetro do método. Por exemplo, se a URL for /soma/5/3, o valor 5 será mapeado para o parâmetro n1 e o valor 3 será mapeado para o parâmetro n2.
   @GetMapping("/soma/{n1}/{n2}")
   public String soma(@PathVariable double n1, @PathVariable double n2) {

      return calcularService.soma(n1, n2);

   }

   @GetMapping("/subtracao/{n1}/{n2}")
   public String subtracao(@PathVariable double n1, @PathVariable double n2) {
      
      return calcularService.subtracao(n1, n2);
   }

   @GetMapping("/multiplicacao/{n1}/{n2}")
   public String multiplicacao(@PathVariable double n1, @PathVariable double n2) {

      return calcularService.multiplicacao(n1, n2);
   }

   @GetMapping("/divisao/{n1}/{n2}")
   public String divisao(@PathVariable double n1, @PathVariable double n2) {

      return calcularService.divisao(n1, n2);

   }
   @GetMapping("/taboada/{n1}")
   public String taboada(@PathVariable double n1) {

      return calcularService.taboada(n1);

   }

}