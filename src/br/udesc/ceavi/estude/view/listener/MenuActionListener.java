/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.listener;

import br.udesc.ceavi.estude.view.frame.FrameCRUD;
import br.udesc.ceavi.estude.view.principal.FramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 * Classe que define os atributos e comportamento dos ActionListeners dos Menus
 * @author Gerson Luiz
 * @since 05/10/2018
 */
public class MenuActionListener implements ActionListener{
    private final Class<? extends JInternalFrame> classe;
    private final FramePrincipal tela;
    private JInternalFrame frame;

    public MenuActionListener(FramePrincipal tela, Class<? extends FrameCRUD> classe) {
        this.tela = tela;
        this.classe = classe;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            frame = classe.newInstance();
            
            tela.adicionarFrameInterno(frame);
            
            frame.setVisible(true);
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MenuActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}