/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.listener;

import br.udesc.ceavi.estude.control.dao.core.DAO;
import br.udesc.ceavi.estude.control.dao.core.JPADAO;
import br.udesc.ceavi.estude.model.Notificacao;
import br.udesc.ceavi.estude.model.Privilegio;
import br.udesc.ceavi.estude.view.frame.FrameCRUD;
import br.udesc.ceavi.estude.view.frame.FrameCRUDNotificacao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDPrivilegios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ListenersCRUDPrivilegios {

    //Atributo que mantém referência ao objeto da camada de Model    
    private Privilegio privilegio;

    //Atributo que mantém referência a camada View
    private FrameCRUDPrivilegios tela;

    /**
     * Construtor do Listener para o CRUD Conteudo
     *
     * @param privilegios Objeto endereco da camada de Model
     * @param tela Objeto tela da camada View
     */
    public ListenersCRUDPrivilegios(Privilegio privilegio, FrameCRUD tela) {
        //Define o objeto acao
        this.privilegio = privilegio;

        //Define a tela do cadastro
        this.tela = (FrameCRUDPrivilegios) tela;

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
     *
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
     *
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
     *
     * @author Gerson Luiz Saldanha dos Santos
     * @version 1.0
     * @since 24/11/2018
     */
    private class btExcluirActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int resposta = JOptionPane.showConfirmDialog(tela, "deseja exluir está Ação?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                //chama a classe controller  que faz a exclusão do objeto
                DAO dao = (DAO) new JPADAO();

                try {

                    dao.deletar(
                            dao.pesquisarPorId(Privilegio.class, java.lang.Integer.parseInt(tela.getTfCodigo().getText()))
                    );

                } catch (Exception ex) {
                    //Apresenta o erro em uma mensagem para o usuário.
                    JOptionPane.showMessageDialog(tela, ex.getMessage());

                    Logger.getLogger(ListenersCRUDPrivilegios.class.getName()).log(Level.SEVERE, null, ex);
                }

                tela.limparCampos();
            }
        }
    }

    /**
     * Classe interna que define o Listener para o botão Gravar
     *
     * @author Gerson Luiz Saldanha dos Santos
     * @version 1.0
     * @since 24/11/2018
     */
    private class btGravarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //chama a classe controller que faz a inserção do objeto
            DAO dao = (DAO) new JPADAO();

            privilegio.setNome(tela.getTfNome().getText());

            try {
                dao.inserir(privilegio);

            } catch (Exception ex) {
                //Apresenta o erro em uma mensagem para o usuário.
                JOptionPane.showMessageDialog(tela, ex.getMessage());

                Logger.getLogger(ListenersCRUDPrivilegios.class.getName()).log(Level.SEVERE, null, ex);
            }

            tela.limparCampos();
        }
    }
}
