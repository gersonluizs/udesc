/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.frame;

import java.awt.Dimension;
import java.awt.MenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class ItemTable extends JFrameTable {

    private JTable tabela;
    private JPanel panel;
    private JScrollPane pane;
    private DefaultTableModel dtm;
    private MenuItem barra;

    public ItemTable(String titulo, Dimension tamanho) {
        super(titulo, tamanho);

        initCom();

        addTable();
        addListener();

    }

    private void initCom() {

    }

    private void addTable() {

    }

    private void addListener() {

    }

}
