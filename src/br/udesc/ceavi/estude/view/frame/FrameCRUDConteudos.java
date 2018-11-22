/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.view.principal.FramePrincipal;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Dell
 */
public class FrameCRUDConteudos extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Conteudos";

    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;

    private JPanel panelContainer;
    private LayoutManager layoutContainer;

    private JScrollPane barraRolagem;

    public static void main(String[] args) {
        JFrame fPrincipal = new FramePrincipal();
        fPrincipal.setVisible(true);
    }

    public FrameCRUDConteudos() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    private void initializeComponents() {
        layoutContainer = new FlowLayout();
        panelContainer = new JPanel(layoutContainer);

        layoutFormulario = new GridBagLayout();
        panelFormulario = new JPanel(layoutFormulario);

        barraRolagem = new JScrollPane();
        barraRolagem.getViewport().setBorder(null);

    }

    private void addComponents() {

        panelContainer.add(panelFormulario);
        panelContainer.add(barraRolagem);

        super.addFormulario(panelContainer);
    }
}
