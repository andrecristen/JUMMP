/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.utils;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import java.util.ArrayList;
import models.TipoUsuario;

/**
 * Classe responsavel por representar todas as acoes do sistemas como aberturas
 * de form, grid, confirmacoes de form entre outros.
 *
 * Action Grid = Acao a ser chamada quando clicarmos em um botao localizado em
 * um grid Exemplo: add 
 * Action Form = Acao a ser chamada quando clicarmos em um
 * botao localizado em um form Exemplo: addPersist 
 * Needs Target = Necessita de uma linha selecionada no grid para funcionar? 
 * Needs Confirm = Ncessita uma  mensagem de confirmacao antes de realemte executar a acao? 
 * Message Confirm = Caso necessite da anterior, qual a mensagem? 
 * Title = Titulo da acao 
 * Path Icon = Path do icone a ser usado nos botoes caso tiver 
 * Params = Caso precisar de algum parametro adicional. 
 * Grid Call Refresh = Grid que pode ser recarregado após a execução da action. 
 * Permissions = Tipos de usuários que tem acesso a essa ação.
 *
 * @author Andre Cristen
 */
public class Action {

    protected String actionGrid;

    protected String actionForm;

    protected boolean needsTarget;

    protected boolean needsConfirm;

    protected String messageConfirm;

    protected String title;

    protected String icon;

    protected Object params;

    protected BaseController controller;

    protected AbstractGrid gridCallRefresh;

    protected ArrayList<TipoUsuario> permissions;

    /**
     * Com icone
     *
     * @param title
     * @param actionGrid
     * @param actionForm
     * @param needsTarget
     * @param needsConfirm
     * @param icon
     */
    public Action(String title, String actionGrid, String actionForm, boolean needsTarget, boolean needsConfirm, String icon, ArrayList<TipoUsuario> permissions) {
        this.title = title;
        this.actionGrid = actionGrid;
        this.actionForm = actionForm;
        this.needsTarget = needsTarget;
        this.needsConfirm = needsConfirm;
        this.icon = icon;
        this.permissions = permissions;
        this.messageConfirm = "Tem certeza que deseja realmente processar a operação para este registro?";
    }

    /**
     * Sem icone
     *
     * @param actionGrid
     * @param actionForm
     * @param needsTarget
     * @param needsConfirm
     * @param title
     */
    public Action(String title, String actionGrid, String actionForm, boolean needsTarget, boolean needsConfirm, ArrayList<TipoUsuario> permissions) {
        this.actionGrid = actionGrid;
        this.actionForm = actionForm;
        this.needsTarget = needsTarget;
        this.needsConfirm = needsConfirm;
        this.title = title;
        this.permissions = permissions;
        this.messageConfirm = "Tem certeza que deseja realmente processar a operação para este registro?";
    }

    public String getActionGrid() {
        return actionGrid;
    }

    public void setActionGrid(String actionGrid) {
        this.actionGrid = actionGrid;
    }

    public boolean isNeedsTarget() {
        return needsTarget;
    }

    public void setNeedsTarget(boolean needsTarget) {
        this.needsTarget = needsTarget;
    }

    public String getActionForm() {
        return actionForm;
    }

    public void setActionForm(String actionForm) {
        this.actionForm = actionForm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String pathIcon) {
        this.icon = pathIcon;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public boolean isNeedsConfirm() {
        return needsConfirm;
    }

    public void setNeedsConfirm(boolean needsConfirm) {
        this.needsConfirm = needsConfirm;
    }

    public String getMessageConfirm() {
        return messageConfirm;
    }

    public void setMessageConfirm(String messageConfirm) {
        this.messageConfirm = messageConfirm;
    }

    public AbstractGrid getGridCallRefresh() {
        return gridCallRefresh;
    }

    public void setGridCallRefresh(AbstractGrid gridCallRefresh) {
        this.gridCallRefresh = gridCallRefresh;
    }

    public ArrayList<TipoUsuario> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<TipoUsuario> permissions) {
        this.permissions = permissions;
    }

    public BaseController getController() {
        return controller;
    }

    public void setController(BaseController controller) {
        this.controller = controller;
    }
}
