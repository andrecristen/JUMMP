package views.forms;

import JUMMP.forms.BaseForm;
import JUMMP.utils.Action;
import controllers.PessoaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormPessoa extends BaseForm {

    private JLabel labelID;
    private JLabel labelNome;
    
    private JTextField textFieldID;
    private JTextField textFieldNome;
    
    private GridBagConstraints cons;
    
    private JPanel panelFormulario;
    private Dimension dimensao;
    private LayoutManager layout;

    public FormPessoa(Action action) {
        super("Formulário Pessoa Física", new Dimension(400, 260), new PessoaController(), action);

        initComponents();
        addComponents();
    }

    private void initComponents() {

        labelID = new JLabel("ID:  ");
        labelNome = new JLabel("Nome:  ");

        labelID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        labelNome.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        labelID.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNome.setHorizontalAlignment(SwingConstants.RIGHT);

        textFieldID = new JTextField();
        textFieldNome = new JTextField();

        textFieldID.setEditable(false);
        
        textFieldID.setFont(new Font("Arial", Font.PLAIN, (int) 18));
        textFieldNome.setFont(new Font("Arial", Font.PLAIN, (int) 18));

        layout = new GridBagLayout();
        panelFormulario = new JPanel();
        panelFormulario.setLayout(layout);
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(labelNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.insets = new Insets(5, 0, 5, 0);
        cons.gridwidth = 1;
        cons.ipadx = 200;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(textFieldNome, cons);

        super.addFormulario(panelFormulario);
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public void setTextFieldID(JTextField textFieldID) {
        this.textFieldID = textFieldID;
    }

    public JTextField getTextFieldNome() {
        return textFieldNome;
    }

    public void setTextFieldNome(JTextField textFieldNome) {
        this.textFieldNome = textFieldNome;
    }
    
    
}
