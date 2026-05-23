# Tabelas Hash em Java

Este projeto foi desenvolvido em Java com o objetivo de implementar e comparar duas tabelas hash utilizando conceitos de Programação Orientada a Objetos.

O sistema realiza a leitura de um arquivo CSV contendo 20.000 nomes distintos e insere esses dados em duas tabelas hash com capacidade máxima de 16 posições. Cada tabela utiliza uma função hash diferente, permitindo comparar o comportamento de distribuição das chaves, quantidade de colisões e desempenho nas operações de inserção e busca.

Para o tratamento de colisões, foi utilizado o método de encadeamento separado, em que cada posição da tabela armazena uma lista de nomes. Dessa forma, quando mais de uma chave gera o mesmo índice, os valores são mantidos na mesma posição por meio de uma estrutura de lista.

O projeto também gera um relatório no console contendo o número total de colisões, colisões por posição, tempo de inserção, tempo de busca e distribuição das chaves em cada tabela hash.
