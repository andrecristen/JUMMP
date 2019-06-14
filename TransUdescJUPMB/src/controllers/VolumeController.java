/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Volume;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import views.forms.FormVolume;

/**
 * @author Andre Cristen
 */
public class VolumeController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return Volume.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormVolume(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            Volume volume = new Volume();
            FormVolume formConcreto = (FormVolume) parameters;
            if (!formConcreto.getInputId().getValue().isEmpty()) {
                volume.setId(Integer.parseInt(formConcreto.getInputId().getValue()));
            }
            volume.setCubagem(Double.parseDouble(formConcreto.getInputCubagem().getValue()));
            volume.setPesoBruto(Float.parseFloat(formConcreto.getInputPesoBruto().getValue()));
            volume.setPesoLiquido(Float.parseFloat(formConcreto.getInputPesoLiquido().getValue()));
            return volume;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    public void beanForm(BaseForm view, Object model) {
        try {
            FormVolume formConcreto = (FormVolume) view;
            Volume modelConcreto = (Volume) model;
            formConcreto.getInputId().setValue(Integer.toString(modelConcreto.getId()));
            formConcreto.getInputCubagem().setValue(Double.toString(modelConcreto.getCubagem()));
            formConcreto.getInputPesoBruto().setValue(Double.toString(modelConcreto.getPesoBruto()));
            formConcreto.getInputPesoLiquido().setValue(Double.toString(modelConcreto.getPesoLiquido()));
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}
