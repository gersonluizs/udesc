/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.view.principal.FramePrincipal;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import static org.eclipse.persistence.expressions.ExpressionOperator.right;

/**
 * Classe que determina os atributos e comportamento do CRUD do Usuário.
 * @author Gerson Luiz
 * @since 25/09/2018
 * @version 1.0
 */
public class FrameCRUDUsuario extends FrameCRUD {
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
    private JLabel lbNome;
    private JLabel lbEmail;
    private JLabel lbSenha;
    private JLabel lbRepetirSenha;
    
    JTextField tfCodigo;
    JTextField tfNome;
    JTextField tfEmail;
    JTextField tfSenha;
    JTextField tfRepetirSenha;
        
    public static void main (String[] args){
        JFrame fPrincipal = new FramePrincipal();
        fPrincipal.setVisible(true);
    }
    
    public FrameCRUDUsuario(){
        super(titulo, dimension);
        
        initializeComponents();
        addComponents();
    }   
    
    private void initializeComponents() {
        layoutContainer = new FlowLayout();
        panelContainer = new JPanel();
        
        layoutFormulario = new GridBagLayout();
        panelFormulario = new JPanel(layoutFormulario);
        
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
        
                        
        String [] colunas = {"Cod.", "Nome", "Email"};
        Object [][] dados = {
            {"1","Gerson Luiz", "email@mail.com"},
            {"2","João da Silva", "email@mail.com"},
            {"3","Pedro Cascaes", "email@mail.com"},
            {"4","Gerson Luiz", "email@mail.com"},
            {"5","João da Silva", "email@mail.com"},
            {"6","Pedro Cascaes", "email@mail.com"},
            {"7","Gerson Luiz", "email@mail.com"},
            {"8","João da Silva", "email@mail.com"},
            {"9","Pedro Cascaes", "email@mail.com"},
            {"10","Gerson Luiz", "email@mail.com"},
            {"12","João da Silva", "email@mail.com"},
            {"13","Pedro Cascaes", "email@mail.com"},
            {"14","Gerson Luiz", "email@mail.com"},
            {"15","João da Silva", "email@mail.com"},
            {"16","Pedro Cascaes", "email@mail.com"},
            {"17","Gerson Luiz", "email@mail.com"},
            {"18","João da Silva", "email@mail.com"},
            {"19","Pedro Cascaes", "email@mail.com"},
            {"20","Gerson Luiz", "email@mail.com"},
            {"21","João da Silva", "email@mail.com"}
        };
        
        tabela = new JTable(dados, colunas){
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tabela.setBorder(new LineBorder(Color.black));
        tabela.setGridColor(Color.black);
        tabela.setShowGrid(true);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        barraRolagem = new JScrollPane();
        barraRolagem.getViewport().setBorder(null);
        barraRolagem.getViewport().add(tabela);
        
        
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
        
        panelContainer.add(panelFormulario);
        panelContainer.add(barraRolagem);
                
        super.addFormulario(panelContainer);
    }
}