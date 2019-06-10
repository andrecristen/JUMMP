package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.utils.Action;
import controllers.PessoaController;
import controllers.PessoaJuridicaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormPessoaJuridica extends BaseForm {

    private JLabel labelID;
    private JLabel labelPessoa;
    private JLabel labelNomeFantasia;
    private JLabel labelCNPJ;
    private JLabel labelIE;

    private JTextField textFieldID;
    private JComboBox comboBoxPessoa;
    private JTextField textFieldNomeFantasia;
    private JTextField textFieldCNPJ;
    private JTextField textFieldIE;

    private GridBagConstraints cons;

    private JPanel panelFormulario;
    private Dimension dimensao;
    private LayoutManager layout;

    public FormPessoaJuridica(Action action) {
        super("Formulário Pessoa Jurídica", new Dimension(400, 300), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {
        labelID = new JLabel("ID:  ");
        labelPessoa = new JLabel("Pessoa:  ");
        labelNomeFantasia = new JLabel("Nome Fantasia:  ");
        labelCNPJ = new JLabel("CNPJ:  ");
        labelIE = new JLabel("IE:  ");

        labelID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelPessoa.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelNomeFantasia.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelCNPJ.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelIE.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        labelID.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPessoa.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNomeFantasia.setHorizontalAlignment(SwingConstants.RIGHT);
        labelCNPJ.setHorizontalAlignment(SwingConstants.RIGHT);
        labelIE.setHorizontalAlignment(SwingConstants.RIGHT);

        textFieldID = new JTextField();
        PessoaController controller = new PessoaController();
        controller.setIdentificadorGetMethod("getId");
        comboBoxPessoa = new JComboBox(controller.getModelList());
        textFieldNomeFantasia = new JTextField();
        textFieldCNPJ = new JTextField();
        textFieldIE = new JTextField();

        textFieldID.setEditable(false);

        textFieldID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldNomeFantasia.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldCNPJ.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldIE.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        layout = new GridBagLayout();

        panelFormulario = new JPanel();
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldID, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelPessoa, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(comboBoxPessoa, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelNomeFantasia, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldNomeFantasia, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelCNPJ, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldCNPJ, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelIE, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldIE, cons);

        super.addFormulario(panelFormulario);
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public void setTextFieldID(JTextField textFieldID) {
        this.textFieldID = textFieldID;
    }

    public JComboBox getComboBoxPessoa() {
        return comboBoxPessoa;
    }

    public void setComboBoxPessoa(JComboBox comboBoxPessoa) {
        this.comboBoxPessoa = comboBoxPessoa;
    }

    public JTextField getTextFieldNomeFantasia() {
        return textFieldNomeFantasia;
    }

    public void setTextFieldNomeFantasia(JTextField textFieldNomeFantasia) {
        this.textFieldNomeFantasia = textFieldNomeFantasia;
    }

    public JTextField getTextFieldCNPJ() {
        return textFieldCNPJ;
    }

    public void setTextFieldCNPJ(JTextField textFieldCNPJ) {
        this.textFieldCNPJ = textFieldCNPJ;
    }

    public JTextField getTextFieldIE() {
        return textFieldIE;
    }

    public void setTextFieldIE(JTextField textFieldIE) {
        this.textFieldIE = textFieldIE;
    }

}
