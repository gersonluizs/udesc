/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Agenda;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public abstract class FrameCRUDAgenda extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Agenda";

    private Agenda agenda;

    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;

    private JPanel panelContainer;
    private LayoutManager layoutContainer;

    public static void main(String[] args) {
        JFrame fPrincipal = new JFrame();
        fPrincipal.setVisible(true);

        FrameCRUDAgenda fTeste;
        Agenda a = new Agenda(0, "Descricao");

        fTeste = new FrameCRUDAgenda(a) {
            @Override
            public void limparCampos() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void carregarCampos() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setEditavel(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        fPrincipal.add(fTeste);

        fTeste.setVisible(true);
    }

    public FrameCRUDAgenda(Agenda agenda) {
        super(titulo, dimension);

        this.agenda = agenda;

        initializeComponents();
        addComponents();
    }

    public FrameCRUDAgenda() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    private void initializeComponents() {
        layoutContainer = new FlowLayout();
        panelContainer = new JPanel(layoutContainer);

        layoutFormulario = new GridBagLayout();
        panelFormulario = new JPanel(layoutFormulario);

        limparCampos();
    }

    private void addComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
