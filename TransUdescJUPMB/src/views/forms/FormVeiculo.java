package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.forms.components.InputDate;
import JUMMP.forms.components.Select;
import JUMMP.utils.Action;
import java.awt.Dimension;
import java.awt.GridLayout;
import models.StatusVeiculo;
import models.TipoVeiculo;

public class FormVeiculo extends BaseForm {

    private Input inputID;
    private Input inputPlaca;
    private InputDate inputDataAquisicao;
    private Select selectTipo;
    private Select selectStatus;

    public FormVeiculo(Action action) {
        super("Formulário Veiculo", new Dimension(500, 300), action);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        GridLayout layout = new GridLayout(5, 1);
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        inputID = new Input("ID", true, false);
        panelFormulario.add(inputID.getComponent());
        inputPlaca = new Input("Placa", true, true);
        panelFormulario.add(inputPlaca.getComponent());
        inputDataAquisicao = new InputDate("Data Aquisição", InputDate.getDATE_BR(), true, true);
        panelFormulario.add(inputDataAquisicao.getComponent());
        selectTipo = new Select("Tipo", true, true, TipoVeiculo.values());
        panelFormulario.add(selectTipo.getComponent());
        selectStatus = new Select("Status", true, true, StatusVeiculo.values());
        panelFormulario.add(selectStatus.getComponent());
        super.addFormulario(panelFormulario);
    }

    public Input getInputID() {
        return inputID;
    }

    public void setInputID(Input inputID) {
        this.inputID = inputID;
    }

    public Input getInputPlaca() {
        return inputPlaca;
    }

    public void setInputPlaca(Input inputPlaca) {
        this.inputPlaca = inputPlaca;
    }

    public InputDate getInputDataAquisicao() {
        return inputDataAquisicao;
    }

    public void setInputDataAquisicao(InputDate inputDataAquisicao) {
        this.inputDataAquisicao = inputDataAquisicao;
    }

    public Select getSelectTipo() {
        return selectTipo;
    }

    public void setSelectTipo(Select selectTipo) {
        this.selectTipo = selectTipo;
    }

    public Select getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(Select selectStatus) {
        this.selectStatus = selectStatus;
    }
    
    
}
