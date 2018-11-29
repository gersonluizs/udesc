package br.udesc.ceavi.estude.model;

/**
 * Esta classe define os atributos e comportamentos o status de Conteudo, Disciplina e Tarefa
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public enum Status {

    EM_ANDAMENTO("Em andamento"),
    PENDENTE("Pendente"),
    CONCLUIDO("Concluido");

    private String tipo2;

    private Status(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    @Override
    public String toString() {
        return tipo2;
    }

}
