package com.lotus;

import java.util.LinkedList;

public abstract class TabelaHash {

    protected LinkedList<String>[] tabela;
    protected int capacidade;
    protected int colisoes;
    protected int[] colisoesPorPosicao;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.colisoes = 0;
        this.colisoesPorPosicao = new int[capacidade];

        tabela = new LinkedList[capacidade];

        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    public void inserir(String nome) {
        int posicao = funcaoHash(nome);

        if (!tabela[posicao].isEmpty()) {
            colisoes++;
            colisoesPorPosicao[posicao]++;
        }

        tabela[posicao].add(nome);
    }

    public boolean buscar(String nome) {
        int posicao = funcaoHash(nome);

        for (String item : tabela[posicao]) {
            if (item.equalsIgnoreCase(nome)) {
                return true;
            }
        }

        return false;
    }

    public void mostrarDistribuicao() {
        for (int i = 0; i < capacidade; i++) {
            System.out.println("Posição " + i + ": " + tabela[i].size() + " nomes");
        }
    }

    public void mostrarColisoesPorPosicao() {
        for (int i = 0; i < capacidade; i++) {
            System.out.println("Posição " + i + ": " + colisoesPorPosicao[i] + " colisões");
        }
    }

    public int getColisoes() {
        return colisoes;
    }

    public abstract int funcaoHash(String nome);
}