/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Conteudo;
import br.udesc.ceavi.estude.model.Disciplina;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
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
public class FrameCRUDDisciplina extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Disciplinas";

    private Disciplina disciplina;

    private JLabel lbCodigo;
    private JLabel lbNome;
    private JLabel lbDescricao;
    private JLabel lbCargaHoraria;
    private JLabel lbStatus;

    JTextField tfCodigo;
    JTextField tfNome;
    JTextField tfDescricao;
    JTextField tfStatus;
    JTextField tfCargaHoraria;

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

    public FrameCRUDDisciplina(Disciplina disciplina) {
        super(titulo, dimension);

        this.disciplina = disciplina;

        initializeComponents();
        addComponents();
    }

    public FrameCRUDDisciplina() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    public void setEndereco(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        modelo.addColumn("Des.");
        modelo.addColumn("Car.H.:");
        modelo.addColumn("Sta.");

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

        lbNome = new JLabel("Nome:");
        lbDescricao = new JLabel("Desc.:");
        lbCodigo = new JLabel("Cód.:");
        lbStatus = new JLabel("Sta.:");
        lbCargaHoraria = new JLabel("Car.H.:");

        tfNome = new JTextField();
        tfDescricao = new JTextField();
        tfCodigo = new JTextField();
        tfStatus = new JTextField();
        tfCargaHoraria = new JTextField();

        limparCampos();
    }

    @Override
    public void setEditavel(boolean b) {
        tfDescricao.setEditable(b);
        tfNome.setEditable(b);
        tfCodigo.setEditable(b);
        tfCargaHoraria.setEditable(b);
        tfStatus.setEditable(b);
    }

    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + disciplina.getCodigo());
        tfNome.setText(disciplina.getNome());
        tfDescricao.setText(disciplina.getDescricao());
        tfCargaHoraria.setText(disciplina.getCargaHoraria());
        tfStatus.setText("" + disciplina.getStatus());

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
        panelFormulario.add(lbNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfNome, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDescricao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfDescricao, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbStatus, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfStatus, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCargaHoraria, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfCargaHoraria, cons);

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
        tfNome.setText("");
        tfDescricao.setText("");

        tfStatus.setText("");

        super.repaint();
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
        this.tfNome = this.tfNome;
    }

    public JTextField getTfDescricao() {
        return tfDescricao;
    }

    public void setTfDescricao(JTextField tfDescricao) {
        this.tfDescricao = tfDescricao;
    }

    public JTextField getTfStatus() {
        return tfStatus;
    }

    public void setTfStatus(JTextField tfStatus) {
        this.tfStatus = this.tfStatus;
    }
}
