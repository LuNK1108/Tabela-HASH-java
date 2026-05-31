package com.lotus;

public class ListaEncadeada {
    private No inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void adicionar(String valor) {
        No novoNo = new No(valor);

        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;

            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }

            atual.setProximo(novoNo);
        }

        tamanho++;
    }

    public boolean buscar(String valor) {
        No atual = inicio;

        while (atual != null) {
            if (atual.getValor().equalsIgnoreCase(valor)) {
                return true;
            }

            atual = atual.getProximo();
        }

        return false;
    }

    public int getTamanho() {
        return tamanho;
    }
}