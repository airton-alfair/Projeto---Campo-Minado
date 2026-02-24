package br.com.projeto.cm.modelo;

import br.com.projeto.cm.excecao.ExplosaoException;

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
        int deltaColuna = Math.abs(coluna - vizinho.coluna);
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

    // Adicionando a marcação
    void alternarMarcacao(){
        if(!aberto){
            marcado = !marcado;
        }
    }

    boolean abrir(){
        if(!aberto && !marcado){
            aberto = true;

            if(minado){
                throw new ExplosaoException();
            }

            if(vizinhancaSegura()){
                vizinhos.forEach(v -> v.abrir()); // quando nao coloca numero é pq esta seguro
            }
            return true;
        } else {
            return false;
        }
    }

    //momento em que abre sequencialmente varias casas
    boolean vizinhancaSegura(){
        return vizinhos.stream().noneMatch(v -> v.minado); // 'v' de  vizinho
    }

    void minar(){
        minado = true;
    }

    public boolean isMinado(){
        return minado;
    }

    // Basicamente um metodo get
    public boolean isMarcado(){
        return marcado;
    }

    void setAberto(boolean aberto){
        this.aberto = aberto;
    }

    //Outro metodo get
    public boolean isAberto(){
        return aberto;
    }

    public boolean isFechado(){
        return !isAberto();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    // Para marcacao
    boolean objetivoAlcancado(){
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    // Mostra o numero na casa proximo as minas
    long minasNaVizinhanca(){
        return vizinhos.stream().filter(v ->v.minado).count();
    }

    void reiniciar(){
        aberto = false;
        minado = false;
        marcado = false;
    }

    //marcacoes
    public String toString(){
        if(marcado){
            return "X";
        } else if(aberto && minado){
            return "*";
        } else if(aberto &&  minasNaVizinhanca() > 0){
            return Long.toString(minasNaVizinhanca());
        } else if(aberto){
            return " ";
        } else{
            return "?"; // relata que nao esta aberto nem fechado
        }
    }
}
