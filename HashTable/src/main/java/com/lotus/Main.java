package com.lotus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String caminhoArquivo = "src/nomes_20000_reais_distintos.csv";

        ArrayList<String> nomes = lerCSV(caminhoArquivo);

        TabelaHash tabelaSoma = new TabelaHashSoma(16);
        TabelaHash tabelaPolinomial = new TabelaHashPolinomial(16);

        System.out.println("Total de nomes lidos: " + nomes.size());

        System.out.println("\nInserindo nomes nas tabelas...");

        long inicioInsercaoSoma = System.nanoTime();

        for (String nome : nomes) {
            tabelaSoma.inserir(nome);
        }

        long fimInsercaoSoma = System.nanoTime();

        long inicioInsercaoPolinomial = System.nanoTime();

        for (String nome : nomes) {
            tabelaPolinomial.inserir(nome);
        }

        long fimInsercaoPolinomial = System.nanoTime();

        long tempoInsercaoSoma = fimInsercaoSoma - inicioInsercaoSoma;
        long tempoInsercaoPolinomial = fimInsercaoPolinomial - inicioInsercaoPolinomial;

        long inicioBuscaSoma = System.nanoTime();

        for (String nome : nomes) {
            tabelaSoma.buscar(nome);
        }

        long fimBuscaSoma = System.nanoTime();

        long inicioBuscaPolinomial = System.nanoTime();

        for (String nome : nomes) {
            tabelaPolinomial.buscar(nome);
        }

        long fimBuscaPolinomial = System.nanoTime();

        long tempoBuscaSoma = fimBuscaSoma - inicioBuscaSoma;
        long tempoBuscaPolinomial = fimBuscaPolinomial - inicioBuscaPolinomial;

        System.out.println("relatoria final");

        System.out.println("--- Tabela Hash com Função Soma ---");
        System.out.println("Número total de colisões: " + tabelaSoma.getColisoes());
        System.out.println("Tempo de inserção: " + tempoInsercaoSoma + " ns");
        System.out.println("Tempo de busca: " + tempoBuscaSoma + " ns");

        System.out.println("Distribuição das chaves:");
        tabelaSoma.mostrarDistribuicao();

        System.out.println("Colisões por posição:");
        tabelaSoma.mostrarColisoesPorPosicao();

        System.out.println("--- Tabela Hash com Função Polinomial ---");
        System.out.println("Número total de colisões: " + tabelaPolinomial.getColisoes());
        System.out.println("Tempo de inserção: " + tempoInsercaoPolinomial + " ns");
        System.out.println("Tempo de busca: " + tempoBuscaPolinomial + " ns");

        System.out.println("Distribuição das chaves:");
        tabelaPolinomial.mostrarDistribuicao();

        System.out.println("Colisões por posição:");
        tabelaPolinomial.mostrarColisoesPorPosicao();

        System.out.println("=================================================");
    }

    public static ArrayList<String> lerCSV(String caminhoArquivo) {
        ArrayList<String> nomes = new ArrayList<>();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));

            String linha;

            while ((linha = leitor.readLine()) != null) {
                linha = linha.trim();

                if (!linha.isEmpty()) {
                    String[] partes = linha.split(",");

                    String nome = partes[0].trim();

                    if (!nome.equalsIgnoreCase("nome")) {
                        nomes.add(nome);
                    }
                }
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        return nomes;
    }
}