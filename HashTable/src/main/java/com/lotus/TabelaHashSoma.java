package com.lotus;

public class TabelaHashSoma extends TabelaHash {

    public TabelaHashSoma(int capacidade) {
        super(capacidade);
    }

    @Override
    public int funcaoHash(String nome) {
        int soma = 0;

        for (int i = 0; i < nome.length(); i++) {
            soma += nome.charAt(i);
        }

        return soma % capacidade;
    }
}