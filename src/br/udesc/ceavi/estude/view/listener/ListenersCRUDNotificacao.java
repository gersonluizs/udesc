/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.listener;

import br.udesc.ceavi.estude.control.dao.core.DAO;
import br.udesc.ceavi.estude.control.dao.core.JPADAO;
import br.udesc.ceavi.estude.model.Conteudo;
import br.udesc.ceavi.estude.model.Notificacao;
import br.udesc.ceavi.estude.view.frame.FrameCRUD;
import br.udesc.ceavi.estude.view.frame.FrameCRUDConteudo;
import br.udesc.ceavi.estude.view.frame.FrameCRUDNotificacao;
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
public class ListenersCRUDNotificacao {

    //Atributo que mantém referência ao objeto da camada de Model    
    private Notificacao notificacao;

    //Atributo que mantém referência a camada View
    private FrameCRUDNotificacao tela;

    /**
     * Construtor do Listener para o CRUD Conteudo
     *
     * @param conteudo Objeto endereco da camada de Model
     * @param tela Objeto tela da camada View
     */
    public ListenersCRUDNotificacao(Notificacao notificacao, FrameCRUD tela) {
        //Define o objeto acao
        this.notificacao = notificacao;

        //Define a tela do cadastro
        this.tela = (FrameCRUDNotificacao) tela;

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
                            dao.pesquisarPorId(Notificacao.class, java.lang.Integer.parseInt(tela.getTfCodigo().getText()))
                    );

                } catch (Exception ex) {
                    //Apresenta o erro em uma mensagem para o usuário.
                    JOptionPane.showMessageDialog(tela, ex.getMessage());

                    Logger.getLogger(ListenersCRUDNotificacao.class.getName()).log(Level.SEVERE, null, ex);
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

            notificacao.setDescricao(tela.getTfDescricao().getText());

            try {
                dao.inserir(notificacao);

            } catch (Exception ex) {
                //Apresenta o erro em uma mensagem para o usuário.
                JOptionPane.showMessageDialog(tela, ex.getMessage());

                Logger.getLogger(ListenersCRUDNotificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            tela.limparCampos();
        }
    }
}
