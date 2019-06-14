package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.utils.Action;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class FormVolume extends BaseForm {

    private GridBagConstraints cons;
    private Input inputId;
    private Input inputPesoBruto;
    private Input inputPesoLiquido;
    private Input inputCubagem;

    private JPanel panelFormulario;

    public FormVolume(Action action) {
        super("Formulário Volume", new Dimension(500, 300), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {
        GridLayout layout = new GridLayout(4, 1);
        panelFormulario = new JPanel();
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        inputId = new Input("ID", true, false);
        panelFormulario.add(inputId.getComponent());
        inputPesoBruto = new Input("Peso Bruto", true, true);
        panelFormulario.add(inputPesoBruto.getComponent());
        inputPesoLiquido = new Input("Peso Líquido", true, true);
        panelFormulario.add(inputPesoLiquido.getComponent());
        inputCubagem = new Input("Peso Líquido", true, true);
        panelFormulario.add(inputCubagem.getComponent());
        super.addFormulario(panelFormulario);
    }

    public Input getInputId() {
        return inputId;
    }

    public void setInputId(Input inputId) {
        this.inputId = inputId;
    }

    public Input getInputPesoBruto() {
        return inputPesoBruto;
    }

    public void setInputPesoBruto(Input inputPesoBruto) {
        this.inputPesoBruto = inputPesoBruto;
    }

    public Input getInputPesoLiquido() {
        return inputPesoLiquido;
    }

    public void setInputPesoLiquido(Input inputPesoLiquido) {
        this.inputPesoLiquido = inputPesoLiquido;
    }

    public Input getInputCubagem() {
        return inputCubagem;
    }

    public void setInputCubagem(Input inputCubagem) {
        this.inputCubagem = inputCubagem;
    }

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }

    public void setPanelFormulario(JPanel panelFormulario) {
        this.panelFormulario = panelFormulario;
    }

}
