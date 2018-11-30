/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Notificacao;
import br.udesc.ceavi.estude.model.Usuario;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class FrameCRUDNotificacao extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Notificações";

    private Notificacao notificacao;

    private JLabel lbCodigo;
    private JLabel lbAssunto;
    private JLabel lbDescricao;
    private JLabel lbDataHora;
    private JLabel lbVisualizado;
    private JLabel lbUsuario;

    JTextField tfCodigo;
    JTextField tfAssunto;
    JTextField tfDescricao;
    JTextField tfDataHora;
    JTextField tfVisualizado;
    private JComboBox cbUsuario;

    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;

    private JPanel panelContainer;
    private LayoutManager layoutContainer;

    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo;

    public FrameCRUDNotificacao() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
        carregaComboBoxUsuario();
    }

    public void setEndereco(Notificacao notificacao) {
        this.notificacao = notificacao;
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
        modelo.addColumn("Assu.");
        modelo.addColumn("Desc.");
        modelo.addColumn("Da.H.");
        modelo.addColumn("Visu.");
        modelo.addColumn("Usu.");

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

        lbAssunto = new JLabel("Assun.:");
        lbDescricao = new JLabel("Desc.:");
        lbCodigo = new JLabel("Cód.:");
        lbDataHora = new JLabel("D.Hora.:");
        lbVisualizado = new JLabel("Visu.:");
        lbUsuario = new JLabel("Usu.:");

        tfAssunto = new JTextField();
        tfDescricao = new JTextField();
        tfCodigo = new JTextField();
        tfDataHora = new JTextField();
        tfVisualizado = new JTextField();
        cbUsuario = new JComboBox();

        limparCampos();
    }

    @Override
    public void setEditavel(boolean b) {
        tfDescricao.setEditable(b);
        tfAssunto.setEditable(b);
        tfCodigo.setEditable(b);
        tfDataHora.setEditable(b);
        tfVisualizado.setEditable(b);
    }

    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + notificacao.getCodigo());
        tfAssunto.setText(notificacao.getAssunto());
        tfDescricao.setText(notificacao.getDescricao());
        tfDataHora.setText("" + notificacao.getDataHora());
        tfVisualizado.setText("" + notificacao.isVisualizado());

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
        panelFormulario.add(lbAssunto, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfAssunto, cons);

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
        panelFormulario.add(lbDataHora, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfDataHora, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbVisualizado, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfVisualizado, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbUsuario, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(cbUsuario, cons);

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
        tfAssunto.setText("");
        tfDescricao.setText("");
        tfDataHora.setText("");
        tfVisualizado.setText("");

        super.repaint();
    }

    public JTextField getTfCodigo() {
        return tfCodigo;
    }

    public void setTfCodigo(JTextField tfCodigo) {
        this.tfCodigo = tfCodigo;
    }

    public JTextField getTfAssunto() {
        return tfAssunto;
    }

    public void setTfAssunto(JTextField tfAssunto) {
        this.tfAssunto = tfAssunto;
    }

    public JTextField getTfDescricao() {
        return tfDescricao;
    }

    public void setTfDescricao(JTextField tfDescricao) {
        this.tfDescricao = tfDescricao;
    }

    public JTextField getTfDataHora() {
        return tfDataHora;
    }

    public void setTfDataHora(JTextField tfDataHora) {
        this.tfDataHora = tfDataHora;
    }

    public JTextField getTfVisualizado() {
        return tfVisualizado;
    }

    public void setTfVisualizado(JTextField tfVisualizado) {
        this.tfVisualizado = tfVisualizado;
    }

    private void carregaComboBoxUsuario() {

        try {
            Connection db = DriverManager.getConnection("");
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(rs.getInt("usucodigo"));
                usuario.setNome(rs.getString("usunome"));
                usuario.setEmail(rs.getString("usuemail"));
                usuario.setSenha(rs.getString("ususenha"));

                cbUsuario.addItem(usuario);
            }
            rs.close();
            db.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu erro ao carregar a Combo Box", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
