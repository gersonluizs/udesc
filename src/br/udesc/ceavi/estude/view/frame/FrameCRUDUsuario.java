/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Usuario;
import br.udesc.ceavi.estude.view.principal.FrameSistema;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que determina os atributos e comportamento do CRUD do Usuário.
 * @author Gerson Luiz
 * @since 25/09/2018
 * @version 1.0
 */
public class FrameCRUDUsuario extends FrameCRUD {
    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Usuários";
    
    private Usuario usuario;
  
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
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;   
    
    private JPanel panelContainer;
    private LayoutManager layoutContainer;
    
    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo;
        
    public static void main (String[] args){
        JFrame fPrincipal = new FrameSistema();
        fPrincipal.setVisible(true);
    }
    
    public FrameCRUDUsuario(Usuario usuario){
        super(titulo, dimension);
        
        this.usuario = usuario;
        
        initializeComponents();
        addComponents();
    }
    
    public FrameCRUDUsuario(){
        super(titulo, dimension);
        
        initializeComponents();
        addComponents();
    }
    
    public void setEndereco(Usuario usuario){
        this.usuario = usuario;
        carregarCampos();
    }
    
    private void criarTabela(){
        tabela = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBorder(null);
    }
    
    private void carregarDadosTabela(){
        modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("Cod.");
        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        
        modelo.setNumRows(0);
        
        /* 
        try {
            usuarios = dao.getAllRegistros(Usuario.class);
        } catch (Exception ex) {
            Logger.getLogger(FrameCRUDUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
        
        tabela.setModel(modelo);
    }
        
    private void initializeComponents() {
        layoutContainer = new FlowLayout();
        panelContainer = new JPanel(layoutContainer);
        
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
    }
    
    @Override
    public void setEditavel(boolean b){
        tfNome.setEditable(b);
        tfCodigo.setEditable(b);
        tfEmail.setEditable(b);
        tfSenha.setEditable(b);
        tfRepetirSenha.setEditable(b);
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
        
        /*panelContainer.add(barraRolagem);
        barraRolagem.setSize(150, 150);*/
                
        super.addFormulario(panelContainer);
    }

    @Override
    public void limparCampos() {
        tfCodigo.setText("");
        tfNome.setText("");
        tfEmail.setText("");
        tfSenha.setText("");
        tfRepetirSenha.setText("");

        super.repaint();
    }
    
    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + usuario.getCodigo());
        tfNome.setText(usuario.getNome());
        tfEmail.setText(usuario.getEmail());
    }

    public JTextField getTfCodigo() {
        return tfCodigo;
    }

    public void setTfCodigo(JTextField tfCodigo) {
        this.tfCodigo = tfCodigo;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(JTextField tfEmail) {
        this.tfEmail = tfEmail;
    }

    public JTextField getTfSenha() {
        return tfSenha;
    }

    public void setTfSenha(JTextField tfSenha) {
        this.tfSenha = tfSenha;
    }

    public JTextField getTfRepetirSenha() {
        return tfRepetirSenha;
    }

    public void setTfRepetirSenha(JTextField tfRepetirSenha) {
        this.tfRepetirSenha = tfRepetirSenha;
    }
}