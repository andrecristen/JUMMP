/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.grids.AbstractGrid;
import controllers.PessoaFisicaController;
import models.Pessoa;
import models.PessoaFisica;

/**
 *
 * @author André Cristen
 */
public class PessoaFisicaGrid extends AbstractGrid{

    public PessoaFisicaGrid() {
        super(new PessoaFisicaController());
    }

    @Override
    public String[] getColunas() {
        String[] colunasPessoas = new String[]{"#", "CPF"};
        return colunasPessoas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      PessoaFisica pessoa = (PessoaFisica)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return pessoa.getId();
            case 1:
                return pessoa.getCpf();
            default:
                return null;
        }
    }
    
}
