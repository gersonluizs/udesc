package br.udesc.ceavi.estude.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Esta classe define os atributos e comportamentos das tarefas do usuario
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tarcodigo")
    private int codigo;
    
    @Column(name = "tarnome")
    private String nome;
    
    @Column(name = "tardescricao")
    private String descricao;
    
    @Column(name = "tardatahorainicio")
    private Date dataHoraInicio;
    
    @Column(name = "tardatahorafim")
    private Date dataHoraFim;
    
    @OneToMany (mappedBy = "tarefa")
    private List<Notificacao> notificacoes;
    private tipoTarefa tipotarefa;
    private Status status;
    
    @ManyToOne
    @JoinColumn(name = "id_conteudo")
    private Conteudo conteudo;

    public Tarefa(int codigo, String nome, String descricao, Date dataHoraInicio, Date dataHoraFim, List<Notificacao> notificacoes, tipoTarefa tipotarefa, Status status, Conteudo conteudo) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.notificacoes= new ArrayList<>();
        this.tipotarefa = tipotarefa;
        this.status = status;
        this.conteudo = conteudo;
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

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", dataHoraInicio=" + dataHoraInicio + ", dataHoraFim=" + dataHoraFim + ", notificacoes=" + notificacoes + ", tipotarefa=" + tipotarefa + ", status=" + status + ", conteudo=" + conteudo + '}';
    }
    
    
}
