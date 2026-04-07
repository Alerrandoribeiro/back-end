const BASE_URL = "http://localhost:8080";

const NOMES_OPERACOES = {
    soma: "Soma",
    subtracao: "Subtração",
    multiplicacao: "Multiplicação",
    divisao: "Divisão"
};

async function calcular(operacao) {
    const resultadoDiv = document.getElementById("resultado");
    const erroDiv = document.getElementById("erro");

    resultadoDiv.classList.add("hidden");
    erroDiv.classList.add("hidden");

    const v1 = document.getElementById("valor1").value;
    const v2 = document.getElementById("valor2").value;

    if (v1 === "" || v2 === "") {
        exibirErro("Preencha os dois valores.");
        return;
    }
    if (operacao === "divisao" && parseFloat(v2) === 0) {
        exibirErro("Divisão por zero não é permitida.");
        return;
    }

    try {
        const response = await fetch(
            `${BASE_URL}/calcular/${encodeURIComponent(operacao)}?v1=${encodeURIComponent(v1)}&v2=${encodeURIComponent(v2)}`
        );

        if (!response.ok) {
            const texto = await response.text();
            exibirErro(texto || `Erro ${response.status}`);
            return;
        }

        const dados = await response.json();
        exibirResultado(dados);

    } catch (error) {
        exibirErro("Não foi possível conectar ao servidor!");
    }
}

function exibirResultado(dados) {
    const resultadoDiv = document.getElementById("resultado");

    resultadoDiv.innerHTML = `
        ${dados.valor1} ${simboloOperacao(dados.operacao)} ${dados.valor2}
        <div class="valor">${dados.resultado}</div>
    `;

    resultadoDiv.classList.remove("hidden");
}

function exibirErro(mensagem) {
    const erroDiv = document.getElementById("erro");
    erroDiv.textContent = mensagem;
    erroDiv.classList.remove("hidden");
}

function simboloOperacao(operacao) {
    const simbolos = {
        soma: "+",
        subtracao: "-",
        multiplicacao: "*",
        divisao: "/"
    };
    return simbolos[operacao] || "?";
}