/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.grids.AbstractGrid;
import controllers.PessoaController;
import models.Pessoa;

/**
 *
 * @author André Cristen
 */
public class PessoaGrid extends AbstractGrid{

    public PessoaGrid() {
        super(new PessoaController());
    }

    @Override
    public String[] getColunas() {
        String[] colunasPessoas = new String[]{"#", "Nome"};
        return colunasPessoas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Pessoa pessoa = (Pessoa)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return pessoa.getId();
            case 1:
                return pessoa.getNome();
            default:
                return null;
        }
    }
    
}
