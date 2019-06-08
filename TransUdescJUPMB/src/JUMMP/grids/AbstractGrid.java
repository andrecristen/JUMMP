/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.grids;

import JUMMP.controllers.BaseController;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import JUMMP.utils.Action;

/**
 *
 * @author André Cristen
 * @since 02.04.2019
 */
public abstract class AbstractGrid extends AbstractTableModel {

    private List<Object> linhas;
    private String[] colunas;
    private Action[] actions;
    private BaseController controller;

    public AbstractGrid(BaseController controller) {
        this.linhas = controller.getAllModels();
        this.colunas = this.getColunas();
        this.controller = controller;
    }

    public void limparTabela() {
        linhas.clear();
        super.fireTableDataChanged();
    }
    
    public void reloadTable(){
        limparTabela();
        this.linhas = this.controller.getAllModels();
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public List<Object> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Object> linhas) {
        this.linhas = linhas;
    }

    public abstract String[] getColunas();

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    public BaseController getController() {
        return controller;
    }

    public void setController(BaseController controller) {
        this.controller = controller;
    }

}
