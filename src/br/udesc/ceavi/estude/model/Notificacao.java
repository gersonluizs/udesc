/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta classe define os atributos e comportamentos de notificacao de tarefas para o usuario
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notcodigo")
    private int codigo;
    
    @Column(name = "notassunto")
    private String assunto;
    
    @Column(name = "notdescricao")
    private String descricao;
    
    @Column(name = "notdatahora")
    private String dataHora;
    
    @Column(name = "notvisualizado")
    private boolean visualizado;
    
    @ManyToOne
    private Usuario usuario;
    
    public Notificacao(){
        super();
    }
    
    public Notificacao(int codigo, String assunto, String descricao, String dataHora, boolean visualizado) {
        this.codigo = codigo;
        this.assunto = assunto;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.visualizado = visualizado;
    }

    public Notificacao(int i, String descricao) {
     super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    @Override
    public String toString() {
        return "Notificacao{" + "codigo=" + codigo + ", assunto=" + assunto + ", descricao=" + descricao + ", dataHora=" + dataHora + ", visualizado=" + visualizado + '}';
    }

}
