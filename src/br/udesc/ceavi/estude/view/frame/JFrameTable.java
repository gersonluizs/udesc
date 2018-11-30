/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
class JFrameTable extends JFrame {

    private JPanel panelPrincipal;
    private Dimension tamanho;
    private LayoutManager layout;
    
    public JFrameTable(String titulo, Dimension tamanho) {
        this.tamanho = tamanho;

        InitCom();
        addCom();

        super.setSize(tamanho);
        super.setTitle(titulo);
        super.setLayout(layout);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    private void InitCom() {
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(tamanho);

        layout = new BorderLayout();

        panelPrincipal.setLayout(layout);

    }

    private void addCom() {

        this.setContentPane(panelPrincipal);

    }

    public void addFormulario(Container parent) {
        panelPrincipal.add(parent, BorderLayout.CENTER);
    }

}
