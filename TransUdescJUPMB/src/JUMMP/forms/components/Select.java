/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.forms.components;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author André
 */
public class Select {

    private String title;

    private boolean required;

    private boolean editable;

    private JLabel label;

    private JComboBox listField;

    private Object[] list;

    public Select(String title, boolean required, boolean editable, Object[] list) {
        this.title = title;
        this.required = required;
        this.editable = editable;
        this.list = list;
    }

    public JPanel getComponent() {
        label = new JLabel(this.getTitle() + ":  ");
        label.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setSize(100, 45);
        listField = new JComboBox(list);
        listField.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        listField.setSize(250, 45);
        listField.setEnabled(editable);
        JPanel painelInput = new JPanel();
        Box boxes[] = new Box[2];
        boxes[0] = Box.createHorizontalBox();
        boxes[1] = Box.createHorizontalBox();
        boxes[0].createGlue();
        boxes[1].createGlue();
        boxes[0].add(label);
        boxes[1].add(listField);
        painelInput.add(boxes[0]);
        painelInput.add(boxes[1]);
        label.setPreferredSize(new Dimension(100, 25));
        listField.setPreferredSize(new Dimension(300, 25));
        return painelInput;
    }

    public String getValue() {
        return this.getListField().getSelectedItem().toString();
    }

    public void setValue(Object value) {
        this.getListField().setSelectedItem(value);
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

    public JComboBox getListField() {
        return listField;
    }

    public void setListField(JComboBox list) {
        this.listField = list;
    }

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = list;
    }

}
