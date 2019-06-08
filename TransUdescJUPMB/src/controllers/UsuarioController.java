/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.connections.JPADAO;
import JUMMP.controllers.BaseController;
import models.Usuario;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import models.Pessoa;
import models.TipoUsuario;
import views.forms.FormUsuario;

/**
 *
 * @author Lucas Levi Gonçalves
 */
public class UsuarioController extends BaseController {

    public Usuario validarLogin(String login, String senha) {
        JPADAO dao = new JPADAO();
        Usuario user = dao.validarLogin(login, senha);
        return user;
    }

    @Override
    public Class createInstaceModel() {
        return Usuario.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormUsuario(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            Usuario usuario = new Usuario();
            FormUsuario formConcreto = (FormUsuario) parameters;
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                usuario.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            usuario.setLogin(formConcreto.getTextFieldLogin().getText());
            usuario.setSenha(formConcreto.getTextFieldSenha().getText());
            usuario.setTipo(TipoUsuario.fromString(formConcreto.getComboBoxTipo().getSelectedItem().toString()));
            PessoaController pessoaController = new PessoaController();
            Pessoa pessoaEcontrada = (Pessoa) pessoaController.findById(Integer.parseInt(formConcreto.getComboBoxPessoa().getSelectedItem().toString()));
            usuario.setPessoa(pessoaEcontrada);
            return usuario;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormUsuario formConcreto = (FormUsuario) view;
            Usuario modelConcreto = (Usuario) model;
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            formConcreto.getTextFieldLogin().setText(modelConcreto.getLogin());
            formConcreto.getTextFieldSenha().setText(modelConcreto.getSenha());
            formConcreto.getComboBoxTipo().setSelectedItem(modelConcreto.getTipo());
            formConcreto.getComboBoxPessoa().setSelectedItem(modelConcreto.getPessoa().getId());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}
