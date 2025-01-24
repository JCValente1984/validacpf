package com.exemplo.validacpf;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoCpfService {

    public boolean validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int[] cpfNumeros = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfNumeros[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Validação dos dois dígitos verificadores
        return validarDigito(cpfNumeros, 9) && validarDigito(cpfNumeros, 10);
    }

    private boolean validarDigito(int[] cpfNumeros, int tamanho) {
        int soma = 0;
        int multiplicador = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            soma += cpfNumeros[i] * multiplicador--;
        }

        int digito = (soma * 10) % 11;
        if (digito == 10) {
            digito = 0;
        }

        return cpfNumeros[tamanho] == digito;
    }
}
