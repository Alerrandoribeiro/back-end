📘 Frontend - Calculadora com JavaScript
🎯 Objetivo do código

Este código tem como objetivo conectar o frontend (JavaScript) com uma API backend, permitindo realizar operações matemáticas como:

Soma

Subtração

Multiplicação

Divisão

O resultado é exibido dinamicamente na tela para o usuário.

🌐 Configuração da API
const BASE_URL = "http://localhost:8080";
📌 Explicação

Define a URL base da API.

👉 Todas as requisições serão feitas para esse endereço.

🔤 Mapeamento das Operações
const NOMES_OPERACOES = {
   soma: "Soma",
   subtracao: "Subtração",
   multiplicacao: "Multiplicação",
   divisao: "Divisão"
}
📌 Explicação

Esse objeto serve para traduzir os nomes técnicos das operações em nomes mais amigáveis para o usuário.

⚙️ Função Principal: calcular()
async function calcular(operacao) {
📌 Objetivo

Essa função é responsável por executar toda a lógica da aplicação.

📥 Captura de elementos da tela
const resultadoDiv = document.getElementById("resultado");
const erroDiv = document.getElementById("erro");
📌 Explicação

Seleciona os elementos HTML onde serão exibidos:

Resultado da operação

Mensagens de erro

🧹 Limpeza de estado anterior
resultadoDiv.classList.add("hidden")
erroDiv.classList.add("hidden")
📌 Explicação

Oculta resultados e erros antigos antes de executar uma nova operação.

📊 Captura dos valores
const v1 = document.getElementById("valor1").value;
const v2 = document.getElementById("valor2").value;
📌 Explicação

Obtém os valores digitados pelo usuário nos inputs.

⚠️ Validação dos campos
if (v1 === "" || v2 === "") {
    exibirErro("Preencha os dois valores.");
    return
}
📌 Explicação

Verifica se os dois campos foram preenchidos.

Caso contrário, exibe um erro e interrompe a execução.

🌍 Requisição para a API
const response = await fetch(
`${BASE_URL}/calcular/${encodeURIComponent(operacao)}?v1=${encodeURIComponent(v1)}&v2=${encodeURIComponent(v2)}`
);
📌 Explicação

Faz uma requisição HTTP para o backend enviando:

Tipo da operação

Valores digitados

📎 Exemplo de URL gerada
http://localhost:8080/calcular/soma?v1=10&v2=5
❌ Tratamento de erro da API
if (!response.ok) {
   const texto =  await response.text();
   exibirErro(texto || `Erro ${response.status}`);
}
📌 Explicação

Se a API retornar erro:

Exibe a mensagem retornada

Ou mostra o código do erro

✅ Processamento da resposta
const dados = await response.json();
exibirResultado(dados);
📌 Explicação

Converte a resposta da API para JSON e envia para a função que exibe o resultado.

🚫 Tratamento de erro de conexão
catch (error) {
    exibirErro("Não foi possivel conectar ao servidor!")
}
📌 Explicação

Captura erros como:

Servidor desligado

Falha de conexão

📊 Função: exibirResultado()
function exibirResultado(dados) {
    const resultadoDiv = document.getElementById("resultado");

    resultadoDiv.innerHTML = 
        `${dados.valor1} ${simboloOperacao(dados.operacao)} ${dados.valor2}
        <div class="valor">${dados.resultado}</div>`;

    resultadoDiv.classList.remove("hidden");
}
📌 Explicação

Essa função:

Monta o resultado na tela

Exibe a operação realizada

Mostra o valor final

📎 Exemplo exibido
10 + 5
15
❗ Função: exibirErro()
function exibirErro(mensagem) {
    const erroDiv = document.getElementById("erro");
    erroDiv.textContent = mensagem;
    erroDiv.classList.remove("hidden");
}
📌 Explicação

Exibe mensagens de erro para o usuário de forma visual.

➕ Função: simboloOperacao()
function simboloOperacao(operacao) {
    const simbolos = {
        soma: "+",
        subtracao: "-",
        multiplicacao: "*",
        divisao: "/"
    };
    return simbolos[operacao] || "?";
}
📌 Explicação

Retorna o símbolo matemático correspondente à operação.

🔄 Fluxo da aplicação
Usuário digita valores
        ↓
Escolhe uma operação
        ↓
Função calcular() é chamada
        ↓
Requisição enviada para API
        ↓
Resposta recebida
        ↓
Resultado ou erro exibido
🧠 Resumo geral

Este código realiza:

📥 Entrada de dados do usuário

⚠️ Validação de campos

🌐 Comunicação com API (fetch + async/await)

❌ Tratamento de erros

📊 Atualização dinâmica da interface

🚀 Possíveis melhorias

🔢 Converter valores para Number

⏳ Adicionar loading durante requisição

🎨 Melhorar o layout com CSS

📱 Tornar responsivo

🔐 Validar divisão por zero no frontend