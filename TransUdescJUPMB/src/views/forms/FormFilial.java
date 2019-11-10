package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.forms.components.Select;
import JUMMP.utils.Action;
import controllers.EnderecoController;
import java.awt.Dimension;

public class FormFilial extends BaseForm {

    private Input inputID;
    private Input inputNome;
    private Select selectEndereco;


    public FormFilial(Action action) {
        super("Formulário Filial", new Dimension(500, 300), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {

    }

    private void addComponents() {
        EnderecoController controller = new EnderecoController();
        controller.setIdentificadorGetMethod("getId");
        inputID = new Input("ID", true, false);
        panelFormulario.add(inputID.getComponent());
        inputNome = new Input("Nome", true, false);
        panelFormulario.add(inputNome.getComponent());
        selectEndereco = new Select("Endereço", true, true, controller.getModelList());
        panelFormulario.add(selectEndereco.getComponent());
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

    public Select getSelectEndereco() {
        return selectEndereco;
    }

    public void setSelectEndereco(Select selectEndereco) {
        this.selectEndereco = selectEndereco;
    }
    
}
