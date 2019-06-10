/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.utils;

import JUMMP.controllers.BaseController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class ActionUtils {

    public List<Action> createCRUDActions(BaseController controller) {
        ArrayList<Action> crudAction = new ArrayList<Action>();
        crudAction.add(createAddAction(controller));
        crudAction.add(createEditAction(controller));
        crudAction.add(createViewAction(controller));
        crudAction.add(createDeleteAction(controller));
        return crudAction;
    }

    public Action createAddAction(BaseController controller) {
        Action add = new Action("Adicionar", "add", "addPersist", false, false, "addIcon.png");
        add.setController(controller);
        return add;
    }

    public Action createEditAction(BaseController controller) {
        Action edit = new Action("Editar", "edit", "editPersist", true, false, "editIcon.png");
        edit.setController(controller);
        return edit;
    }

    public Action createViewAction(BaseController controller) {
        Action view = new Action("Visualizar", "view", "", true, false, "findIcon.png");
        view.setController(controller);
        return view;
    }

    public Action createDeleteAction(BaseController controller) {
        Action delete = new Action("Excluir", "delete", "", true, true, "removeIcon.png");
        delete.setController(controller);
        return delete;
    }
}
