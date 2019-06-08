package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.utils.Action;
import controllers.VeiculoController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import models.StatusVeiculo;
import models.TipoVeiculo;

public class FormVeiculo extends BaseForm {

    private JLabel labelID;
    private JLabel labelPlaca;
    private JLabel labelDataAquisicao;
    private JLabel labelTipo;
    private JLabel labelStatus;
    private JTextField textFieldID;
    private JTextField textFieldPlaca;
    private JTextField textFieldDataAquisicao;
    private JComboBox comboBoxTipo;
    private JComboBox comboBoxStatus;
    private JPanel panelFormulario;

    private GridBagConstraints cons;

    private Dimension dimensao;
    private LayoutManager layout;

    public FormVeiculo(Action action) {
        super("Formulário Veiculo", new Dimension(450, 300), new VeiculoController(), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {
        labelID = new JLabel("ID:  ");
        labelPlaca = new JLabel("Placa:  ");
        labelDataAquisicao = new JLabel("Data Aquisição:  ");
        labelTipo = new JLabel("Tipo:  ");
        labelStatus = new JLabel("Status:  ");

        labelID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelPlaca.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelDataAquisicao.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelTipo.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelStatus.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        labelID.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPlaca.setHorizontalAlignment(SwingConstants.RIGHT);
        labelDataAquisicao.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTipo.setHorizontalAlignment(SwingConstants.RIGHT);
        labelStatus.setHorizontalAlignment(SwingConstants.RIGHT);

        textFieldID = new JTextField();
        textFieldPlaca = new JTextField();
        textFieldDataAquisicao = new JTextField();

        comboBoxTipo = new JComboBox(TipoVeiculo.values());
        comboBoxTipo.setSelectedIndex(-1);

        comboBoxStatus = new JComboBox(StatusVeiculo.values());
        comboBoxStatus.setSelectedIndex(-1);

        textFieldID.setEditable(false);

        textFieldID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldPlaca.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldDataAquisicao.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        comboBoxTipo.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        comboBoxStatus.setFont(new Font("Arial", Font.PLAIN, (int) 18));

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
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelPlaca, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldPlaca, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelDataAquisicao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldDataAquisicao, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelTipo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(comboBoxTipo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelStatus, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(comboBoxStatus, cons);

        super.addFormulario(panelFormulario);
    }

    public JLabel getLabelID() {
        return labelID;
    }

    public void setLabelID(JLabel labelID) {
        this.labelID = labelID;
    }

    public JLabel getLabelPlaca() {
        return labelPlaca;
    }

    public void setLabelPlaca(JLabel labelPlaca) {
        this.labelPlaca = labelPlaca;
    }

    public JLabel getLabelDataAquisicao() {
        return labelDataAquisicao;
    }

    public void setLabelDataAquisicao(JLabel labelDataAquisicao) {
        this.labelDataAquisicao = labelDataAquisicao;
    }

    public JLabel getLabelTipo() {
        return labelTipo;
    }

    public void setLabelTipo(JLabel labelTipo) {
        this.labelTipo = labelTipo;
    }

    public JLabel getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(JLabel labelStatus) {
        this.labelStatus = labelStatus;
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public void setTextFieldID(JTextField textFieldID) {
        this.textFieldID = textFieldID;
    }

    public JTextField getTextFieldPlaca() {
        return textFieldPlaca;
    }

    public void setTextFieldPlaca(JTextField textFieldPlaca) {
        this.textFieldPlaca = textFieldPlaca;
    }

    public JTextField getTextFieldDataAquisicao() {
        return textFieldDataAquisicao;
    }

    public void setTextFieldDataAquisicao(JTextField textFieldDataAquisicao) {
        this.textFieldDataAquisicao = textFieldDataAquisicao;
    }

    public JComboBox getComboBoxTipo() {
        return comboBoxTipo;
    }

    public void setComboBoxTipo(JComboBox comboBoxTipo) {
        this.comboBoxTipo = comboBoxTipo;
    }

    public JComboBox getComboBoxStatus() {
        return comboBoxStatus;
    }

    public void setComboBoxStatus(JComboBox comboBoxStatus) {
        this.comboBoxStatus = comboBoxStatus;
    }

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }

    public void setPanelFormulario(JPanel panelFormulario) {
        this.panelFormulario = panelFormulario;
    }

    public GridBagConstraints getCons() {
        return cons;
    }

    public void setCons(GridBagConstraints cons) {
        this.cons = cons;
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
    
    
}
