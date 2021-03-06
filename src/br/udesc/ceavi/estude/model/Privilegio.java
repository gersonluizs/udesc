package br.udesc.ceavi.estude.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Esta classe define os atributos e comportamentos de privilegios de usuarios
 *
 * @author Gerson, Lucas and Matheus
 * @version 1.0
 * @since 19/08/2018
 */
@Entity
@Table(name = "privilegio")
public class Privilegio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pricodigo")
    private int codigo;
    
    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "acacodigo")
    private Acao acao;

    @OneToOne
    @JoinColumn(name = "telcodigo")
    private Tela tela;

    @ManyToOne
    private Usuario usuario;

    public Privilegio() {
        super();
    }

    public Privilegio(int codigo,String nome, Acao acao, Tela tela) {
        this.codigo = codigo;
        this.nome =nome;
        this.acao = acao;
        this.tela = tela;
    }

    public Privilegio(int i, String descricao) {
        super();
    }

    public Acao getAcao() {
        return acao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Privilegio{" + " codigo=" + codigo + " acao=" + acao + ", tela=" + tela + '}';
    }

    /**
     * Equals implementado sem validar se o código é igual, assim será útil no
     * contains dos privilégios do usuário.
     *
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
