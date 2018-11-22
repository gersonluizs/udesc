/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.menu;

import br.udesc.ceavi.estude.view.frame.FrameCRUDAcao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDConteudos;
import br.udesc.ceavi.estude.view.frame.FrameCRUDDisciplinas;
import br.udesc.ceavi.estude.view.frame.FrameCRUDTarefas;
import br.udesc.ceavi.estude.view.frame.FrameCRUDUsuario;
import br.udesc.ceavi.estude.view.listener.MenuActionListener;
import br.udesc.ceavi.estude.view.principal.FramePrincipal;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Classe que define o comportamento e atributos do menu do sistema
 *
 * @author Gerson Luiz
 * @since 05/10/2018
 */
public class MenuPrincipal extends JMenuBar {

    private JMenu menuCadastro;
    private JMenuItem menuItemCRUDAcao;
    private JMenuItem menuItemCRUDAgenda;
    private JMenuItem menuItemCRUDConteudo;
    private JMenuItem menuItemCRUDDisciplina;
    private JMenuItem menuItemCRUDNotificao;
    private JMenuItem menuItemCRUDPrivilegio;
    private JMenuItem menuItemCRUDTarefa;
    private JMenuItem menuItemCRUDTela;
    private JMenuItem menuItemCRUDUsuario;

    private JMenu menuAjuda;
    private JMenuItem menuItemSobre;

    private final FramePrincipal frame;

    public MenuPrincipal(FramePrincipal frame) {
        super();
        this.frame = frame;

        initializeComponents();
        construirMenu();

        addListenersMenu();
    }

    private void initializeComponents() {
        menuCadastro = new JMenu("Cadastros");
        menuItemCRUDAcao = new JMenuItem("Ações");
        menuItemCRUDConteudo = new JMenuItem("Conteúdos");
        menuItemCRUDAgenda = new JMenuItem("Agenda");
        menuItemCRUDDisciplina = new JMenuItem("Disciplinas");
        menuItemCRUDNotificao = new JMenuItem("Notificações");
        menuItemCRUDPrivilegio = new JMenuItem("Privilégios");
        menuItemCRUDTarefa = new JMenuItem("Tarefas");
        menuItemCRUDTela = new JMenuItem("Telas");
        menuItemCRUDUsuario = new JMenuItem("Usuários");

        menuAjuda = new JMenu("Ajuda");
        menuItemSobre = new JMenuItem("Sobre");
    }

    private void construirMenu() {
        menuCadastro.add(menuItemCRUDAcao);
        menuCadastro.add(menuItemCRUDConteudo);
        menuCadastro.add(menuItemCRUDAgenda);
        menuCadastro.add(menuItemCRUDDisciplina);
        menuCadastro.add(menuItemCRUDNotificao);
        menuCadastro.add(menuItemCRUDPrivilegio);
        menuCadastro.add(menuItemCRUDTarefa);
        menuCadastro.add(menuItemCRUDTela);
        menuCadastro.add(menuItemCRUDUsuario);

        menuAjuda.add(menuItemSobre);

        super.add(menuCadastro);
        super.add(menuAjuda);
    }

    private void addListenersMenu() {
        menuItemCRUDUsuario.addActionListener(new MenuActionListener(frame, FrameCRUDUsuario.class));
        menuItemCRUDConteudo.addActionListener(new MenuActionListener(frame, FrameCRUDConteudos.class));
        menuItemCRUDDisciplina.addActionListener(new MenuActionListener(frame, FrameCRUDDisciplinas.class));
        menuItemCRUDTarefa.addActionListener(new MenuActionListener(frame, FrameCRUDTarefas.class));
        menuItemCRUDAcao.addActionListener(new MenuActionListener(frame, FrameCRUDAcao.class));
    }

}
