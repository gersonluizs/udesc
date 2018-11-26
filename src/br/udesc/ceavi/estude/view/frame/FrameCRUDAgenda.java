/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Agenda;
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
public class FrameCRUDAgenda extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Agenda";

    private Agenda agenda;

    private JLabel lbCodigo;
    private JLabel lbNome;
    private JLabel lbDescricao;
    private JLabel lbHorarioDedicado;
    private JLabel lbTempoDisponivel;
    private JLabel lbTempoOcupado;

    JTextField tfCodigo;
    JTextField tfNome;
    JTextField tfDescricao;
    JTextField tfHorarioDedicado;
    JTextField tfTempoDisponivel;
    JTextField tfTempoOcupado;

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

        FrameCRUDAgenda fTeste;
        Agenda a = new Agenda(0, "Descricao");

        fTeste = new FrameCRUDAgenda(a);
        fPrincipal.add(fTeste);

        fTeste.setVisible(true);
    }

    public FrameCRUDAgenda(String titulo, Dimension dimension) throws HeadlessException {
        super(titulo, dimension);
    }

    public FrameCRUDAgenda(Agenda agenda) {
        super(titulo, dimension);

        this.agenda = agenda;

        initializeComponents();
        addComponents();
    }

    public FrameCRUDAgenda() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    public void setEndereco(Agenda agenda) {
        this.agenda = agenda;
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
        modelo.addColumn("H.Dedi.");
        modelo.addColumn("T.disp.");
        modelo.addColumn("T.Ocupado");

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
        lbHorarioDedicado = new JLabel("H.Dedi.:");
        lbTempoDisponivel = new JLabel("T.Disp.:");
        lbTempoOcupado = new JLabel("T.Ocup.:");

        tfNome = new JTextField();
        tfDescricao = new JTextField();
        tfCodigo = new JTextField();
        tfHorarioDedicado = new JTextField();
        tfTempoOcupado = new JTextField();
        tfTempoDisponivel = new JTextField();

        limparCampos();
    }

    @Override
    public void setEditavel(boolean b) {
        tfDescricao.setEditable(b);
        tfNome.setEditable(b);
        tfCodigo.setEditable(b);
        tfHorarioDedicado.setEditable(b);
        tfTempoDisponivel.setEditable(b);
        tfTempoOcupado.setEditable(b);
    }

    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + agenda.getCodigo());
        tfNome.setText(agenda.getNome());
        tfDescricao.setText(agenda.getDescricao());
        tfHorarioDedicado.setText("" + agenda.getHorarioDedicado());
        tfTempoDisponivel.setText("" + agenda.getTempoDisponivel());
        tfTempoOcupado.setText("" + agenda.getTempoOcupado());

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
        panelFormulario.add(lbHorarioDedicado, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfHorarioDedicado, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTempoDisponivel, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfTempoDisponivel, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTempoOcupado, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfTempoOcupado, cons);

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
        tfHorarioDedicado.setText("");
        tfTempoDisponivel.setText("");
        tfTempoOcupado.setText("");

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
        this.tfNome = tfNome;
    }

    public JTextField getTfDescricao() {
        return tfDescricao;
    }

    public void setTfDescricao(JTextField tfDescricao) {
        this.tfDescricao = tfDescricao;
    }

    public JTextField getTfHorarioDedicado() {
        return tfHorarioDedicado;
    }

    public void setTfHorarioDedicado(JTextField tfHorarioDedicado) {
        this.tfHorarioDedicado = tfHorarioDedicado;
    }

    public JTextField getTfTempoDisponivel() {
        return tfTempoDisponivel;
    }

    public void setTfTempoDisponivel(JTextField tfTempoDisponivel) {
        this.tfTempoDisponivel = tfTempoDisponivel;
    }

    public JTextField getTfTempoOcupado() {
        return tfTempoOcupado;
    }

    public void setTfTempoOcupado(JTextField tfTempoOcupado) {
        this.tfTempoOcupado = tfTempoOcupado;
    }

}
