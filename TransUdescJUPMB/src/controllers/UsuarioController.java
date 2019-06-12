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
            if (!formConcreto.getInputId().getValue().isEmpty()) {
                usuario.setId(Integer.parseInt(formConcreto.getInputId().getValue()));
            }
            usuario.setLogin(formConcreto.getInputLogin().getValue());
            usuario.setSenha(formConcreto.getInputSenha().getValue());
            usuario.setTipo(TipoUsuario.fromString(formConcreto.getSelectTipoUsuario().getValue()));
            PessoaController pessoaController = new PessoaController();
            Pessoa pessoaEcontrada = (Pessoa) pessoaController.findById(Integer.parseInt(formConcreto.getSelectPessoa().getValue()));
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
            formConcreto.getInputId().setValue(Integer.toString(modelConcreto.getId()));
            formConcreto.getInputLogin().setValue(modelConcreto.getLogin());
            formConcreto.getInputSenha().setValue(modelConcreto.getSenha());
            formConcreto.getSelectTipoUsuario().setValue(modelConcreto.getTipo());
            formConcreto.getSelectPessoa().setValue(modelConcreto.getPessoa().getId());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}
