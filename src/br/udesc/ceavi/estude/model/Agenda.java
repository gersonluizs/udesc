package br.udesc.ceavi.estude.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Esta classe define os atributos e comportamentos da agenda de um usuario
 *
 * @author Gerson, Lucas and Matheus
 * @version 1.0
 * @since 19/08/2018
 */
@Entity
@Table(name = "agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_agenda")
    private int codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "t_Dedicado")
    private String horarioDedicado;

    @Column(name = "t_disponivel")
    private String tempoDisponivel;

    @Column(name = "t_ocupado")
    private String tempoOcupado;

    @OneToOne
    @Column(name = "tarcodigo")
    private Tarefa tarefa;

    public Agenda(int codigo, String nome, String descricao, String horarioDedicado, String tempoDisponivel, String tempoOcupado, Tarefa tarefa) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.horarioDedicado = horarioDedicado;
        this.tempoDisponivel = tempoDisponivel;
        this.tempoOcupado = tempoOcupado;
        this.tarefa = tarefa;
    }

    public Agenda() {
        super();
    }

    public Agenda(int i, String descricao) {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorarioDedicado() {
        return horarioDedicado;
    }

    public void setHorarioDedicado(String horarioDedicado) {
        this.horarioDedicado = horarioDedicado;
    }

    public String getTempoDisponivel() {
        return tempoDisponivel;
    }

    public void setTempoDisponivel(String tempoDisponivel) {
        this.tempoDisponivel = tempoDisponivel;
    }

    public String getTempoOcupado() {
        return tempoOcupado;
    }

    public void setTempoOcupado(String tempoOcupado) {
        this.tempoOcupado = tempoOcupado;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void addTarefa(int codigo, String nome, String descricao, String dataHoraInicio,
            String dataHoraFim) {

        tarefa = new Tarefa();
        tarefa.setCodigo(codigo);
        tarefa.setNome(nome);
        tarefa.setDescricao(descricao);
        tarefa.setDataHoraFim(dataHoraFim);
        tarefa.setDataHoraInicio(dataHoraInicio);
    }

    public void removeTarefa() {
        this.tarefa = null;
    }

    @Override
    public String toString() {
        return "Agenda{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", horarioDedicado=" + horarioDedicado + ", tempoDisponivel=" + tempoDisponivel + ", tempoOcupado=" + tempoOcupado + ", tarefa=" + tarefa + '}';
    }

}
