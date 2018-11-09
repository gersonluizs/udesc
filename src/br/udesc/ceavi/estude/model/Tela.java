package br.udesc.ceavi.estude.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta classe define as caracteristicas das telas do sistema
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

@Entity
@Table(name = "tela")
public class Tela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "telcodigo")
    private int codigo;
    
    @Column(name = "teldescricao")
    private String descricao;
    
    public Tela(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tela{" + "codigo=" + codigo + ", descricao=" + descricao + '}';
    }

}
