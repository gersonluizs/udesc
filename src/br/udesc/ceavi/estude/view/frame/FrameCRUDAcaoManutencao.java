/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import java.awt.*;
import javax.swing.*;

/**
 * Classe que determina os atributos e comportamento do CRUD do Usuário.
 * @author Gerson Luiz
 * @since 25/09/2018
 * @version 1.0
 */
public class FrameCRUDAcaoManutencao extends FrameCRUDManutencao{
    private static final Dimension dimension = new Dimension(400, 250);
    
    private JLabel lbCodigo;
    private JLabel lbDescricao;
    
    JTextField tfCodigo;
    JTextField tfDescricao;
    
    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;
    
    public FrameCRUDAcaoManutencao(String titulo){
        super(titulo, dimension);
        
        initializeComponents();
        addComponents();
    }
    
    private void initializeComponents() {
        lbDescricao = new JLabel("Descricao:");
        lbCodigo    = new JLabel("Cód.:");
        
        tfDescricao = new JTextField();
        tfCodigo    = new JTextField();
        
        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Dados da Ação"));
    }
    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCodigo,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfCodigo,cons);

        /******/
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDescricao,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfDescricao,cons);
        
        /******/       
        super.addFormulario(panelFormulario);   
    }
}