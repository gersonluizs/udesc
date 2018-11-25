/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.listener;

import br.udesc.ceavi.estude.model.Acao;
import br.udesc.ceavi.estude.model.Conteudo;
import br.udesc.ceavi.estude.model.Usuario;
import br.udesc.ceavi.estude.view.frame.FrameCRUD;
import br.udesc.ceavi.estude.view.frame.FrameCRUDAcao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDConteudo;
import br.udesc.ceavi.estude.view.frame.FrameCRUDUsuario;
import br.udesc.ceavi.estude.view.principal.FrameSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que define os atributos e comportamento dos ActionListeners dos Menus
 * @author Gerson Luiz
 * @since 05/10/2018
 */
public class MenuActionListener implements ActionListener{
    //Classe que definira a especialização do FrameCRUD
    private final Class<? extends FrameCRUD> classe;
    
    //JInternalFrame que deverá ser cosntruída
    private FrameCRUD frame;
 
    //Parent (tela da aplicação principal) onde as JInternalFrame deverão ser exibidas
    private final FrameSistema tela;

    public MenuActionListener(FrameSistema tela, Class<? extends FrameCRUD> classe) {
        this.tela = tela;
        this.classe = classe;
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Definindo o model do frame
            frame = classe.newInstance();
            
            // Definindo o internalFrame da tela
            tela.adicionarFrameInterno(frame);
            
            
            //Define o Controller para um cadastro CRUDEndereco
            
            //
            if( frame.getClass() == FrameCRUDUsuario.class ){
                ListenersCRUDUsuario listenerUsuario = new ListenersCRUDUsuario( new Usuario(), frame);
            } else if( frame.getClass() == FrameCRUDAcao.class){
                ListenersCRUDAcao listenerConteudo = new ListenersCRUDAcao( new Acao(), frame);
            } else if( frame.getClass() == FrameCRUDConteudo.class){
                ListenersCRUDConteudo listenerConteudo = new ListenersCRUDConteudo( new Conteudo(), frame);
            }else {
            }{
            }
            frame.setVisible(true);
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MenuActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}