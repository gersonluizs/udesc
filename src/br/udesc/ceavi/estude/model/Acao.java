package br.udesc.ceavi.estude.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta classe define os atributos e comportamentos de acao para os privilegios
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */
//ad
@Entity
@Table(name = "acao")
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "acacodigo")
    private int codigo;

    @Column(name = "acadescricao")
    private String descricao;

    public Acao() {
        super();
    }
   

    public Acao(int codigo, String descricao) {
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
        return "Acao{" + "codigo=" + codigo + ", descricao=" + descricao + '}';
    }

}
