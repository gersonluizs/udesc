
package br.udesc.ceavi.estude.model;

import java.util.Objects;

/**
 * Esta classe define os atributos e comportamentos de privilegios do usuario
 *
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */

public class Privilegio {
    private int codigo;
    private Acao acao;
    private Tela tela;

    public Privilegio() {
        super();
    }
    
    public Privilegio( int codigo, Acao acao, Tela tela) {
        this.codigo = codigo;
        this.acao = acao;
        this.tela = tela;
    }
    
    public Privilegio( Acao acao, Tela tela) {
        // this.codigo = codigo; // está implementação deverá pegar o maior código + 1
        this.acao = acao;
        this.tela = tela;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    @Override
    public String toString() {
        return "Privilegio{" + " codigo=" + codigo + " acao=" + acao + ", tela=" + tela + '}';
    }

    /**
     * Equals implementado sem validar se o código é igual, assim será útil no 
     * contains dos privilégios do usuário.
     * @param obj objeto a comparar para saber
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Privilegio other = (Privilegio) obj;
        if (!Objects.equals(this.acao, other.acao)) {
            return false;
        }
        if (!Objects.equals(this.tela, other.tela)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.acao);
        hash = 47 * hash + Objects.hashCode(this.tela);
        return hash;
    }
}
