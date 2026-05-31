package com.lotus;

import com.lotus.ListaEncadeada;

public abstract class TabelaHash {

    protected ListaEncadeada[] tabela;
    protected int capacidade;
    protected int colisoes;
    protected int[] colisoesPorPosicao;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.colisoes = 0;
        this.colisoesPorPosicao = new int[capacidade];

        tabela = new ListaEncadeada[capacidade];

        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    public void inserir(String nome) {
        int posicao = funcaoHash(nome);

        if (!tabela[posicao].estaVazia()) {
            colisoes++;
            colisoesPorPosicao[posicao]++;
        }

        tabela[posicao].adicionar(nome);
    }

    public boolean buscar(String nome) {
        int posicao = funcaoHash(nome);

        return tabela[posicao].buscar(nome);
    }

    public void mostrarDistribuicao() {
        for (int i = 0; i < capacidade; i++) {
            System.out.println("Posição " + i + ": " + tabela[i].getTamanho() + " nomes");
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