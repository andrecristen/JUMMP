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

    /**
     * Busca todas as linhas da tabela com base no controler recebido e o metodo
     * getAllModels(), que todo base controller vai ter.
     */
    private List<Object> linhas;
    /**
     * Recebe um array de strings na ordem que os titulos das colunas serao 
     * apresentados exemplo:
     * String[] colunasCarregamentos = new String[]{"#", "Endereço chegada", "Endereço saída"};
     * deve ser passado no metodo getColunas();
     */
    private String[] colunas;
    /**
     * Recebe o controlador dos modelos que serao listas serve unica e exclusivamente
     * para buscar os modelos da tabela, isso porque as actions sao independetes
     * em relacao a controladores.
     */
    private BaseController controllerToList;

    public AbstractGrid(BaseController controllerToList) {
        this.linhas = controllerToList.getAllModels();
        this.colunas = this.getColunas();
        this.controllerToList = controllerToList;
    }

    public void limparTabela() {
        linhas.clear();
        super.fireTableDataChanged();
    }

    public void reloadTable() {
        limparTabela();
        this.linhas = this.controllerToList.getAllModels();
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
        return controllerToList;
    }

    public void setController(BaseController controller) {
        this.controllerToList = controller;
    }
   
    public abstract Object getValueRowColumn(int rowIndex, int columnIndex);

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
           return this.getValueRowColumn(rowIndex, columnIndex);
        }catch(Exception exception){
           return null;
        }
    }
    
    

}
