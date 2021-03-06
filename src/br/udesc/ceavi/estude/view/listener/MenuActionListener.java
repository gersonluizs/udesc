/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.listener;

import br.udesc.ceavi.estude.model.Acao;
import br.udesc.ceavi.estude.model.Agenda;
import br.udesc.ceavi.estude.model.Conteudo;
import br.udesc.ceavi.estude.model.Disciplina;
import br.udesc.ceavi.estude.model.Notificacao;
import br.udesc.ceavi.estude.model.Privilegio;
import br.udesc.ceavi.estude.model.Tarefa;
import br.udesc.ceavi.estude.model.Tela;
import br.udesc.ceavi.estude.model.Usuario;
import br.udesc.ceavi.estude.view.frame.FrameCRUD;
import br.udesc.ceavi.estude.view.frame.FrameCRUDAcao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDAgenda;
import br.udesc.ceavi.estude.view.frame.FrameCRUDConteudo;
import br.udesc.ceavi.estude.view.frame.FrameCRUDDisciplina;
import br.udesc.ceavi.estude.view.frame.FrameCRUDNotificacao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDPrivilegios;
import br.udesc.ceavi.estude.view.frame.FrameCRUDTarefas;
import br.udesc.ceavi.estude.view.frame.FrameCRUDTela;
import br.udesc.ceavi.estude.view.frame.FrameCRUDUsuario;
import br.udesc.ceavi.estude.view.principal.FrameSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que define os atributos e comportamento dos ActionListeners dos Menus
 *
 * @author Gerson Luiz
 * @since 05/10/2018
 */
public class MenuActionListener implements ActionListener {

    //Classe que definira a especialização do FrameCRUD
    private final Class<? extends FrameCRUD> classe;

    //JInternalFrame que deverá ser cosntruída
    private FrameCRUD frame;

    //Parent (tela da aplicação principal) onde as JInternalFrame deverão ser exibidas
    final FrameSistema tela;

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
            if (frame.getClass() == FrameCRUDUsuario.class) {
                ListenersCRUDUsuario listenerUsuario = new ListenersCRUDUsuario(new Usuario(), frame);
            } else if (frame.getClass() == FrameCRUDAcao.class) {
                ListenersCRUDAcao listenerAcao = new ListenersCRUDAcao(new Acao(), frame);
            } else if (frame.getClass() == FrameCRUDConteudo.class) {
                ListenersCRUDConteudo listenerConteudo = new ListenersCRUDConteudo(new Conteudo(), frame);
            } else if (frame.getClass() == FrameCRUDDisciplina.class) {
                ListenersCRUDDisciplina listenerDisciplina = new ListenersCRUDDisciplina(new Disciplina(), frame);
            } else if (frame.getClass() == FrameCRUDTarefas.class) {
                ListenersCRUDTarefas listenerTarefas = new ListenersCRUDTarefas(new Tarefa(), frame);
            } else if (frame.getClass() == FrameCRUDNotificacao.class) {
                ListenersCRUDNotificacao listenerNotificacao = new ListenersCRUDNotificacao(new Notificacao(), frame);
            } else if (frame.getClass() == FrameCRUDPrivilegios.class) {
                ListenersCRUDPrivilegios listenerPrivilegio = new ListenersCRUDPrivilegios(new Privilegio(), frame);
            } else if (frame.getClass() == FrameCRUDTela.class) {
                ListenersCRUDTela listenerTela = new ListenersCRUDTela(new Tela(), frame);
            } else if (frame.getClass() == FrameCRUDAgenda.class) {
                ListenersCRUDAgenda listenerAgenda = new ListenersCRUDAgenda(new Agenda(), frame);
            } else {
            }
            {
            }
            frame.setVisible(true);

        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MenuActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
