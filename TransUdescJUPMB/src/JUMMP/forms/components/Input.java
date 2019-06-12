/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.forms.components;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Andre Cristen
 */
public class Input {

    private String title;

    private int type;

    private boolean required;

    private boolean editable;

    private JTextField textField;

    private JLabel label;

    public Input(String title, boolean required, boolean editable) {
        this.title = title;
        this.required = required;
        this.editable = editable;
    }

    public JPanel getComponent() {
        label = new JLabel(this.getTitle() + ":  ");
        label.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setSize(100, 45);
        textField = new JTextField();
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

    public String getValue() {
        return this.getTextField().getText();
    }

    public void setValue(String value) {
        this.getTextField().setText(value);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean disabled) {
        this.editable = disabled;
    }

}
