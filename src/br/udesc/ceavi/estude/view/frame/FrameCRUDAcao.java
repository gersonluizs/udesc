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
 * Classe que determina os atributos e comportamento do CRUD da Ação.
 * @author Gerson Luiz
 * @since 05/10/2018
 * @version 1.0
 */
public class FrameCRUDAcao extends FrameCRUD{
    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Usuários";
    
    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;   
    
    private JPanel panelContainer;
    private LayoutManager layoutContainer;
    
    private JScrollPane barraRolagem;
    private JTable tabela;
    
    private JLabel lbCodigo;
    private JLabel lbDescricao;

    JTextField tfCodigo;
    JTextField tfDescricao;
        
    public static void main (String[] args){
        JFrame fPrincipal = new FramePrincipal();
        fPrincipal.setVisible(true);
    }
    
    public FrameCRUDAcao(){
        super(titulo, dimension);
        
        initializeComponents();
        addComponents();
    }   
    
    private void initializeComponents() {
        layoutContainer = new FlowLayout();
        panelContainer = new JPanel(layoutContainer);
        
        layoutFormulario = new GridBagLayout();
        panelFormulario = new JPanel(layoutFormulario);
        
        lbDescricao = new JLabel("Descricao:");
        lbCodigo    = new JLabel("Cód.:");
        
        tfDescricao = new JTextField();
        tfCodigo    = new JTextField();
        
        String [] colunas = {"Cod.", "Descrição"};
        Object [][] dados = {
            {"1","Incluir"},
            {"2","Visualizar"},
            {"3","Alterar"},
            {"4","Excluir"}
        };
        
        tabela = new JTable(dados, colunas){
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBorder(null);
        
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
        
        panelContainer.add(panelFormulario);
        panelContainer.add(barraRolagem);
        barraRolagem.setSize(150, 150);
                
        super.addFormulario(panelContainer);
    }
}