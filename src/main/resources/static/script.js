document.getElementById('formCadastro').addEventListener('submit', (evento) => {
    const nome = document.getElementById('nome');
    const idade = document.getElementById('idade');
    const dataInicio = document.getElementById('dataInicio');

    let eventoValido = true;

    nome.setCustomValidity('');
    if (nome.value.trim() === '') {
        nome.setCustomValidity('Nome obrigatório.');
        eventoValido = false;
    }

    idade.setCustomValidity('');
    const idadeValor = parseInt(idade.value);
    if (isNaN(idadeValor) || idadeValor < 17 || idadeValor > 100) {
        idade.setCustomValidity('A idade deve ser entre 17 e 100.');
        eventoValido = false;
    }

    dataInicio.setCustomValidity('');
    const dataInicioValor = new Date(dataInicio.value);
    const anoNascimento = new Date().getFullYear() - idadeValor;
    const dataNascimentoDerivada = new Date(`${anoNascimento}-01-01`); //assumindo que nasceu 01/01

    if (dataInicioValor <= dataNascimentoDerivada) {
        dataInicio.setCustomValidity('A data de início deve ser depois do ano de nascimento.');
        eventoValido = false;
    }

    if (!eventoValido) {
        evento.preventDefault();
    }
});