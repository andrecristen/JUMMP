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
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
        super.setSize(800, 600);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container content = getContentPane();
        BoxLayout layout = new BoxLayout(content, BoxLayout.Y_AXIS);
        super.setLayout(layout);
        //Inicia com a table a ser inserida
        initialize(tableAppend, actions);
        //Adiciona os componets
        addComponents();
    }
    
    private void initialize(AbstractGrid tableModel, List<Action> actions) {
        Container content = getContentPane();
        tableObjetos = new JTable(tableModel);
        scrollTable = new JScrollPane(tableObjetos);
        ActionsPanel actionsPanel = new ActionsPanel(this, tableObjetos, actions, tableModel);
        panelActions = new JPanel();
        panelActions.add(actionsPanel);
        Box boxes[] = new Box[2];
        boxes[0] = Box.createHorizontalBox();
        boxes[1] = Box.createHorizontalBox();
        boxes[0].createGlue();
        boxes[1].createGlue();
        content.add(boxes[0]);
        content.add(boxes[1]);
        panelActions.setPreferredSize(new Dimension(800, 50));
        panelActions.setLayout(new FlowLayout(FlowLayout.LEFT));
        scrollTable.setPreferredSize(new Dimension(800, 550));
        boxes[0].add(panelActions);
        boxes[1].add(panelActions);
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
