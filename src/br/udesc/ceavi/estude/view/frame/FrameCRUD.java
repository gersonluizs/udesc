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
    private JPanel panelPrincipal;
    private JPanel panelBotoesCRUD;
    private Dimension dimension;
    private LayoutManager layoutFrameCRUD;
    private LayoutManager layoutPanelPrincipal;
    
    public FrameCRUD(String titulo, Dimension dimension) throws HeadlessException {
        this.dimension = dimension;
        initializeComponets();
        addComponets();
        
        super.setSize(dimension);
        super.setTitle(titulo);
    }
    
    private void initializeComponets() {
        panelBotoesCRUD = new CRUDActionPanel(this);
        layoutFrameCRUD = new FlowLayout();
        super.setLayout(layoutFrameCRUD);
        super.setResizable(false);
        super.setClosable(true);
        
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(dimension);
        layoutPanelPrincipal = new BorderLayout();
        panelPrincipal.setLayout(layoutPanelPrincipal);
    }
    
    private void addComponets() {
       panelPrincipal.add(panelBotoesCRUD, BorderLayout.SOUTH); 
       this.setContentPane(panelPrincipal);
    }
    
    public void addFormulario(Container container){
        panelPrincipal.add(container, BorderLayout.NORTH);
    }
}
