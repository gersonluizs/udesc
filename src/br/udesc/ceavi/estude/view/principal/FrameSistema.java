package br.udesc.ceavi.estude.view.principal;

import br.udesc.ceavi.estude.view.menu.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

/**
 * Esta é a tela principal da aplicação
 *
 * @author Gerson, Lucas e Matheus
 * @version 1.0
 *
 */
public class FrameSistema extends JFrame {

    //Dimensão da tela principal
    private static Dimension dimensaoTelaPrincipal;

    //Painel para adicionar as telas internas (JInternalFrame)
    private JDesktopPane desktop;

    //Container da tela principal
    private Container contentPane;

    //Barra de menu da aplicação
    private JMenuBar menuPrincipal;

    /**
     * Construtor da classe Frame Sistema.
     */
    public FrameSistema() {
        super();

        //Define o título da tela principal
        super.setTitle("Estude");

        //Define a dimensão da tela principal
        dimensaoTelaPrincipal = new Dimension(800, 600);
        super.setSize(dimensaoTelaPrincipal);

        //Métodos responsáveis pela construção da GUI da tela principal
        initializeDesktopPane();
        adicionaMenuPrincipal();

        //Define alguns parâmentros para a GUI        
        super.setResizable(false);
        super.setLocationRelativeTo(null);

        //Encerra a thread da aplicação quando a tela principal for fechada
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Método responsável por criar o DesktopPanel da aplicação, onde serão
     * inseridas as telas internas da aplicação
     */
    private void initializeDesktopPane() {
        //Instancia o painel princpal da aplicação, onde as telas internas serão exibidas
        desktop = new JDesktopPane();

        //Pega o painel da JFrame
        contentPane = super.getContentPane();

        //Adiciona o desktopPanel no container da JFrame
        contentPane.add(desktop, BorderLayout.CENTER);

        //Permite que as telas internas sejam arrastadas dentro do container
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    /**
     * Método responsável por adicionar o menu principal da aplicação.
     */
    private void adicionaMenuPrincipal() {
        //Instancia a barra de menus
        menuPrincipal = new MenuPrincipal(this);

        //adiciona a barra de menu na tela principal
        super.setJMenuBar(menuPrincipal);
    }

    /**
     * Método que adiciona um JInternalFrame na tela principal da aplicação
     *
     * @param frame JInternalFrame a ser adicionado na aplicação.
     */
    public void adicionarFrameInterno(JInternalFrame frame) {
        //Insere a instância de um JInternalFrame no DesktopPanel da aplicação
        desktop.add(frame);
    }

}
