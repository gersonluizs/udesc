/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.listener;

import br.udesc.ceavi.estude.control.dao.core.DAO;
import br.udesc.ceavi.estude.control.dao.core.JPADAO;
import br.udesc.ceavi.estude.model.Usuario;
import br.udesc.ceavi.estude.view.frame.FrameCRUD;
import br.udesc.ceavi.estude.view.frame.FrameCRUDUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Classe que define a implementação padrão para os Listeners referentes as telas
 * do tipo CRUD.
 * 
 * @author Gerson Luiz
 */
public class ListenersCRUDUsuario {
    //Atributo que mantém referência ao objeto da camada de Model
    private Usuario usuario;
    
    //Atributo que mantém referência a camada View
    private FrameCRUDUsuario tela;

    /**
     * Construtor do Listener para o CRUD Usuario
     * @param usuario Objeto endereco da camada de Model
     * @param tela Objeto tela da camada View
     */
    public ListenersCRUDUsuario(Usuario usuario, FrameCRUD tela) {
        //Define o objeto usuario
        this.usuario = usuario;
        
        //Define a tela do cadastro
        this.tela = (FrameCRUDUsuario) tela;

        //Adiciona os Listeners para os botões
        addCrudListeners();
    }
    
    

    /**
     * Método que adiciona os Listener para os botões do formulário
     */
    private void addCrudListeners() {
        JButton botao;

        //Carrega e define o comportamento para o botão Novo
        botao = tela.getPanelBotoesCRUD().getBtNovo();
        botao.addActionListener(new btNovoActionListener());

        //Carrega e define o comportamento para o botão Cancelar
        botao = tela.getPanelBotoesCRUD().getBtCancelar();
        botao.addActionListener(new btCancelarActionListener());

        //Carrega e define o comportamento para o botão Excluir
        botao = tela.getPanelBotoesCRUD().getBtExcluir();
        botao.addActionListener(new btExcluirActionListener());

        //Carrega e define o comportamento para o botão Gravar
        botao = tela.getPanelBotoesCRUD().getBtGravar();
        botao.addActionListener(new btGravarActionListener());
    }
    
    /**
     * Classe interna que define o Listener para o botão Novo
     * @author Gerson Luiz Saldanha dos Santos
     * @version 1.0
     * @since 24/11/2018
     */
    private class btNovoActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tela.limparCampos();
        }
    }

    /**
     * Classe interna que define o Listener para o botão Cancelar
     * @author Gerson Luiz Saldanha dos Santos
     * @version 1.0
     * @since 24/11/2018
     */
    private class btCancelarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tela.dispose();
        }
    }

    /**
     * Classe interna que define o Listener para o botão Excluir
     * @author Gerson Luiz Saldanha dos Santos
     * @version 1.0
     * @since 24/11/2018
     */
    private class btExcluirActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int resposta = JOptionPane.showConfirmDialog(tela, "deseja exluir este usuário?", 
                                                                "Confirmar Exclusão", 
                                                                JOptionPane.YES_NO_OPTION, 
                                                                JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                //chama a classe controller  que faz a exclusão do objeto
                DAO dao = (DAO) new JPADAO();
                
                try {
                    
                dao.deletar(
                  dao.pesquisarPorId(Usuario.class, java.lang.Integer.parseInt(tela.getTfCodigo().getText()) )
                );
                
                } catch (Exception ex) {
                    //Apresenta o erro em uma mensagem para o usuário.
                    JOptionPane.showMessageDialog(tela, ex.getMessage());

                    Logger.getLogger(ListenersCRUDUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                tela.limparCampos();
            }
        }
    }

    /**
     * Classe interna que define o Listener para o botão Gravar
     * @author Gerson Luiz Saldanha dos Santos
     * @version 1.0
     * @since 24/11/2018
     */
    private class btGravarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //chama a classe controller que faz a inserção do objeto
            DAO dao = (DAO) new JPADAO();

            usuario.setNome( tela.getTfNome().getText() );
            usuario.setEmail( tela.getTfEmail().getText() );
            usuario.setSenha( tela.getTfSenha().getText() );
            
            try {
                
                if( tela.getTfCodigo().getText().equals("") || tela.getTfCodigo().getText().equals(null) ){
                    dao.inserir(usuario);
                } else{
                    usuario.setCodigo( Integer.parseInt(tela.getTfCodigo().getText()) );
                    dao.atualizar(usuario);
                }   
                
            } catch (Exception ex) {
                //Apresenta o erro em uma mensagem para o usuário.
                JOptionPane.showMessageDialog(tela, ex.getMessage());
                 
                Logger.getLogger(ListenersCRUDUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            tela.limparCampos();
        }
    }
}
