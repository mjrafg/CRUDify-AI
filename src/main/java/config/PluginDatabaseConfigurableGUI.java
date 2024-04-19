package config;

import com.intellij.openapi.ui.ComboBox;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class PluginDatabaseConfigurableGUI {
    private JPanel mainPanel;
    private ComboBox<String> databaseTypeField;
    private JTextField databaseHostField;
    private JTextField databasePortField;
    private JTextField databaseUserNameField;
    private JPasswordField databasePasswordField;

    public PluginDatabaseConfigurableGUI() {
        mainPanel = new JPanel(null);

        databaseTypeField = new ComboBox<>(new String[]{"MariaDB","MySql","SQL Server"},100);
        databaseHostField = new JTextField(40);
        databasePortField = new JTextField(40);
        databaseUserNameField = new JTextField(40);
        databasePasswordField = new JPasswordField(40);
        JPanel databaseTypePanel = setupComboBoxWithLabel(databaseTypeField,"Database Type:");
        JPanel databaseHostPanel = setupTextFieldWithLabel(databaseHostField, "Server Host:");
        JPanel databasePortPanel = setupTextFieldWithLabel(databasePortField, "Port:");
        JPanel databaseUserNamePanel = setupTextFieldWithLabel(databaseUserNameField, "Username:");
        JPanel databasePasswordPanel = setupTextFieldWithLabel(databasePasswordField, "Password:");
       JPanel databasePanel =  addGroupBox("Database Server", 10, 0, 500, 320,databaseTypePanel, databaseHostPanel,databasePortPanel,databaseUserNamePanel,databasePasswordPanel);
        mainPanel.add(databasePanel);
    }

    public JPanel addGroupBox(String title, int x, int y, int width, int height, Component... components) {
        JPanel borderPanel = new JPanel(null);
        borderPanel.setLayout(new BoxLayout(borderPanel, BoxLayout.Y_AXIS));
        borderPanel.setBorder(BorderFactory.createTitledBorder(title));

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (Component component : components) {
            innerPanel.add(component);
        }

        borderPanel.add(innerPanel);
        borderPanel.setBounds(x, y, width, height);
        return borderPanel;
    }

    private JPanel setupTextFieldWithLabel(JTextField textField, String labelText) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(2, 0, 2, 0);
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            private void changed() {

            }
        });
        JPanel fieldPanel = new JPanel(new GridBagLayout());

        fieldPanel.add(new JLabel(labelText), gbc);
        fieldPanel.add(textField, gbc);
        return fieldPanel;
    }
    private JPanel setupComboBoxWithLabel(ComboBox comboField, String labelText) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(2, 0, 2, 0);
        comboField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                changed();
            }
            private void changed() {

            }
        });
        JPanel fieldPanel = new JPanel(new GridBagLayout());

        fieldPanel.add(new JLabel(labelText), gbc);
        fieldPanel.add(comboField, gbc);
        return fieldPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Object getDatabaseTypeField() {
        return databaseTypeField.getSelectedItem();
    }

    public void setDatabaseTypeField(String value) {
        this.databaseTypeField.setSelectedItem(value);
    }

    public String getDatabaseHostField() {
        return databaseHostField.getText();
    }

    public void setDatabaseHostField(String value) {
        this.databaseHostField.setText(value);
    }

    public String getDatabasePortField() {
        return databasePortField.getText();
    }

    public void setDatabasePortField(String value) {
        this.databasePortField.setText(value);
    }

    public String getDatabaseUserNameField() {
        return databaseUserNameField.getText();
    }

    public void setDatabaseUserNameField(String value) {
        this.databaseUserNameField.setText(value);
    }

    public String getDatabasePasswordField() {
        return databasePasswordField.getText();
    }

    public void setDatabasePasswordField(String value) {
        this.databasePasswordField.setText(value);
    }
}
