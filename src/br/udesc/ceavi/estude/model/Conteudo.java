package br.udesc.ceavi.estude.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta classe define os atributos e comportamentos dos conteudos de uma materia
 *
 * @author Gerson, Lucas and Matheus
 * @version 1.0
 * @since 19/08/2018
 */
@Entity
@Table(name = "conteudo")
public class Conteudo {

    public Conteudo(int codigo, String nome, String descricao, Prioridade prioridade, Status status) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.disciplina = disciplina;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "concodigo")
    private int codigo;

    @Column(name = "connome")
    private String nome;

    @Column(name = "condescricao")
    private String descricao;

    @Column(name = "conprioridade")
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @Column(name = "constatus")
    private Status status;

    @OneToMany(mappedBy = "conteudo")
    private List<Tarefa> tarefas;

    public Conteudo(int codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = Prioridade.NORMAL;
        this.status = Status.PENDENTE;
        tarefas = new ArrayList<>();
    }

    public Conteudo() {
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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Conteudo{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", prioridade=" + prioridade + ", status=" + status + '}';
    }

}
