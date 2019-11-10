package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.forms.components.InputDate;
import JUMMP.forms.components.Select;
import JUMMP.utils.Action;
import controllers.PessoaController;
import controllers.PessoaJuridicaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormPessoaJuridica extends BaseForm {

    private Input inputID;
    private Select selectPessoa;
    private Input inputNomeFantasia;
    private Input inputCNPJ;
    private Input inputIE;
    private LayoutManager layout;

    public FormPessoaJuridica(Action action) {
        super("Formulário Pessoa Jurídica", new Dimension(500, 300), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {
        layout = new GridLayout(5, 1);
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        PessoaController controller = new PessoaController();
        controller.setIdentificadorGetMethod("getId");
        inputID = new Input("ID", true, false);
        panelFormulario.add(inputID.getComponent());
        selectPessoa = new Select("Pessoa", true, true, controller.getModelList());
        panelFormulario.add(selectPessoa.getComponent());
        inputNomeFantasia = new Input("Fantasia", true, true);
        panelFormulario.add(inputNomeFantasia.getComponent());
        inputCNPJ = new Input("CNPJ", true, true);
        panelFormulario.add(inputCNPJ.getComponent());
        inputIE = new Input("IE", true, true);
        panelFormulario.add(inputIE.getComponent());
        super.addFormulario(panelFormulario);
    }

    public Input getInputID() {
        return inputID;
    }

    public void setInputID(Input inputID) {
        this.inputID = inputID;
    }

    public Select getSelectPessoa() {
        return selectPessoa;
    }

    public void setSelectPessoa(Select selectPessoa) {
        this.selectPessoa = selectPessoa;
    }

    public Input getInputNomeFantasia() {
        return inputNomeFantasia;
    }

    public void setInputNomeFantasia(Input inputNomeFantasia) {
        this.inputNomeFantasia = inputNomeFantasia;
    }

    public Input getInputCNPJ() {
        return inputCNPJ;
    }

    public void setInputCNPJ(Input inputCNPJ) {
        this.inputCNPJ = inputCNPJ;
    }

    public Input getInputIE() {
        return inputIE;
    }

    public void setInputIE(Input inputIE) {
        this.inputIE = inputIE;
    }

}
