/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Tarefa;
import br.udesc.ceavi.estude.model.tipoTarefa;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
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
public class FrameCRUDTarefas extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Tarefas";

    private Tarefa tarefas;

    private JLabel lbCodigo;
    private JLabel lbNome;
    private JLabel lbDescricao;
    private JLabel lbDataHoraInicio;
    private JLabel lbDataHoraFim;
    private JLabel lbnotificacoes;
    private JLabel lbTipoTarefa;
    private JLabel lbStatus;
    private JLabel lbConteudo;

    JTextField tfCodigo;
    JTextField tfNome;
    JTextField tfDescricao;
    JTextField tfDataHoraInicio;
    JTextField tfDataHoraFim;
    JTextField tfNotificacoes;
    private JComboBox cbTipoTarefa;
    JTextField tfStatus;
    JTextField tfConteudo;

    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;

    private JPanel panelContainer;
    private LayoutManager layoutContainer;

    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo;

    private Tarefa tarefa;

    public FrameCRUDTarefas(String titulo, Dimension dimension) throws HeadlessException {
        super(titulo, dimension);
    }

    public FrameCRUDTarefas(Tarefa tarefa) {
        super(titulo, dimension);

        this.tarefa = tarefa;

        initializeComponents();
        addComponents();
    }

    public FrameCRUDTarefas() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    public void setEndereco(Tarefa tarefa) {
        this.tarefa = tarefa;
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
        modelo.addColumn("Desc.");
        modelo.addColumn("H.ini.");
        modelo.addColumn("H.fim");
        modelo.addColumn("T.tar.");
        modelo.addColumn("Sta.");
        modelo.addColumn("cont.");
        modelo.addColumn("Noti.");

        modelo.setNumRows(0);

        /* 
        try {
            usuarios = dao.getAllRegistros(Tarefa.class);
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
        lbDataHoraInicio = new JLabel("H.ini.:");
        lbStatus = new JLabel("Sta.:");
        lbDataHoraFim = new JLabel("H.fim:");
        lbTipoTarefa = new JLabel("T.tare.:");
        lbConteudo = new JLabel("Cont.:");
        lbnotificacoes = new JLabel("Noti.:");

        tfNome = new JTextField();
        tfDescricao = new JTextField();
        tfCodigo = new JTextField();
        tfConteudo = new JTextField();
        tfDataHoraFim = new JTextField();
        tfStatus = new JTextField();
        tfDataHoraInicio = new JTextField();
        tfNotificacoes = new JTextField();
        cbTipoTarefa = new JComboBox(tipoTarefa.values());
        cbTipoTarefa.setSelectedIndex(-1);

        limparCampos();
    }

    @Override
    public void setEditavel(boolean b) {
        tfDescricao.setEditable(b);
        tfNome.setEditable(b);
        tfCodigo.setEditable(b);
        tfConteudo.setEditable(b);
        tfDataHoraFim.setEditable(b);
        tfStatus.setEditable(b);
        tfDataHoraInicio.setEditable(b);
        tfNotificacoes.setEditable(b);
    }

    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + tarefa.getCodigo());
        tfNome.setText(tarefa.getNome());
        tfDescricao.setText(tarefa.getDescricao());
        tfConteudo.setText("" + tarefa.getConteudo());
        tfDataHoraFim.setText("" + tarefa.getDataHoraFim());
        tfStatus.setText("" + tarefa.getStatus());
        tfDataHoraInicio.setText("" + tarefa.getDataHoraInicio());
        tfNotificacoes.setText("" + tarefa.getNotificacoes());

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
        panelFormulario.add(lbDataHoraInicio, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfDataHoraInicio, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbDataHoraFim, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfDataHoraFim, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTipoTarefa, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(cbTipoTarefa, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbStatus, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 6;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfStatus, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 7;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbConteudo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 7;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfConteudo, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 8;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbnotificacoes, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 8;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfNotificacoes, cons);

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
        tfConteudo.setText("");
        tfDataHoraInicio.setText("");
        tfStatus.setText("");
        tfDataHoraFim.setText("");
        tfNotificacoes.setText("");

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

    public JTextField getTfDataHoraInicio() {
        return tfDataHoraInicio;
    }

    public void setTfDataHoraInicio(JTextField tfDataHoraInicio) {
        this.tfDataHoraInicio = tfDataHoraInicio;
    }

    public JTextField getTfDataHoraFim() {
        return tfDataHoraFim;
    }

    public void setTfDataHoraFim(JTextField tfDataHoraFim) {
        this.tfDataHoraFim = tfDataHoraFim;
    }

    public JTextField getTfNotificacoes() {
        return tfNotificacoes;
    }

    public void setTfNotificacoes(JTextField tfNotificacoes) {
        this.tfNotificacoes = tfNotificacoes;
    }

    public JTextField getTfConteudo() {
        return tfConteudo;
    }

    public void setTfConteudo(JTextField tfConteudo) {
        this.tfConteudo = tfConteudo;
    }

    public JTextField getTfStatus() {
        return tfStatus;
    }

    public void setTfStatus(JTextField tfStatus) {
        this.tfStatus = this.tfStatus;
    }
}
