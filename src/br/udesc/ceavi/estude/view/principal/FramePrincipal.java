/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.principal;

import br.udesc.ceavi.estude.view.menu.MenuPrincipal;
import java.awt.*;
import javax.swing.*;

/**
 * Esta classe define os atributos e comportamentos de uma tela CRUD
 * @author Gerson Luiz
 * @since 23/09/2018
 * @version 1.0
 */
public class FramePrincipal extends JFrame {
    private static Dimension dimensaoTelaPrincipal;
    private JDesktopPane desktop;
    private Container contentPanel;

    private JMenuBar menuPrincipal;
    
    public FramePrincipal() {
        super();
        super.setTitle("Estude");
        
        dimensaoTelaPrincipal = new Dimension(800, 600);
        
        initalizeDesktopPane();
        adicionarMenu();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initalizeDesktopPane() {
        desktop = new JDesktopPane();
        contentPanel = super.getContentPane();
        contentPanel.add(desktop, BorderLayout.CENTER);
        
        super.setSize(dimensaoTelaPrincipal);
    }
    
    private void adicionarMenu() {
        menuPrincipal = new MenuPrincipal(this);
        super.setJMenuBar(menuPrincipal);
    }
    
    public void adicionarFrameInterno(JInternalFrame frame){
        desktop.add(frame);
    }
}
