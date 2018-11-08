/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import java.awt.*;
import javax.swing.*;
import br.udesc.ceavi.estude.view.panel.CRUDActionPanelManutencao;

/**
 * Esta classe define os atributos e comportamentos de uma tela CRUD
 * @author Gerson Luiz
 * @since 23/09/2018
 * @version 1.0
 */
public abstract class FrameCRUDManutencao extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelBotoesCRUD;
    private Dimension dimension;
    private LayoutManager layout;
    
    public FrameCRUDManutencao(String titulo, Dimension dimension) throws HeadlessException {
        this.dimension = dimension;
        initializeComponets();
        addComponets();
        
        super.setSize(dimension);
        super.setTitle(titulo);
        super.setLayout(layout);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
    }
    private void initializeComponets() {
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(dimension);
        
        panelBotoesCRUD = new CRUDActionPanelManutencao(this);
        
        layout = new BorderLayout();
        panelPrincipal.setLayout(layout);
        
    }
    private void addComponets() {
       this.setContentPane(panelPrincipal);
       panelPrincipal.add(panelBotoesCRUD, BorderLayout.SOUTH); 
    }
    
    public void addFormulario(Container container){
        panelPrincipal.add(container, BorderLayout.CENTER);
    }
}
