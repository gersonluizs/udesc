/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.panel;

import java.awt.*;
import javax.swing.*;

/**
 * Esta classe define os atributos e comportamentos de panel para CRUD
 * @author Gerson Luiz
 * @since 23/09/2018
 * @version 1.0
 */
public class CRUDActionPanel extends JPanel {

    //Botões para as funcionalidades CRUD
    private JButton btCancelar;
    private JButton btNovo;
    private JButton btGravar;
    private JButton btExcluir;

    //Gerenciador de Layout 
    private LayoutManager layout;

    //Dimensão do painel
    private Dimension dimensaoBotao;

    //Dimensão padrão para os botões
    private Dimension dimensaoPainel;

    //Container onde o Painel será adicionado
    private Container parent;

    /**
     * Construtor do painel para o funcionamento dos formulários tipo CRUD
     *
     * @param parent Container onde o painel de botões deverá ser inserido
     */
    public CRUDActionPanel(Container parent) {
        //Define o parent
        this.parent = parent;

        //Constrói o panel com os botões
        initComponents();
        addComponents();

        //Parametrização do JPanel
        super.setVisible(true);
        super.setSize(dimensaoPainel);
    }

    /**
     * Método responsável pela instanciação dos objetos utilizados no JPanel
     */
    private void initComponents() {
        //Define o tamanho padrão para os botẽos do formulário
        dimensaoBotao = new Dimension(100, 20);

        //Define a dimensão do JPanel com base na largura definida no parent
        dimensaoPainel = new Dimension(parent.getWidth(), 30);

        //Define o gerenciador de layout para o JPanel
        layout = new FlowLayout(FlowLayout.CENTER);

        //Define o botão Cancelar
        btCancelar = new JButton("Cancelar");
        btCancelar.setSize(dimensaoBotao);

        //Define o botão Novo
        btNovo = new JButton("Novo");
        btNovo.setSize(dimensaoBotao);

        //Define o botão Gravar
        btGravar = new JButton("Gravar");
        btGravar.setSize(dimensaoBotao);

        //Define o botão Excluir
        btExcluir = new JButton("Excluir");
        btExcluir.setSize(dimensaoBotao);
    }

    /**
     * Método para adicionar os componentes no JPanel
     */
    private void addComponents() {
        //Define o gerenciador de layout
        this.setLayout(layout);

        //adiciona os botões no JPanel
        this.add(btCancelar);
        this.add(btNovo);
        this.add(btExcluir);
        this.add(btGravar);
    }

    /**
     * Método que retorna o Botão Cancelar do painel CRUD
     *
     * @return JButton para a funcionalidade Cancelar
     */
    public JButton getBtCancelar() {
        return btCancelar;
    }

    /**
     * Método que retorna o Botão Novo do painel CRUD
     *
     * @return JButton para a funcionalidade Novo
     */
    public JButton getBtNovo() {
        return btNovo;
    }

    /**
     * Método que retorna o Botão Gravar do painel CRUD
     *
     * @return JButton para a funcionalidade Gravar
     */
    public JButton getBtGravar() {
        return btGravar;
    }

    /**
     * Método que retorna o Botão Excluir do painel CRUD
     *
     * @return JButton para a funcionalidade Excluir
     */
    public JButton getBtExcluir() {
        return btExcluir;
    }
}