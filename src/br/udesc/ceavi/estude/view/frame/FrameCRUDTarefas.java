package br.udesc.ceavi.estude.view.frame;

import br.udesc.ceavi.estude.view.principal.FramePrincipal;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Dell
 */
public class FrameCRUDTarefas extends FrameCRUD {

    private static final Dimension dimension = new Dimension(500, 500);
    private static final String titulo = "Tarefas";

    private JPanel panelFormulario;
    private LayoutManager layoutFormulario;
    private GridBagConstraints cons;

    private JPanel panelContainer;
    private LayoutManager layoutContainer;

    private JScrollPane barraRolagem;
    private JTable tabela;

    public static void main(String[] args) {
        JFrame fPrincipal = new FramePrincipal();
        fPrincipal.setVisible(true);
    }

    public FrameCRUDTarefas() {
        super(titulo, dimension);

        initializeComponents();
        addComponents();
    }

    private void initializeComponents() {
        layoutContainer = new FlowLayout();
        panelContainer = new JPanel(layoutContainer);

        layoutFormulario = new GridBagLayout();
        panelFormulario = new JPanel(layoutFormulario);

        String[] colunas = {"Atrasadas", "Realizadas", "p/ fazer"};
        Object[][] dados = {
            {"1", "", ""},
            {"2", "", ""},
            {"3", "", ""},
            {"4", "", ""},};

        tabela = new JTable(dados, colunas) {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        barraRolagem = new JScrollPane();
        barraRolagem.getViewport().setBorder(null);
        barraRolagem.getViewport().add(tabela);

    }

    private void addComponents() {

        panelContainer.add(panelFormulario);
        panelContainer.add(barraRolagem);

        super.addFormulario(panelContainer);
    }
}
