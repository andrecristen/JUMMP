package JUMMP.painels;

import JUMMP.utils.Action;
import JUMMP.utils.EventMessage;
import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * Esta classe define o painel as actions de um GRID para o sistema
 *
 * @author Andre Cristen
 * @since 05/06/2019
 */
public class ActionsPanel extends JPanel {

    private List<JButton> actionsButton;
    private JTable tableGrid;
    private LayoutManager layout;
    private Dimension dimensaoBotao;
    private Dimension dimensaoPainel;
    private Container parent;

    public ActionsPanel(Container parent,JTable tableGrid, List<Action> actions, AbstractGrid grid) {
        this.parent = parent;
        this.tableGrid = tableGrid;
        this.actionsButton = new ArrayList<>();
        initComponents(actions, grid);
        addComponents();
        super.setVisible(true);
        super.setSize(dimensaoPainel);
    }

    private void initComponents(List<Action> actions, AbstractGrid grid) {
        dimensaoBotao = new Dimension(100, 20);
        dimensaoPainel = new Dimension(parent.getWidth(), 30);
        for (Action action : actions) {
            BaseController controller = action.getController();
            action.setGridCallRefresh(grid);
            JButton buttonAction = new JButton(action.getTitle());
            buttonAction.setSize(dimensaoBotao);
            //Precisa de uma linha selecionada para acontecer a acao mas nao de confirmacao?
            if (action.isNeedsTarget() && !action.isNeedsConfirm()) {
                buttonAction.addActionListener((e) -> {
                    int idSelecionada = this.getIdRowTable();
                    if (idSelecionada > 0) {
                        try {
                            controller.setIdentificador(idSelecionada);
                            controller.setAction(action);
                            Method metodo = controller.getClass().getMethod(action.getActionGrid());
                            metodo.invoke(controller);
                        } catch (Exception ex) {
                            new EventMessage(ex.getMessage(), EventMessage.getTIPO_ERRO());
                        }
                    }
                });
            //Precisa de uma confirmação e de uma linha selecionada;    
            } else if (action.isNeedsConfirm() && action.isNeedsConfirm()) {
                buttonAction.addActionListener((e) -> {
                    int idSelecionada = this.getIdRowTable();
                    if (idSelecionada > 0) {
                        int reply = JOptionPane.showConfirmDialog(this, action.getMessageConfirm(), "Atenção!", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            try {
                                Method metodo;
                                controller.setIdentificador(idSelecionada);
                                controller.setAction(action);
                                metodo = controller.getClass().getMethod(action.getActionGrid());
                                metodo.invoke(controller);
                            } catch (Exception ex) {
                                new EventMessage(ex.getMessage(), EventMessage.getTIPO_ERRO());
                            }
                        }
                    }
                });
            //Nao precisa de uma linha selecionada mas precisa de confirmarcao    
            } else if (!action.isNeedsConfirm() && action.isNeedsConfirm()) {
                buttonAction.addActionListener((e) -> {
                    int reply = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja realmente processar a operação para este registro?", "Atenção!", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        try {
                            Method metodo;
                            controller.setAction(action);
                            metodo = controller.getClass().getMethod(action.getActionGrid());
                            metodo.invoke(controller);
                        } catch (Exception ex) {
                            new EventMessage(ex.getMessage(), EventMessage.getTIPO_ERRO());
                        }
                    }
                });
            //Nao precisa de confirmacao nem de linha     
            } else {
                buttonAction.addActionListener((e) -> {
                    Method metodo;
                    try {
                        controller.setAction(action);
                        metodo = controller.getClass().getMethod(action.getActionGrid());
                        metodo.invoke(controller);
                    } catch (Exception ex) {
                        new EventMessage(ex.getMessage(), EventMessage.getTIPO_ERRO());
                    }
                });
            }
            if(!action.getIcon().isEmpty()){
                buttonAction.setIcon(new ImageIcon(Class.class.getResource("/JUMMP/icons/"+action.getIcon())));
            }
            actionsButton.add(buttonAction);
        }
        layout = new FlowLayout(FlowLayout.CENTER);
    }

    private void addComponents() {
        this.setLayout(layout);
        this.actionsButton.forEach((button) -> {
            this.add(button);
        });
    }

    /**
     * Retorna o id da linha selecionada para ser usado para carregar o modelo
     * em questao.
     * @return int
     */
    public int getIdRowTable() {
        int column = 0;
        int row = this.tableGrid.getSelectedRow();
        if (row >= 0) {
            String value = this.tableGrid.getModel().getValueAt(row, column).toString();
            return Integer.parseInt(value);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        }
        return 0;
    }
}
