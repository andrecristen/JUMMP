package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.utils.Action;
import controllers.PessoaJuridicaController;
import controllers.TransportadoraRedespachoController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormTransRedespacho extends BaseForm {

    private JLabel labelID;
    private JLabel labelPessoaJuridica;
    private JLabel labelSelecione;

    private JTextField textFieldID;
    private JComboBox comboBoxPessoaJuridica;

    private GridBagConstraints cons;

    private JPanel panelFormulario;
    private Dimension dimensao;
    private LayoutManager layout;

    public FormTransRedespacho(Action action) {
        super("Formulário Transportadora Redespacho", new Dimension(400, 400), new TransportadoraRedespachoController(), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {

        labelID = new JLabel("ID:  ");
        labelPessoaJuridica = new JLabel("Pessoa:  ");
        labelSelecione = new JLabel("Selecione uma pessoa jurídica:");

        labelID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelPessoaJuridica.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelSelecione.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        labelID.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPessoaJuridica.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSelecione.setHorizontalAlignment(SwingConstants.LEFT);

        textFieldID = new JTextField();
        PessoaJuridicaController controller = new PessoaJuridicaController();
        controller.setIdentificadorGetMethod("getId");
        comboBoxPessoaJuridica = new JComboBox(controller.getModelList());

        textFieldID.setEditable(false);

        layout = new GridBagLayout();

        panelFormulario = new JPanel();
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelSelecione, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelPessoaJuridica, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(comboBoxPessoaJuridica, cons);

        super.addFormulario(panelFormulario);
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public void setTextFieldID(JTextField textFieldID) {
        this.textFieldID = textFieldID;
    }

    public JComboBox getComboBoxPessoaJuridica() {
        return comboBoxPessoaJuridica;
    }

    public void setComboBoxPessoaJuridica(JComboBox comboBoxPessoaJuridica) {
        this.comboBoxPessoaJuridica = comboBoxPessoaJuridica;
    }

}
