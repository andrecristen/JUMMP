package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.utils.Action;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
public class FormEndereco extends BaseForm {
    
    private Input inputId;
    private Input inputNumero;
    private Input inputCEP;
    private Input inputRua;
    private Input inputBairro;
    private Input inputCidade;
    private Input inputEstado;
    private Input inputPais;
    private JPanel panelFormulario;
    private LayoutManager layout;

    public FormEndereco(Action action) {
        super("Formulário Endereço", new Dimension(450, 350), action);
        initComponents();
        addComponents();
    }

    private void initComponents() {
        layout = new GridLayout(8, 1);
        panelFormulario = new JPanel();
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        inputId = new Input("ID", 1, true, false);
        panelFormulario.add(inputId.getComponent());
        inputNumero = new Input("Número", 1, true, true);
        panelFormulario.add(inputNumero.getComponent());
        inputCEP = new Input("CEP", 1, true, true);
        panelFormulario.add(inputCEP.getComponent());
        inputRua = new Input("Rua", 1, true, true);
        panelFormulario.add(inputRua.getComponent());
        inputBairro = new Input("Bairro", 1, true, true);
        panelFormulario.add(inputBairro.getComponent());
        inputCidade = new Input("Cidade", 1, true, true);
        panelFormulario.add(inputCidade.getComponent());
        inputEstado = new Input("Estado", 1, true, true);
        panelFormulario.add(inputEstado.getComponent());
        inputPais = new Input("Pais", 1, true, true);
        panelFormulario.add(inputPais.getComponent());
        super.addFormulario(panelFormulario);
    }

    public Input getInputId() {
        return inputId;
    }

    public void setInputId(Input inputId) {
        this.inputId = inputId;
    }

    public Input getInputNumero() {
        return inputNumero;
    }

    public void setInputNumero(Input inputNumero) {
        this.inputNumero = inputNumero;
    }

    public Input getInputCEP() {
        return inputCEP;
    }

    public void setInputCEP(Input inputCEP) {
        this.inputCEP = inputCEP;
    }

    public Input getInputRua() {
        return inputRua;
    }

    public void setInputRua(Input inputRua) {
        this.inputRua = inputRua;
    }

    public Input getInputBairro() {
        return inputBairro;
    }

    public void setInputBairro(Input inputBairro) {
        this.inputBairro = inputBairro;
    }

    public Input getInputCidade() {
        return inputCidade;
    }

    public void setInputCidade(Input inputCidade) {
        this.inputCidade = inputCidade;
    }

    public Input getInputEstado() {
        return inputEstado;
    }

    public void setInputEstado(Input inputEstado) {
        this.inputEstado = inputEstado;
    }

    public Input getInputPais() {
        return inputPais;
    }

    public void setInputPais(Input inputPais) {
        this.inputPais = inputPais;
    }

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }

    public void setPanelFormulario(JPanel panelFormulario) {
        this.panelFormulario = panelFormulario;
    }
    
    
}
