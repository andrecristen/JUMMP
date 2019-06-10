/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.utils;

import JUMMP.controllers.BaseController;
import java.util.ArrayList;
import models.TipoUsuario;

/**
 *
 * @author Andre Cristen
 */
public class ActionUtils {

    public ArrayList<Action> createCRUDActions(BaseController controller, ArrayList<TipoUsuario> permissions) {
        ArrayList<Action> crudAction = new ArrayList<Action>();
        crudAction.add(createAddAction(controller, permissions));
        crudAction.add(createEditAction(controller, permissions));
        crudAction.add(createViewAction(controller, permissions));
        crudAction.add(createDeleteAction(controller, permissions));
        return crudAction;
    }

    public Action createAddAction(BaseController controller, ArrayList<TipoUsuario> permissions) {
        Action add = new Action("Adicionar", "add", "addPersist", false, false, "addIcon.png", permissions);
        add.setController(controller);
        return add;
    }

    public Action createEditAction(BaseController controller, ArrayList<TipoUsuario> permissions) {
        Action edit = new Action("Editar", "edit", "editPersist", true, false, "editIcon.png", permissions);
        edit.setController(controller);
        return edit;
    }

    public Action createViewAction(BaseController controller, ArrayList<TipoUsuario> permissions) {
        Action view = new Action("Visualizar", "view", "", true, false, "findIcon.png", permissions);
        view.setController(controller);
        return view;
    }

    public Action createDeleteAction(BaseController controller, ArrayList<TipoUsuario> permissions) {
        Action delete = new Action("Excluir", "delete", "", true, true, "removeIcon.png", permissions);
        delete.setController(controller);
        return delete;
    }
    
    public ArrayList<TipoUsuario> permiteAllTypes(){
        ArrayList<TipoUsuario> permisions = new ArrayList<>();
        for (TipoUsuario tipo : TipoUsuario.values()) {
            permisions.add(tipo);
        }
        return permisions;
    }
    
    public ArrayList<TipoUsuario> permiteAllTypesExcept(ArrayList<TipoUsuario> exceto){
        ArrayList<TipoUsuario> permisions = new ArrayList<>();
        for (TipoUsuario tipo : TipoUsuario.values()) {
            if(!exceto.contains(tipo)){
                permisions.add(tipo);
            }
        }
        return permisions;
    }
}
