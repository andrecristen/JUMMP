/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.frames;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author André Cristen
 * 
 * o grid serve para listar as informacoes do sistema, é uma tabela
 */
public abstract class AbstractGridFrame extends JFrame {

    /**
     * Table que sera mostrada no Frame
     */
    private JTable tableObjetos;

    /**
     * Scroll para table
     */
    private JScrollPane scrollTable;

    /**
     * Lista com todos os objetos que serao mostrados no Grid
     */
    private List<Object> objetos;

    public AbstractGridFrame(List<Object> objetos, String title, AbstractTableModel tableAppend) {
        //Seta o titulo do frame
        super.setTitle(title);
        //Seta os objetos recebidos
        this.objetos = objetos;
        //Inicia com a table a ser inserida
        initialize(tableAppend);
        //Adiciona os componets
        addComponents();
        //Seta um tamanho para o Frame
        super.setSize(800, 600);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initialize(AbstractTableModel tableModel) {
        tableObjetos = new JTable(tableModel);
        scrollTable = new JScrollPane(tableObjetos);
    }

    private void addComponents() {
        this.getContentPane().add(scrollTable);
    }
    
    public void display() {
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
