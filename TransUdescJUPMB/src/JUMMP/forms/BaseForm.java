package JUMMP.forms;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import JUMMP.painels.FormPanel;
import JUMMP.utils.Action;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Andre Cristen
 */
public class BaseForm extends JFrame {

    private Object objeto;
    private Action actionPersist;
    private JPanel basePanel;
    private JPanel formPanel;
    private AbstractGrid gridParent;
    private LayoutManager layout;
    private Dimension dimensao;

    public BaseForm(String titulo, Dimension dimensao, Action action) {
        super(titulo);
        this.dimensao = dimensao;
        this.actionPersist = action;
        initComponents();
        addComponents();
    }

    private void initComponents() {
        basePanel = new JPanel();
        this.setSize(dimensao);
        formPanel = new FormPanel(this, this.actionPersist.getController());
        layout = new BorderLayout();
        basePanel.setLayout(layout);
    }

    private void addComponents() {
        this.setContentPane(basePanel);
        basePanel.add(formPanel, BorderLayout.SOUTH);
    }

    public void addFormulario(Container container) {
        basePanel.add(container, BorderLayout.CENTER);
    }

    public void run() {
        this.setVisible(true);
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Action getActionPersist() {
        return actionPersist;
    }

    public void setActionPersist(Action actionPersist) {
        this.actionPersist = actionPersist;
    }

    public AbstractGrid getGridParent() {
        return gridParent;
    }

    public void setGridParent(AbstractGrid gridParent) {
        this.gridParent = gridParent;
    }
}
