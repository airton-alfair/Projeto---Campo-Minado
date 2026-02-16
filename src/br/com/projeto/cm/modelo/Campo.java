package br.com.projeto.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;
    private final int coluna;

    private boolean aberto; // por padrao o boolean comeca False
    private boolean minado; //
    private boolean marcado;

    private List<Campo> vizinhos = new ArrayList<>();

    Campo(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean adicionarVizinho(Campo vizinho){
        boolean linhaDiferente = linha != vizinho.linha; //Candidato de vizinho
        boolean colunaDiferente = coluna != vizinho.coluna; //Candidato de vizinho
        boolean diagonal = linhaDiferente && colunaDiferente;

        // "Distancias"
        int deltaLinha = Math.abs(linha - vizinho.linha);
        int deltaColuna = Math.abs(linha - vizinho.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        if(deltaGeral == 1 && !diagonal){
            vizinhos.add(vizinho);
            return true;
        }else if(deltaGeral == 2 && diagonal){
            vizinhos.add(vizinho);
            return true;
        }else{
            return false;
        }
    }
}
