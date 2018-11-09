package br.udesc.ceavi.estude.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Esta classe define os atributos e comportamentos das tarefas do usuario
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public class Tarefa {
    
    
 
    private int codigo;
    private String nome;
    private String descricao;
    private Date dataHoraInicio;
    private Date dataHoraFim;
    private Notificacao notificacao;
    private tipoTarefa tipotarefa;
    private Status status;

    public Tarefa(int codigo, String nome, String descricao, Date dataHoraInicio, Date dataHoraFim, Notificacao notificacao, tipoTarefa tipotarefa, Status status) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.notificacao = notificacao;
        this.tipotarefa = tipotarefa;
        this.status = status;
    }

    public Tarefa() {
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

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public tipoTarefa getTipotarefa() {
        return tipotarefa;
    }

    public void setTipotarefa(tipoTarefa tipotarefa) {
        this.tipotarefa = tipotarefa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addNotificacao(int codigo, String assunto, String descricao, Date dataHora,
            boolean visualizado) {

    }

    public void removeNotificacao() {
        this.notificacao = null;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", dataHoraInicio=" + dataHoraInicio + ", dataHoraFim=" + dataHoraFim + ", notificacao=" + notificacao + '}';
    }

}
