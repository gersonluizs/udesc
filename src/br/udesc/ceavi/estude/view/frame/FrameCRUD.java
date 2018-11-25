/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.view.panel.CRUDActionPanel;
import java.awt.*;
import javax.swing.*;

/**
 * Esta classe define os atributos e comportamentos de uma tela CRUD
 * @author Gerson Luiz
 * @since 23/09/2018
 * @version 1.0
 */
public abstract class FrameCRUD extends JInternalFrame {

    //JPanel principal do JInternalFrame, que será utilizado como container dos demais componetes
    private JPanel panelPrincipal;

    //Painel contendo os botões de funcionamento da tela tipo CRUD
    private CRUDActionPanel panelBotoesCRUD;

    //Dimensão para o JInternalFrame
    private Dimension dimension;

    //Gerenciador de Layout que definirá a disposição dos objetos adicionados no Panel
    private LayoutManager layout;
   

    /**
     * Construtor para os JInternalFrame do tipo CRUD.
     *
     * @param titulo Título da tela de Cadastro
     * @param dimension Tamanho desejado da tela
     * @throws HeadlessException
     */
    public FrameCRUD(String titulo, Dimension dimension) throws HeadlessException {
        // Define o atributo dimension
        this.dimension = dimension;

        //Constroi o JInternalFrame
        initializeComponets();
        addComponets();

        //Parametrização da GUI
        super.setSize(dimension);
        super.setTitle(titulo);
        super.setLayout(layout);

        //Encerra a Thread quando o frame é encerrado
        //Isto serve nos casos onde a JFrame e/ou JInternalFrame roda em uma Thread exclusiva
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Método que istancia os objetos que serão utilizados na JInternalFrame
     */
    private void initializeComponets() {
        //Define o painel principla da tela
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(dimension);
        super.setResizable(false);

        //Define o painel com os botẽos de funcionamento do CRUD
        panelBotoesCRUD = new CRUDActionPanel(this);

        //Define o gerenciador de layout
        layout = new BorderLayout();
        panelPrincipal.setLayout(layout);

    }

    /**
     * Método que adiciona os componentes no container da JInternalFrame
     */
    private void addComponets() {
        //Define o container
        this.setContentPane(panelPrincipal);

        //Adiciona o painel com os botões CRUD na JInternalFrame
        panelPrincipal.add(panelBotoesCRUD, BorderLayout.SOUTH);
    }

    /**
     * Método que permite inserir um painel contendo os campos do formulário na
     * JInternalFrame
     *
     * @param container Panel que deverá ser adiconado
     */
    public void addFormulario(Container container) {
        //Adiciona o container na posiçõa central do formulário
        panelPrincipal.add(container, BorderLayout.CENTER);
    }

    /**
     * Método que permite pegar o painel com os botões do CRUD
     *
     * @return CRUDActionPanel contendo os botões para as funcionalidades do
     * tipo CRUD
     */
    public CRUDActionPanel getPanelBotoesCRUD() {
        return panelBotoesCRUD;
    }

    /**
     * Método abstrato que deverá ser implementado nas classes filhas para
     * limpar os campos do formulário
     */
    public abstract void limparCampos();

    /**
     * Método abstrato que deverá ser implementado nas classes filhas para
     * carregar os campos do formulário
     */
    public abstract void carregarCampos();

    /**
     * Método abstrato que deverá ser implementado nas classes filhas para
     * tornar editavel ou não editavel, os campos do formulário
     * @param b true or false
     */
    public abstract void setEditavel(boolean b);
}
