/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import models.Pessoa;
import models.PessoaJuridica;
import views.forms.FormPessoaJuridica;

/**
 *
 * @author André Cristen
 */
public class PessoaJuridicaController extends BaseController {    
    

    @Override
    public Class createInstaceModel() {
        return PessoaJuridica.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormPessoaJuridica(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            FormPessoaJuridica formConcreto = (FormPessoaJuridica) parameters;
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                pessoaJuridica.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            pessoaJuridica.setCnpj(Long.parseLong(formConcreto.getTextFieldCNPJ().getText()));
            pessoaJuridica.setIe(formConcreto.getTextFieldIE().getText());
            pessoaJuridica.setNomeFantasia(formConcreto.getTextFieldNomeFantasia().getText());
            PessoaController pessoaController = new PessoaController();
            Pessoa pessoaEcontrada = (Pessoa) pessoaController.findById(Integer.parseInt(formConcreto.getComboBoxPessoa().getSelectedItem().toString()));
            pessoaJuridica.setPessoa(pessoaEcontrada);
            return pessoaJuridica;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormPessoaJuridica formConcreto = (FormPessoaJuridica) view;
            PessoaJuridica modelConcreto = (PessoaJuridica) model;
            formConcreto.getTextFieldCNPJ().setText(Long.toString(modelConcreto.getCnpj()));
            formConcreto.getTextFieldIE().setText(modelConcreto.getIe());
            formConcreto.getTextFieldNomeFantasia().setText(modelConcreto.getNomeFantasia());
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            formConcreto.getComboBoxPessoa().setSelectedItem(modelConcreto.getPessoa().getId());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}
