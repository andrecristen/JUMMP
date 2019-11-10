package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.utils.Action;
import java.awt.Dimension;
import java.awt.GridLayout;

public class FormPessoa extends BaseForm {

    private Input inputID;
    private Input inputNome;

    public FormPessoa(Action action) {
        super("Formulário Pessoa Física", new Dimension(500, 300), action);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        GridLayout layout = new GridLayout(4, 1);
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        inputID = new Input("ID", true, false);
        panelFormulario.add(inputID.getComponent());
        inputNome = new Input("Nome", true, true);
        panelFormulario.add(inputNome.getComponent());
        super.addFormulario(panelFormulario);
    }

    public Input getInputID() {
        return inputID;
    }

    public void setInputID(Input inputID) {
        this.inputID = inputID;
    }

    public Input getInputNome() {
        return inputNome;
    }

    public void setInputNome(Input inputNome) {
        this.inputNome = inputNome;
    }
}
