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
    private JButton btIncluir;
    private JButton btAlterar;
    private JButton btExcluir;
    private JButton btGravar;
    private JButton btCancelar;
    private LayoutManager layout;
    private Dimension dimensaoBotao;
    private Dimension dimensaoPainel;
    
    private Container parent;
    
    public CRUDActionPanel(Container parent) {
        this.parent = parent;
        
        initComponents();
        addComponents();
        addActionListner();
        super.setVisible(true);
        super.setSize(dimensaoPainel);
    }
    private void initComponents() {
        dimensaoBotao = new Dimension(100,20);
        dimensaoPainel = new Dimension(parent.getWidth(), 30);
        
        layout = new FlowLayout(FlowLayout.CENTER);
        
        btIncluir = new JButton("Incluir");
        btIncluir.setSize(dimensaoBotao);
        btAlterar = new JButton("Alterar");
        btAlterar.setSize(dimensaoBotao);
        btExcluir = new JButton("Excluir");
        btExcluir.setSize(dimensaoBotao);
        btGravar = new JButton("Gravar");
        btGravar.setSize(dimensaoBotao);
        btCancelar = new JButton("Cancelar");
        btCancelar.setSize(dimensaoBotao);
    }
    private void addComponents() {
        this.setLayout(layout);
        this.add(btIncluir);
        this.add(btAlterar);
        this.add(btExcluir);
        this.add(btGravar);
        this.add(btCancelar);
    }
    private void addActionListner() {
        
    }   
}