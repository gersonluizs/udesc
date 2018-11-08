package br.udesc.ceavi.estude.model;

/**
 * Esta classe define as caracteristicas das telas do sistema
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public class Tela {

    private int codigo;
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
