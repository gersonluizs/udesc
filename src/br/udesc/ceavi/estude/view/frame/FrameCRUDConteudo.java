/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Acao;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class FrameCRUDConteudo extends FrameCRUD{
    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Conteudos";
    
    private Acao acao;
    
    private JLabel lbCodigo;
    private JLabel lbDescricao;

    JTextField tfCodigo;
    JTextField tfDescricao;    
    
    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;   
    
    private JPanel panelContainer;
    private LayoutManager layoutContainer;
    
    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo;
        
    public static void main (String[] args){
        JFrame fPrincipal = new JFrame();
        fPrincipal.setVisible(true);
        
        FrameCRUDAcao fTeste;
        Acao a = new Acao(0, "Descricao");
        
        fTeste = new FrameCRUDAcao(a);
        fPrincipal.add(fTeste);
        
        fTeste.setVisible(true);
    }
    
    public FrameCRUDConteudo(Acao acao){
        super(titulo, dimension);
        
        this.acao = acao;
        
        initializeComponents();
        addComponents();
    }
    
     public FrameCRUDConteudo(){
        super(titulo, dimension);
        
        initializeComponents();
        addComponents();
    }
    
    public void setEndereco(Acao acao){
        this.acao = acao;
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
        
        lbDescricao   = new JLabel("Nome:");
        lbCodigo = new JLabel("Cód.:");
        
        tfDescricao = new JTextField();
        tfCodigo    = new JTextField();
        
        limparCampos();
    }
    
    @Override
    public void setEditavel(boolean b){
        tfDescricao.setEditable(b);
        tfCodigo.setEditable(b);
    }
    
    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + acao.getCodigo());
        tfDescricao.setText(acao.getDescricao());
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
        
        /*panelContainer.add(barraRolagem);
        barraRolagem.setSize(150, 150);*/
                
        super.addFormulario(panelContainer);
    }

    @Override
    public void limparCampos() {
        tfCodigo.setText("");
        tfDescricao.setText("");

        super.repaint();
    }   

    public JTextField getTfCodigo() {
        return tfCodigo;
    }

    public void setTfCodigo(JTextField tfCodigo) {
        this.tfCodigo = tfCodigo;
    }

    public JTextField getTfDescricao() {
        return tfDescricao;
    }

    public void setTfDescricao(JTextField tfDescricao) {
        this.tfDescricao = tfDescricao;
    }
}
    

