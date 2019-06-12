package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.forms.components.Input;
import JUMMP.forms.components.Select;
import JUMMP.utils.Action;
import controllers.PessoaController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import models.TipoUsuario;

public class FormUsuario extends BaseForm {

    private JPanel panelFormulario;
    private LayoutManager layout;
    private Input inputId;
    private Input inputLogin;
    private Input inputSenha;
    private Select selectPessoa;
    private Select selectTipoUsuario;

    public FormUsuario(Action action) {
        super("Formulário Usuário", new Dimension(450, 300), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {
        layout = new GridLayout(8, 1);
        panelFormulario = new JPanel();
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        PessoaController controller = new PessoaController();
        controller.setIdentificadorGetMethod("getId");
        inputId = new Input("ID", true, false);
        panelFormulario.add(inputId.getComponent());
        selectPessoa = new Select("Pessoa", true, true, controller.getModelList());
        panelFormulario.add(selectPessoa.getComponent());
        selectTipoUsuario = new Select("Tipo", true, true, TipoUsuario.values());
        panelFormulario.add(selectTipoUsuario.getComponent());
        inputLogin = new Input("Login", true, true);
        panelFormulario.add(inputLogin.getComponent());
        inputSenha = new Input("Senha", true, true);
        panelFormulario.add(inputSenha.getComponent());
        super.addFormulario(panelFormulario);
    }

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }

    public void setPanelFormulario(JPanel panelFormulario) {
        this.panelFormulario = panelFormulario;
    }

    public Input getInputId() {
        return inputId;
    }

    public void setInputId(Input inputId) {
        this.inputId = inputId;
    }

    public Input getInputLogin() {
        return inputLogin;
    }

    public void setInputLogin(Input inputLogin) {
        this.inputLogin = inputLogin;
    }

    public Input getInputSenha() {
        return inputSenha;
    }

    public void setInputSenha(Input inputSenha) {
        this.inputSenha = inputSenha;
    }

    public Select getSelectPessoa() {
        return selectPessoa;
    }

    public void setSelectPessoa(Select selectPessoa) {
        this.selectPessoa = selectPessoa;
    }

    public Select getSelectTipoUsuario() {
        return selectTipoUsuario;
    }

    public void setSelectTipoUsuario(Select selectTipoUsuario) {
        this.selectTipoUsuario = selectTipoUsuario;
    }

}
