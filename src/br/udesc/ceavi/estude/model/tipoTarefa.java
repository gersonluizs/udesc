package br.udesc.ceavi.estude.model;

/**
 * Esta classe define os atributos e comportamentos de os tipos de tarefas
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public enum tipoTarefa {

    PROVA("Prova"),
    TRABALHO("Trabalho"),
    ESTUDO("Estudo");

    private String tipo;

    private tipoTarefa(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "tipoTarefa{" + "tipo=" + tipo + '}';
    }
}