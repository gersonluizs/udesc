package br.udesc.ceavi.estude.model;

/**
 * Esta classe define os atributos e comportamentos de prioridade dos conteudos
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public enum Prioridade {

    ALTA("Alta"),
    NORMAL("Normal"),
    BAIXA("Baixa");

    private String tipo1;

    private Prioridade(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    @Override
    public String toString() {
        return "Prioridade{" + "tipo1=" + tipo1 + '}';
    }

}
