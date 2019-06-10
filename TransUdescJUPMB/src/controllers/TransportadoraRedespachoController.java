/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.TransportadoraRedespacho;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import models.PessoaJuridica;
import views.forms.FormTransRedespacho;

/**
 *
 * @author Lucas Dolsan
 */
public class TransportadoraRedespachoController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return TransportadoraRedespacho.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormTransRedespacho(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            TransportadoraRedespacho transRedespacho = new TransportadoraRedespacho();
            FormTransRedespacho formConcreto = (FormTransRedespacho) parameters;
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                transRedespacho.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            PessoaJuridicaController pjc = new PessoaJuridicaController();
            PessoaJuridica pessoaEcontrada = (PessoaJuridica) pjc.findById(Integer.parseInt(formConcreto.getComboBoxPessoaJuridica().getSelectedItem().toString()));
            transRedespacho.setPessoaJuridica(pessoaEcontrada);

            return transRedespacho;

        } catch (Exception e) {
            new EventMessage(e.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormTransRedespacho formConcreto = (FormTransRedespacho) view;
            TransportadoraRedespacho modelConcreto = (TransportadoraRedespacho) model;

            //considerar remover os textFields pois são redundantes
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            formConcreto.getTextFieldCNPJ().setText(Long.toString(modelConcreto.getPessoaJuridica().getCnpj()));
            formConcreto.getTextFieldIE().setText(modelConcreto.getPessoaJuridica().getIe());
            formConcreto.getTextFieldNomeFantasia().setText(modelConcreto.getPessoaJuridica().getNomeFantasia());

            formConcreto.getComboBoxPessoaJuridica().setSelectedItem(modelConcreto.getPessoaJuridica());
            
        } catch (Exception e) {
            new EventMessage(e.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}

