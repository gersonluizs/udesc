/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.listener;

import br.udesc.ceavi.estude.control.dao.core.DAO;
import br.udesc.ceavi.estude.control.dao.core.JPADAO;
import br.udesc.ceavi.estude.model.Tela;
import br.udesc.ceavi.estude.view.frame.FrameCRUD;
import br.udesc.ceavi.estude.view.frame.FrameCRUDTela;
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
public class ListenersCRUDTela {

    //Atributo que mantém referência ao objeto da camada de Model    
    private Tela tela;

    //Atributo que mantém referência a camada View
    private FrameCRUDTela tel;

    /**
     * Construtor do Listener para o CRUD Conteudo
     *
     * @param privilegios Objeto endereco da camada de Model
     * @param tela Objeto tela da camada View
     */
    public ListenersCRUDTela(Tela tela, FrameCRUD tel) {
        //Define o objeto acao
        this.tela = tela;

        //Define a tela do cadastro
        this.tel = (FrameCRUDTela) tel;

        //Adiciona os Listeners para os botões
        addCrudListeners();
    }

    /**
     * Método que adiciona os Listener para os botões do formulário
     */
    private void addCrudListeners() {
        JButton botao;

        //Carrega e define o comportamento para o botão Novo
        botao = tel.getPanelBotoesCRUD().getBtNovo();
        botao.addActionListener(new btNovoActionListener());

        //Carrega e define o comportamento para o botão Cancelar
        botao = tel.getPanelBotoesCRUD().getBtCancelar();
        botao.addActionListener(new btCancelarActionListener());

        //Carrega e define o comportamento para o botão Excluir
        botao = tel.getPanelBotoesCRUD().getBtExcluir();
        botao.addActionListener(new btExcluirActionListener());

        //Carrega e define o comportamento para o botão Gravar
        botao = tel.getPanelBotoesCRUD().getBtGravar();
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
            tel.limparCampos();
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
            tel.dispose();
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
            int resposta = JOptionPane.showConfirmDialog(tel, "deseja exluir está Ação?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                //chama a classe controller  que faz a exclusão do objeto
                DAO dao = (DAO) new JPADAO();

                try {

                    dao.deletar(
                            dao.pesquisarPorId(Tela.class, java.lang.Integer.parseInt(tel.getTfCodigo().getText()))
                    );

                } catch (Exception ex) {
                    //Apresenta o erro em uma mensagem para o usuário.
                    JOptionPane.showMessageDialog(tel, ex.getMessage());

                    Logger.getLogger(ListenersCRUDTela.class.getName()).log(Level.SEVERE, null, ex);
                }

                tel.limparCampos();
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

            tela.setNome(tel.getTfNome().getText());

            try {
                dao.inserir(tela);

            } catch (Exception ex) {
                //Apresenta o erro em uma mensagem para o usuário.
                JOptionPane.showMessageDialog(tel, ex.getMessage());

                Logger.getLogger(ListenersCRUDTela.class.getName()).log(Level.SEVERE, null, ex);
            }

            tel.limparCampos();
        }
    }
}
