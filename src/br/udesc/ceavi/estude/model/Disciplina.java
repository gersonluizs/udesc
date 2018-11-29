package br.udesc.ceavi.estude.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Esta classe define os atributos e comportamentos das disciplinas do usuario
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */
@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_disciplina")
    private int codigo;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "cargaHoras")
    private String cargaHoraria;
    
    @OneToMany (mappedBy = "disciplina")
    private List<Conteudo> conteudos;
    
    @Column(name = "constatus")
    private Status status;

    public Disciplina(int codigo, String nome, String descricao, String cargaHoraria, List<Conteudo> conteudos, Status status) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        conteudos = new ArrayList<>();
        this.status = status;
    }

    public Disciplina() {
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

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", cargaHoraria=" + cargaHoraria + ", conteudos=" + conteudos + ", status=" + status + '}';
    }

}
