package com.lotus;

public class TabelaHashPolinomial extends TabelaHash {

    public TabelaHashPolinomial(int capacidade) {
        super(capacidade);
    }

    @Override
    public int funcaoHash(String nome) {
        int hash = 0;

        for (int i = 0; i < nome.length(); i++) {
            hash = 31 * hash + nome.charAt(i);
        }

        return Math.abs(hash) % capacidade;
    }
}