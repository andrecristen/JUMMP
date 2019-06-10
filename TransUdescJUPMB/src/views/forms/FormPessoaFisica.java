package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.utils.Action;
import controllers.PessoaController;
import controllers.PessoaFisicaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormPessoaFisica extends BaseForm {

    private JLabel labelID;
    private JLabel labelPessoa;
    private JLabel labelSobrenome;
    private JLabel labelCPF;
    private JLabel labelDataNascimento;

    private JTextField textFieldID;
    private JComboBox comboBoxPessoa;
    private JTextField textFieldSobrenome;
    private JTextField textFieldCPF;
    private JTextField textFieldDataNascimento;

    private GridBagConstraints cons;

    private JPanel panelFormulario;
    private Dimension dimensao;
    private LayoutManager layout;

    public FormPessoaFisica(Action action) {
        super("Formulário Pessoa Física", new Dimension(500, 300), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {

        labelID = new JLabel("ID:  ");
        labelPessoa = new JLabel("Pessoa:  ");
        labelSobrenome = new JLabel("Sobrenome:  ");
        labelCPF = new JLabel("CPF:  ");
        labelDataNascimento = new JLabel("Data Nascimento:  ");

        labelID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelPessoa.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelSobrenome.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelCPF.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelDataNascimento.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        labelID.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPessoa.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSobrenome.setHorizontalAlignment(SwingConstants.RIGHT);
        labelCPF.setHorizontalAlignment(SwingConstants.RIGHT);
        labelDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);

        textFieldID = new JTextField();
        PessoaController controller = new PessoaController();
        controller.setIdentificadorGetMethod("getId");
        comboBoxPessoa = new JComboBox(controller.getModelList());

        textFieldSobrenome = new JTextField();
        textFieldCPF = new JTextField();
        textFieldDataNascimento = new JTextField();

        textFieldID.setEditable(false);

        textFieldID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        comboBoxPessoa.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldSobrenome.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldCPF.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldDataNascimento.setFont(new Font("Arial", Font.PLAIN, (int) 18));

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
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
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
        panelFormulario.add(labelSobrenome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldSobrenome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelCPF, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldCPF, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelDataNascimento, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldDataNascimento, cons);

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

    public JTextField getTextFieldSobrenome() {
        return textFieldSobrenome;
    }

    public void setTextFieldSobrenome(JTextField textFieldSobrenome) {
        this.textFieldSobrenome = textFieldSobrenome;
    }

    public JTextField getTextFieldCPF() {
        return textFieldCPF;
    }

    public void setTextFieldCPF(JTextField textFieldCPF) {
        this.textFieldCPF = textFieldCPF;
    }

    public JTextField getTextFieldDataNascimento() {
        return textFieldDataNascimento;
    }

    public void setTextFieldDataNascimento(JTextField textFieldDataNascimento) {
        this.textFieldDataNascimento = textFieldDataNascimento;
    }

}
