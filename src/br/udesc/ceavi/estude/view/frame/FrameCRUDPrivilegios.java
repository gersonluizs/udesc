/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.model.Privilegio;
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
public class FrameCRUDPrivilegios extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Privilégios";

    private Privilegio privilegio;

    private JLabel lbCodigo;
    private JLabel lbNome;
    private JLabel lbAcao;
    private JLabel lbTela;
    private JLabel lbUsuario;

    JTextField tfCodigo;
    JTextField tfNome;
    JTextField tfAcao;
    JTextField tfTela;
    private JComboBox cbUsuario;

    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;

    private JPanel panelContainer;
    private LayoutManager layoutContainer;

    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo;

    public FrameCRUDPrivilegios() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
        carregaComboBoxUsuario();
    }

    public void setEndereco(Privilegio privilegio) {
        this.privilegio = privilegio;
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
        modelo.addColumn("Acao");
        modelo.addColumn("Tela");
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

        lbCodigo = new JLabel("Cód.:");
        lbNome = new JLabel("Nome:");
        lbAcao = new JLabel("Açao:");
        lbTela = new JLabel("Tela:");
        lbUsuario = new JLabel("Usu.:");

        tfCodigo = new JTextField();
        tfNome = new JTextField();
        tfAcao = new JTextField();
        tfTela = new JTextField();
        cbUsuario = new JComboBox();

        limparCampos();
    }

    @Override
    public void setEditavel(boolean b) {
        tfAcao.setEditable(b);
        tfNome.setEditable(b);
        tfTela.setEditable(b);
        tfCodigo.setEditable(b);

    }

    @Override
    public void carregarCampos() {
        tfCodigo.setText("" + privilegio.getCodigo());
        tfNome.setText("" + privilegio.getNome());
        tfAcao.setText("" + privilegio.getAcao());
        tfTela.setText("" + privilegio.getTela());

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
        panelFormulario.add(lbAcao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfAcao, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTela, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfTela, cons);

        /**
         * ***
         */
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbUsuario, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
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
        tfNome.setText("");
        tfAcao.setText("");
        tfTela.setText("");

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

    public JTextField getTfAcao() {
        return tfAcao;
    }

    public void setTfAcao(JTextField tfAcao) {
        this.tfAcao = tfAcao;
    }

    public JTextField getTfTela() {
        return tfTela;
    }

    public void setTfTela(JTextField tfTela) {
        this.tfTela = tfTela;
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
