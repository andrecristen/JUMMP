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
            if (!formConcreto.getInputId().getValue().isEmpty()) {
                pessoaFisica.setId(Integer.parseInt(formConcreto.getInputId().getValue()));
            }
            pessoaFisica.setCpf(Long.parseLong(formConcreto.getInputCPF().getValue()));
            pessoaFisica.setSobrenome(formConcreto.getInputSobrenome().getValue());
            pessoaFisica.setDataNascimento(formConcreto.getInputDataNascimento().getValue());
            PessoaController pessoaController = new PessoaController();
            Pessoa pessoaEcontrada = (Pessoa) pessoaController.findById(Integer.parseInt(formConcreto.getSelectPessoa().getValue()));
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
            formConcreto.getInputCPF().setValue(Long.toString(modelConcreto.getCpf()));
            formConcreto.getInputId().setValue(Integer.toString(modelConcreto.getId()));
            Date date = modelConcreto.getDataNascimento();
            formConcreto.getInputDataNascimento().setValue(date);
            formConcreto.getSelectPessoa().setValue(modelConcreto.getPessoa().getId());
            formConcreto.getInputSobrenome().setValue(modelConcreto.getSobrenome());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}
