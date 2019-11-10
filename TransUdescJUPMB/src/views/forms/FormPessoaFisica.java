package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.forms.components.InputDate;
import JUMMP.forms.components.Select;
import JUMMP.utils.Action;
import controllers.PessoaController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

public class FormPessoaFisica extends BaseForm {

    private LayoutManager layout;

    private Input inputId;
    private Input inputSobrenome;
    private Input inputCPF;
    private InputDate inputDataNascimento;
    private Select selectPessoa;

    public FormPessoaFisica(Action action) {
        super("Formulário Pessoa Física", new Dimension(500, 300), action);

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
        inputId = new Input("ID", true, false);
        panelFormulario.add(inputId.getComponent());
        selectPessoa = new Select("Pessoa", true, true, controller.getModelList());
        panelFormulario.add(selectPessoa.getComponent());
        inputSobrenome = new Input("Sobrenome", true, true);
        panelFormulario.add(inputSobrenome.getComponent());
        inputCPF = new Input("CPF", true, true);
        panelFormulario.add(inputCPF.getComponent());
        inputDataNascimento = new InputDate("Data Nascimento",  InputDate.getDATE_BR(),true, true);
        panelFormulario.add(inputDataNascimento.getComponent());
        super.addFormulario(panelFormulario);
    }

    public Input getInputId() {
        return inputId;
    }

    public void setInputId(Input inputId) {
        this.inputId = inputId;
    }

    public Input getInputSobrenome() {
        return inputSobrenome;
    }

    public void setInputSobrenome(Input inputSobrenome) {
        this.inputSobrenome = inputSobrenome;
    }

    public Input getInputCPF() {
        return inputCPF;
    }

    public void setInputCPF(Input inputCPF) {
        this.inputCPF = inputCPF;
    }

    public InputDate getInputDataNascimento() {
        return inputDataNascimento;
    }

    public void setInputDataNascimento(InputDate inputDataNascimento) {
        this.inputDataNascimento = inputDataNascimento;
    }

    public Select getSelectPessoa() {
        return selectPessoa;
    }

    public void setSelectPessoa(Select selectPessoa) {
        this.selectPessoa = selectPessoa;
    }

}
