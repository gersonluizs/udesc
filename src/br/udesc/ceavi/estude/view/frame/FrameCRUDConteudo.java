/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Conteudo;
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
public class FrameCRUDConteudo extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Conteudos";

    private Conteudo conteudos;

    private JLabel lbCodigo;
    private JLabel lbDescricao;
    private JLabel lbDisciplina;
    private JLabel lbStatus;
    private JLabel lbPrioridade;

    JTextField tfCodigo;
    JTextField tfDescricao;
    JTextField tfDisciplina;
    JTextField tfStatus;
    JTextField tfPrioridade;

    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;

    private JPanel panelContainer;
    private LayoutManager layoutContainer;

    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo;

    public static void main(String[] args) {
        JFrame fPrincipal = new JFrame();
        fPrincipal.setVisible(true);

        FrameCRUDConteudo fTeste;
        Conteudo a = new Conteudo(0, "Descricao");

        fTeste = new FrameCRUDConteudo(a);
        fPrincipal.add(fTeste);

        fTeste.setVisible(true);
    }
    private Conteudo conteudo;

    public FrameCRUDConteudo(Conteudo conteudo) {
        super(titulo, dimension);

        this.conteudo = conteudo;

        initializeComponents();
        addComponents();
    }

    public FrameCRUDConteudo() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    public void setEndereco(Conteudo conteudos) {
        this.conteudo = conteudo;
        carregarCampos();
    }

    private void criarTabela() {
        tabela = new JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBorder(null);
    }

    private void carregarDadosTabela() {
        modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("Cod.");
        modelo.addColumn("Nome");
        modelo.addColumn("Prio.");
        modelo.addColumn("Sta.");
        modelo.addColumn("Disc");

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

        lbDescricao = new JLabel("Nome:");
        lbCodigo = new JLabel("Cód.:");
        lbDisciplina = new JLabel("Disc.:");
        lbStatus = new JLabel("Sta.:");
        lbPrioridade = new JLabel("Prio.:");

        tfDescricao = new JTextField();
        tfCodigo = new JTextField();
        tfDisciplina = new JTextField();
        tfPrioridade = new JTextField();
        tfStatus = new JTextField();

        limparCampos();
    }

    @Override
    public void setEditavel(boolean b) {
        tfDescricao.setEditable(b);
        tfCodigo.setEditable(b);
        tfDisciplina.setEditable(b);
        tfPrioridade.setEditable(b);
        tfStatus.setEditable(b);
    }

    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + conteudo.getCodigo());
        tfDescricao.setText(conteudo.getDescricao());
        tfDisciplina.setText(conteudo.getDescricao());
        tfPrioridade.setText(conteudo.getDescricao());
        tfStatus.setText(conteudo.getDescricao());

    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCodigo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfCodigo, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDescricao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfDescricao, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDisciplina, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfDisciplina, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbPrioridade, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfPrioridade, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbStatus, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfStatus, cons);

        /**
         * ***
         */
        panelContainer.add(panelFormulario);

        /*panelContainer.add(barraRolagem);
        barraRolagem.setSize(150, 150);*/
        super.addFormulario(panelContainer);
    }

    @Override
    public void limparCampos() {
        tfCodigo.setText("");
        tfDescricao.setText("");
        tfDisciplina.setText("");
        tfPrioridade.setText("");
        tfStatus.setText("");

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
    
     public JTextField getTfDisciplina() {
        return tfDisciplina;
    }

    public void setTfDisciplina(JTextField tfDisciplina) {
        this.tfDisciplina = this.tfDisciplina;
    }
    
     public JTextField getTfPrioridade() {
        return tfPrioridade;
    }

    public void setTfPrioridade(JTextField tfPrioridade) {
        this.tfPrioridade = this.tfPrioridade;
    }
    
     public JTextField getTfStatus() {
        return tfStatus;
    }

    public void setTfStatus(JTextField tfStatus) {
        this.tfStatus = this.tfStatus;
    }
}
