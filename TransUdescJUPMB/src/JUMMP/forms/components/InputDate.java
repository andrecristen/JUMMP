/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.forms.components;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author andre
 */
public class InputDate {

    final static String DATE_BR = "DD/MM/AAAA";

    private String format;
    private String title;
    private boolean required;
    private boolean editable;
    private JLabel label;
    private JFormattedTextField textField;

    public InputDate(String title, String format, boolean required, boolean editable) {
        this.format = format;
        this.title = title;
        this.required = required;
        this.editable = editable;
    }

    public JPanel getComponent() {
        label = new JLabel(this.getTitle() + ":  ");
        label.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setSize(100, 45);
        try {
            if (this.getFormat().isEmpty()) {
                this.setFormat(DATE_BR);
            }
            String mascara = this.getFormat().replace("A", "#").replace("M", "#").replace("D", "#");
            MaskFormatter data = new MaskFormatter(mascara);
            textField = new JFormattedTextField(data);
        } catch (ParseException ex) {
            Logger.getLogger(InputDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        textField.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textField.setSize(250, 45);
        textField.setEditable(editable);
        JPanel painelInput = new JPanel();
        Box boxes[] = new Box[2];
        boxes[0] = Box.createHorizontalBox();
        boxes[1] = Box.createHorizontalBox();
        boxes[0].createGlue();
        boxes[1].createGlue();
        boxes[0].add(label);
        boxes[1].add(textField);
        painelInput.add(boxes[0]);
        painelInput.add(boxes[1]);
        label.setPreferredSize(new Dimension(100, 25));
        textField.setPreferredSize(new Dimension(300, 25));
        return painelInput;
    }

    public Date getValue() {
        String digitado = this.getTextField().getText();
        String[] parts = digitado.split("/");
        int ano = Integer.parseInt(parts[2]);
        int mes = Integer.parseInt(parts[1]);
        int dia = Integer.parseInt(parts[0]);
        Date data = new Date(ano, mes - 1, dia);
        return data;
    }

    public void setValue(Date value) {
        String anoCon;
        String mesCon;
        String diaCon;
        anoCon = Integer.toString(value.getYear());
        DateFormat mes = new SimpleDateFormat("MM");
        mesCon = mes.format(value);
        DateFormat dia = new SimpleDateFormat("dd");
        diaCon = dia.format(value);
        this.getTextField().setText(this.formatDate(diaCon, mesCon, anoCon));
    }

    private String formatDate(String dia, String mes, String ano) {
        String formato = this.getFormat();
        formato = formato.replace("AAAA", ano).replace("DD", dia).replace("MM", mes);
        return formato;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JFormattedTextField getTextField() {
        return textField;
    }

    public void setTextField(JFormattedTextField textField) {
        this.textField = textField;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public static String getDATE_BR() {
        return DATE_BR;
    }

}
