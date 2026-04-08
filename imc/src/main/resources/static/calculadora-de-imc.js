const BASE_URL = 'http://localhost:8080';

//para tesar http://localhost:8080/calculadora-de-imc.html

document.getElementById("imc-form").addEventListener("submit", async function (event) {
    event.preventDefault();
    await calcularIMC();
});

async function calcularIMC() {
    const peso = parseFloat(document.getElementById('peso').value);
    const altura = parseFloat(document.getElementById('altura').value);

    const resultadoDiv = document.getElementById("resultado");
    const erroDiv = document.getElementById("erro");

    resultadoDiv.classList.add("hidden");
    erroDiv.classList.add("hidden");

    if (isNaN(peso) || isNaN(altura) || peso <= 0 || altura <= 0) {
        exibirErro("Peso e altura devem ser maiores que zero.");
        return;
    }

    try {
        const response = await fetch(
            `${BASE_URL}/imc?peso=${encodeURIComponent(peso)}&altura=${encodeURIComponent(altura)}`
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
        <p><strong>IMC:</strong> ${dados.imc}</p>
        <p><strong>Categoria:</strong> ${dados.categoria}</p>
    `;

    resultadoDiv.classList.remove("hidden");
}

function exibirErro(mensagem) {
    const erroDiv = document.getElementById("erro");
    erroDiv.textContent = mensagem;
    erroDiv.classList.remove("hidden");
}