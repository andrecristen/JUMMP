package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.utils.Action;
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
    private JLabel labelNome;
    private JLabel labelSobrenome;
    private JLabel labelNomeFantasia;
    private JLabel labelCNPJ;
    private JLabel labelPessoaJuridica;
    private JLabel labelPessoaID;
    private JLabel labelIE;
    private JLabel labelSelecione;

    private JTextField textFieldID;
    private JTextField textFieldNome;
    private JComboBox comboBoxPessoaJuridica;
    private JTextField textFieldSobrenome;
    private JTextField textFieldNomeFantasia;
    private JTextField textFieldCNPJ;
    private JTextField textFieldIE;

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
        labelPessoaID = new JLabel("Pessoa ID:  ");
        labelNome = new JLabel("Nome:  ");
        labelSobrenome = new JLabel("Sobrenome:  ");
        labelNomeFantasia = new JLabel("Nome Fantasia:  ");
        labelCNPJ = new JLabel("CNPJ:  ");
        labelIE = new JLabel("IE:  ");
        labelSelecione = new JLabel("Selecione uma pessoa jurídica:");

        labelID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelPessoaJuridica.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelPessoaID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelNome.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelSobrenome.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelNomeFantasia.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelCNPJ.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelIE.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelSelecione.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        labelID.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPessoaJuridica.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPessoaID.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNomeFantasia.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSobrenome.setHorizontalAlignment(SwingConstants.RIGHT);
        labelCNPJ.setHorizontalAlignment(SwingConstants.RIGHT);
        labelIE.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSelecione.setHorizontalAlignment(SwingConstants.LEFT);

        textFieldID = new JTextField();
        comboBoxPessoaJuridica = new JComboBox();
        textFieldNome = new JTextField();
        textFieldSobrenome = new JTextField();
        textFieldNomeFantasia = new JTextField();
        textFieldCNPJ = new JTextField();
        textFieldIE = new JTextField();

        textFieldID.setEditable(false);

        layout = new GridBagLayout();

        panelFormulario = new JPanel();
        panelFormulario.setLayout(layout);
    }

    public JLabel getLabelID() {
        return labelID;
    }

    public void setLabelID(JLabel labelID) {
        this.labelID = labelID;
    }

    public JLabel getLabelNome() {
        return labelNome;
    }

    public void setLabelNome(JLabel labelNome) {
        this.labelNome = labelNome;
    }

    public JLabel getLabelSobrenome() {
        return labelSobrenome;
    }

    public void setLabelSobrenome(JLabel labelSobrenome) {
        this.labelSobrenome = labelSobrenome;
    }

    public JLabel getLabelNomeFantasia() {
        return labelNomeFantasia;
    }

    public void setLabelNomeFantasia(JLabel labelNomeFantasia) {
        this.labelNomeFantasia = labelNomeFantasia;
    }

    public JLabel getLabelCNPJ() {
        return labelCNPJ;
    }

    public void setLabelCNPJ(JLabel labelCNPJ) {
        this.labelCNPJ = labelCNPJ;
    }

    public JLabel getLabelPessoaJuridica() {
        return labelPessoaJuridica;
    }

    public void setLabelPessoaJuridica(JLabel labelPessoaJuridica) {
        this.labelPessoaJuridica = labelPessoaJuridica;
    }

    public JLabel getLabelPessoaID() {
        return labelPessoaID;
    }

    public void setLabelPessoaID(JLabel labelPessoaID) {
        this.labelPessoaID = labelPessoaID;
    }

    public JLabel getLabelIE() {
        return labelIE;
    }

    public void setLabelIE(JLabel labelIE) {
        this.labelIE = labelIE;
    }

    public JLabel getLabelSelecione() {
        return labelSelecione;
    }

    public void setLabelSelecione(JLabel labelSelecione) {
        this.labelSelecione = labelSelecione;
    }

    public JTextField getTextFieldNome() {
        return textFieldNome;
    }

    public void setTextFieldNome(JTextField textFieldNome) {
        this.textFieldNome = textFieldNome;
    }

    public JComboBox getComboBoxPessoaJuridica() {
        return comboBoxPessoaJuridica;
    }

    public void setComboBoxPessoaJuridica(JComboBox comboBoxPessoaJuridica) {
        this.comboBoxPessoaJuridica = comboBoxPessoaJuridica;
    }

    public JTextField getTextFieldSobrenome() {
        return textFieldSobrenome;
    }

    public void setTextFieldSobrenome(JTextField textFieldSobrenome) {
        this.textFieldSobrenome = textFieldSobrenome;
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

    public GridBagConstraints getCons() {
        return cons;
    }

    public void setCons(GridBagConstraints cons) {
        this.cons = cons;
    }

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }

    public void setPanelFormulario(JPanel panelFormulario) {
        this.panelFormulario = panelFormulario;
    }

    public Dimension getDimensao() {
        return dimensao;
    }

    public void setDimensao(Dimension dimensao) {
        this.dimensao = dimensao;
    }

    public LayoutManager getLayout() {
        return layout;
    }

    public void setLayout(LayoutManager layout) {
        this.layout = layout;
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

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelPessoaID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelSobrenome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 6;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldSobrenome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 7;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelNomeFantasia, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 7;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldNomeFantasia, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 8;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelCNPJ, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 8;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldCNPJ, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 9;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelIE, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 9;
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
    
}
