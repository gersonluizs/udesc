package br.udesc.ceavi.estude.model;

import br.udesc.ceavi.estude.control.Criptografia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Esta classe define os atributos e comportamentos de um usario
 * @author Gerson, Lucas and Matheus 
 * @version 1.0
 * @since 19/08/2018
 */
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usucodigo")
    private int codigo;
    
    @Column(name = "usunome")
    private String nome;
    
    @Column(name = "usuemail")
    private String email;
    
    @Column(name = "ususenha")
    private String senha;
    
    /*@OneToOne
    @Column(name = "agecodigo")*/
    @Transient
    private Agenda agenda;
    
    /*@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
    @JoinColumn(name = "usucodigo")*/
    @Transient
    private List<Notificacao> notificacoes;
    
    /*@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
    @JoinColumn(name = "usucodigo")*/
    @Transient
    private List<Privilegio> privilegios;
    
    public Usuario() {
        super();
        this.privilegios = new ArrayList<Privilegio>();
    }

    public Usuario(int codigo, String nome, String email, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        setSenha(senha);
        this.agenda = new Agenda();
        this.notificacoes = new ArrayList<Notificacao>();
        this.privilegios = new ArrayList<Privilegio>();
    }

    public void addAgenda(int codigo, String nome, String descricao, String horarioDedicado,
            String tempoDisponivel, String tempoOcupado) {

        agenda = new Agenda();
        agenda.setCodigo(codigo);
        agenda.setDescricao(descricao);
        agenda.setHorarioDedicado(horarioDedicado);
        agenda.setNome(nome);
        //agenda.addTarefa(codigo, nome, descricao, dataHoraInicio, dataHoraFim, notificacao);
        agenda.setTempoOcupado(tempoOcupado);
        agenda.setTempoDisponivel(tempoDisponivel);
    }

    public void removeAgenda() {
        this.agenda = null;
    }

    public void addPrivilegio(Acao acao, Tela tela) {
        Privilegio privilegio = new Privilegio();
        privilegio.setAcao(acao);
        privilegio.setTela(tela);
        
        privilegios.add(privilegio);
    }
    
    public void addPrivilegio(Privilegio privilegio) {
        privilegios.add(privilegio);
    }

    public void removePrivilegio(Privilegio privilegio) {
        this.privilegios.remove(privilegio);
    }
    
    public List<Privilegio> getPrivilegios(){
        return privilegios;
    }
    
    public boolean temPrivilegio (Privilegio privilegio){
        return privilegios.contains(privilegio);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Este metodo verificar se a senha passada como parametro é 
     * igual a senha do usuário
     * @author Gerson Luiz
     * @param outraSenha senha em formato String ainda não criptografada
     * @return true: se as senhas forem iguais, false: se forem diferentes
     * @version 1.0
     * @since 23/09/2018
     */
    public boolean senhaEquals(String outraSenha) {
        Criptografia pass = new Criptografia();
        
        return pass.sha256(outraSenha).equals(this.senha);
    }

    /**
    * Este metodo salva a senha passada como parametro utilizando criptografia
    * para que não seja salva no banco em formato texto
    * @author Gerson Luiz
    * @param senha 
    * @version 1.0
    * @since 23/09/2018
    * @see Criptografia
    */
    public void setSenha (String senha){
        Criptografia pass = new Criptografia();
        this.senha = pass.sha256(senha);
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacao(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }
    
    public void addNotificao(Notificacao notificacao) {
        this.notificacoes.add(notificacao);
    }

}
