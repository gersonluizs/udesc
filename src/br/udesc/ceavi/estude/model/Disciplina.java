package br.udesc.ceavi.estude.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe define os atributos e comportamentos das disciplinas do usuario
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public class Disciplina {

    private int codigo;
    private String nome;
    private String descricao;
    private String cargaHoraria;
    private List<Conteudo> conteudos;
    private Status status;

    public Disciplina(int codigo, String nome, String descricao, String cargaHoraria, List<Conteudo> conteudos, Status status) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        conteudos = new ArrayList<>();
        this.status = status;
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
