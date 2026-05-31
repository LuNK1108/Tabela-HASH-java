package com.lotus;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        String caminhoArquivo = "nomes_20000_reais_distintos.csv";

        String[] nomes = new String[20000];
        int quantidadeNomes = lerCSV(caminhoArquivo, nomes);

        TabelaHash tabelaSoma = new TabelaHashSoma(16);
        TabelaHash tabelaPolinomial = new TabelaHashPolinomial(16);

        System.out.println(quantidadeNomes);

        long inicioInsercaoSoma = System.nanoTime();

        for (int i = 0; i < quantidadeNomes; i++) {
            tabelaSoma.inserir(nomes[i]);
        }

        long fimInsercaoSoma = System.nanoTime();

        long inicioInsercaoPolinomial = System.nanoTime();

        for (int i = 0; i < quantidadeNomes; i++) {
            tabelaPolinomial.inserir(nomes[i]);
        }

        long fimInsercaoPolinomial = System.nanoTime();

        long tempoInsercaoSoma = fimInsercaoSoma - inicioInsercaoSoma;
        long tempoInsercaoPolinomial = fimInsercaoPolinomial - inicioInsercaoPolinomial;

        long inicioBuscaSoma = System.nanoTime();

        for (int i = 0; i < quantidadeNomes; i++) {
            tabelaSoma.buscar(nomes[i]);
        }

        long fimBuscaSoma = System.nanoTime();

        long inicioBuscaPolinomial = System.nanoTime();

        for (int i = 0; i < quantidadeNomes; i++) {
            tabelaPolinomial.buscar(nomes[i]);
        }

        long fimBuscaPolinomial = System.nanoTime();

        long tempoBuscaSoma = fimBuscaSoma - inicioBuscaSoma;
        long tempoBuscaPolinomial = fimBuscaPolinomial - inicioBuscaPolinomial;

        System.out.println("RELATÓRIO FINAL");

        System.out.println("Tabela Hash com Função Soma");
        System.out.println("Número total de colisões: " + tabelaSoma.getColisoes());
        System.out.println("Tempo de inserção: " + tempoInsercaoSoma + " ns");
        System.out.println("Tempo de busca: " + tempoBuscaSoma + " ns");

        System.out.println("Distribuição das chaves:");
        tabelaSoma.mostrarDistribuicao();

        System.out.println("Colisões por posição:");
        tabelaSoma.mostrarColisoesPorPosicao();

        System.out.println("Tabela Hash com Função Polinomial");
        System.out.println("Número total de colisões: " + tabelaPolinomial.getColisoes());
        System.out.println("Tempo de inserção: " + tempoInsercaoPolinomial + " ns");
        System.out.println("Tempo de busca: " + tempoBuscaPolinomial + " ns");

        System.out.println("Distribuição das chaves:");
        tabelaPolinomial.mostrarDistribuicao();

        System.out.println("Colisões por posição:");
        tabelaPolinomial.mostrarColisoesPorPosicao();
    }

    public static int lerCSV(String caminhoArquivo, String[] nomes) {
        int contador = 0;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));

            String linha;

            while ((linha = leitor.readLine()) != null && contador < nomes.length) {
                linha = linha.trim();

                if (!linha.isEmpty()) {
                    String[] partes = linha.split(",");

                    String nome = partes[0].trim();

                    if (!nome.equalsIgnoreCase("nome")) {
                        nomes[contador] = nome;
                        contador++;
                    }
                }
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
        }

        return contador;
    }
}