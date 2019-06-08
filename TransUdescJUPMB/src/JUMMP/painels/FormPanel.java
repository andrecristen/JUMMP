package JUMMP.painels;

import JUMMP.controllers.BaseController;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormPanel extends JPanel {

    private JButton buttonPersist;
    private JButton buttonCancelar;
    private LayoutManager layout;
    private Dimension dimensaoBotao;
    private Dimension dimensaoPanel;
    private BaseForm parent;

    public FormPanel(BaseForm parent, BaseController controller) {
        super();
        this.parent = parent;
        boolean addButtonPersist = initComponents(controller);
        addComponents(addButtonPersist);

    }

    private boolean initComponents(BaseController controller) {
        dimensaoBotao = new Dimension(100, 20);
        dimensaoPanel = new Dimension(parent.getWidth(), 30);
        this.setSize(dimensaoPanel);
        boolean addButtonPersist;
        if (this.parent.getActionPersist().getActionForm().length() <= 0) {
            addButtonPersist = false;
        } else {
            addButtonPersist = true;
            buttonPersist = new JButton(this.parent.getActionPersist().getTitle());
            buttonPersist.setSize(dimensaoBotao);
            buttonPersist.addActionListener((e) -> {
                try {
                    controller.setParameters(this.parent);
                    Method metodo;
                    metodo = controller.getClass().getMethod(this.parent.getActionPersist().getActionForm());
                    metodo.invoke(controller);
                } catch (Exception ex) {
                    new EventMessage(ex.getMessage(), EventMessage.getTIPO_ERRO());
                }
            });
        }

        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setSize(dimensaoBotao);
        buttonCancelar.addActionListener((e) -> {
            this.parent.setVisible(false);
        });
        layout = new FlowLayout(FlowLayout.RIGHT);
        return addButtonPersist;
    }

    private void addComponents(boolean addButtonPerists) {
        this.setLayout(layout);
        this.add(buttonCancelar);
        if (addButtonPerists) {
            this.add(buttonPersist);
        }

    }
}
