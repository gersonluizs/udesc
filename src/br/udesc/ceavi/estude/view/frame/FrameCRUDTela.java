/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import java.awt.*;
import javax.swing.*;

/**
 * Classe que determina os atributos e comportamento do CRUD da Ação.
 * @author Gerson Luiz
 * @since 05/10/2018
 * @version 1.0
 */
public class FrameCRUDTela extends FrameCRUD{
    private static final Dimension dimension = new Dimension(800, 600);
    private JPanel panelFormulario;
    private JTable tabela;
    private JScrollPane barraRolagem;
             
    private LayoutManager layout;
    private GridBagConstraints cons;
    
    public FrameCRUDTela(String titulo){
        super(titulo, dimension);
        
        initializeComponents();
        addComponents();
    }
    
    private void initializeComponents() {
        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Telas"));
        String [] colunas = {"Cod.", "Descrição"};
        Object [][] dados = {
            {"1","Usuário"},
            {"2","Ação"},
            {"3","Tela"}
        };
        
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        
    }
    private void addComponents() {
        panelFormulario.add(barraRolagem);
        super.addFormulario(panelFormulario);   
    }
}