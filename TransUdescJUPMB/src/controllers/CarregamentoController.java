/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Carregamento;
import JUMMP.forms.BaseForm;
import views.forms.FormCarregamento;
import JUMMP.utils.EventMessage;
import models.Endereco;

/**
 *
 * @author Lucas Dolsan
 *
 * tem todas as funcionalidades do baseController
 */
public class CarregamentoController extends BaseController {

    public Class createInstaceModel() {
        return Carregamento.class;
    }

    public BaseForm createInstaceView() {
        return new FormCarregamento(this.getAction());
    }

    // PessoaController pessoaController = new PessoaController();
    //  Pessoa pessoaEcontrada = (Pessoa) pessoaController.findById(Integer.parseInt(formConcreto.getComboBoxPessoa().getSelectedItem().toString()));
    // usuario.setPessoa(pessoaEcontrada);
    @Override
    public Object beanModel() {
        try {
            Carregamento carregamento = new Carregamento();
            FormCarregamento formCarregamento = (FormCarregamento) parameters;
            if (!formCarregamento.getTextFieldID().getText().isEmpty()) {
                carregamento.setId(Integer.parseInt(formCarregamento.getTextFieldID().getText()));
            }
            EnderecoController enderecoController = new EnderecoController();
            Endereco enderecoSaida = (Endereco) enderecoController.findById(Integer.parseInt(formCarregamento.getComboBoxEnderecoSaida().getSelectedItem().toString()));
            carregamento.setEnderecoSaida(enderecoSaida);
            Endereco enderecoChegada = (Endereco) enderecoController.findById(Integer.parseInt(formCarregamento.getComboBoxEnderecoChegada().getSelectedItem().toString()));
            carregamento.setEnderecoChegada(enderecoChegada);
           
            //fazer junção para tabela de entregas
            
            return carregamento;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
       try {
           // FormUsuario formConcreto = (FormUsuario) view;
           // Usuario modelConcreto = (Usuario) model;
           // formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            //formConcreto.getTextFieldLogin().setText(modelConcreto.getLogin());
            //formConcreto.getTextFieldSenha().setText(modelConcreto.getSenha());
            //formConcreto.getComboBoxTipo().setSelectedItem(modelConcreto.getTipo());
           // formConcreto.getComboBoxPessoa().setSelectedItem(modelConcreto.getPessoa().getId());
           // formConcreto.repaint();
           FormCarregamento formCarregamento = (FormCarregamento) view;
           Carregamento modelCarregamento = (Carregamento) model;
           formCarregamento.getTextFieldID().setText(Integer.toString(modelCarregamento.getId()));
           formCarregamento.getComboBoxEnderecoChegada().setSelectedItem(modelCarregamento.getEnderecoChegada().getId());
           formCarregamento.getComboBoxEntrega().setSelectedItem(modelCarregamento.getEnderecoSaida().getId());
           
           //fazer tabela de entregas
           
           formCarregamento.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}
