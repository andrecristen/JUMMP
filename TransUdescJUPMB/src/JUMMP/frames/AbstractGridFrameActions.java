/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.frames;

import JUMMP.utils.Action;
import JUMMP.controllers.BaseController;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import JUMMP.painels.ActionsPanel;
import JUMMP.grids.AbstractGrid;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author André Cristen
 */
public class AbstractGridFrameActions extends JFrame {

    /**
     * Table que sera mostrada no Frame
     */
    private JTable tableObjetos;
    /**
     * Scroll para table
     */
    private JPanel panelActions;
    private JScrollPane scrollTable;

    public AbstractGridFrameActions(String title, AbstractGrid tableAppend, List<Action> actions) {
        //Seta o titulo do frame
        super(title);
        //Seta um tamanho para o Frame
        super.setSize(800,600);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        super.setLayout(layout);
        //Inicia com a table a ser inserida
        initialize(tableAppend, actions);
        //Adiciona os componets
        addComponents();
    }

    private void initialize(AbstractGrid tableModel, List<Action> actions) {
        tableObjetos = new JTable(tableModel);
        scrollTable = new JScrollPane(tableObjetos);
        ActionsPanel actionsPanel = new ActionsPanel(this, tableObjetos, actions, tableModel);
        panelActions = new JPanel();
        panelActions.add(actionsPanel);
    }

    private void addComponents() {
        Container container = this.getContentPane();
        container.add(panelActions);
        container.add(scrollTable);
    }

    public void display() {
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
