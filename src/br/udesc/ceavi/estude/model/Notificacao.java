/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.model;

import java.util.Date;

/**
 * Esta classe define os atributos e comportamentos de notificacao de tarefas para o usuario
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public class Notificacao {

    private int codigo;
    private String assunto;
    private String descricao;
    private Date dataHora;
    private boolean visualizado;
    
    public Notificacao(){
        super();
    }
    
    public Notificacao(int codigo, String assunto, String descricao, Date dataHora, boolean visualizado) {
        this.codigo = codigo;
        this.assunto = assunto;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.visualizado = visualizado;
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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }

    @Override
    public String toString() {
        return "Notificacao{" + "codigo=" + codigo + ", assunto=" + assunto + ", descricao=" + descricao + ", dataHora=" + dataHora + ", visualizado=" + visualizado + '}';
    }

}
