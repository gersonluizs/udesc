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
public class FrameCRUDUsuarioManutencao extends FrameCRUDManutencao{
    private static final Dimension dimension = new Dimension(400, 250);
    
    private JLabel lbCodigo;
    private JLabel lbNome;
    private JLabel lbEmail;
    private JLabel lbSenha;
    private JLabel lbRepetirSenha;
    
    JTextField tfCodigo;
    JTextField tfNome;
    JTextField tfEmail;
    JTextField tfSenha;
    JTextField tfRepetirSenha;
    
    private JPanel panelFormulario;
    private LayoutManager layout;
    private GridBagConstraints cons;
    
    public FrameCRUDUsuarioManutencao(String titulo){
        super(titulo, dimension);
        
        initializeComponents();
        addComponents();
    }
    
    private void initializeComponents() {
        lbNome   = new JLabel("Nome:");
        lbCodigo = new JLabel("Cód.:");
        lbEmail  = new JLabel("E-mail:");
        lbSenha  = new JLabel("Senha:");
        lbRepetirSenha  = new JLabel("Repetir:");
        
        tfNome   = new JTextField();
        tfCodigo = new JTextField();
        tfEmail  = new JTextField();
        tfSenha  = new JTextField();
        tfRepetirSenha  = new JTextField();
        
        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Usuário"));
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
        panelFormulario.add(lbNome,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfNome,cons);
        
        /******/
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbEmail,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfEmail,cons);
        
        /******/
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbSenha,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        panelFormulario.add(tfSenha,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbRepetirSenha,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        panelFormulario.add(tfRepetirSenha,cons);
                
        /******/       
        super.addFormulario(panelFormulario);   
    }
}