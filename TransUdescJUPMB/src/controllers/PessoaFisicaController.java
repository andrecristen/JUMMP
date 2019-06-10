/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import java.util.Date;
import models.Pessoa;
import models.PessoaFisica;
import views.forms.FormPessoaFisica;

/**
 *
 * @author André Cristen
 */
public class PessoaFisicaController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return PessoaFisica.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormPessoaFisica(this.getAction());
    }

    public Object beanModel() {
        try {
            PessoaFisica pessoaFisica = new PessoaFisica();
            FormPessoaFisica formConcreto = (FormPessoaFisica) parameters;
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                pessoaFisica.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            pessoaFisica.setCpf(Long.parseLong(formConcreto.getTextFieldCPF().getText()));
            pessoaFisica.setSobrenome(formConcreto.getTextFieldSobrenome().getText());
            pessoaFisica.setDataNascimento(new Date(formConcreto.getTextFieldDataNascimento().getText()));
            PessoaController pessoaController = new PessoaController();
            Pessoa pessoaEcontrada = (Pessoa) pessoaController.findById(Integer.parseInt(formConcreto.getComboBoxPessoa().getSelectedItem().toString()));
            pessoaFisica.setPessoa(pessoaEcontrada);
            return pessoaFisica;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    public void beanForm(BaseForm view, Object model) {
        try {
            FormPessoaFisica formConcreto = (FormPessoaFisica) view;
            PessoaFisica modelConcreto = (PessoaFisica) model;
            formConcreto.getTextFieldCPF().setText(Long.toString(modelConcreto.getCpf()));
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            //Date date = modelConcreto.getDataNascimento();
            //formConcreto.getTextFieldDataNascimento().setText(date.getDay()+"/"+date.getMonth()+"/"+date.getYear());
            formConcreto.getComboBoxPessoa().setSelectedItem(modelConcreto.getPessoa().getId());
            formConcreto.getTextFieldSobrenome().setText(modelConcreto.getSobrenome());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}
