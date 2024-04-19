package config;

import com.intellij.openapi.ui.ComboBox;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class PluginJpaConfigurableGUI {
    private JPanel mainPanel;
    private JTextField chatGptApiKeyField;
    private JTextField entityPackageField;
    private JTextField controllerPackageField;
    private JTextField servicePackageField;
    private JTextField repositoryPackageField;

    public PluginJpaConfigurableGUI() {
        mainPanel = new JPanel(null);

        chatGptApiKeyField = new JTextField(40);
        entityPackageField = new JTextField(40);
        controllerPackageField = new JTextField(40);
        servicePackageField = new JTextField(40);
        repositoryPackageField = new JTextField(40);

        JPanel chatGptPanel = setupTextFieldWithLabel(chatGptApiKeyField, "ChatGPT API Key:");
        JPanel entityPanel = setupTextFieldWithLabel(entityPackageField, "Generic Entity Class Path:");
        JPanel controllerPanel = setupTextFieldWithLabel(controllerPackageField, "Generic Controller Class Path:");
        JPanel servicePanel = setupTextFieldWithLabel(servicePackageField, "Generic Service Class Path:");
        JPanel repositoryPanel = setupTextFieldWithLabel(repositoryPackageField, "Generic Repository Class Path:");
        JPanel jpaPanel =  addGroupBox("Base JPA page", 10, 0, 500, 320, chatGptPanel, entityPanel, controllerPanel, servicePanel, repositoryPanel);


        mainPanel.add(jpaPanel);
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

    public String getChatGptApiKey() {
        return chatGptApiKeyField.getText();
    }

    public void setChatGptApiKey(String apiKey) {
        chatGptApiKeyField.setText(apiKey);
    }

    public String getEntityPackageField() {
        return entityPackageField.getText();
    }

    public void setEntityPackageField(String value) {
        entityPackageField.setText(value);
    }

    public String getControllerPackageField() {
        return controllerPackageField.getText();
    }

    public void setControllerPackageField(String value) {
        controllerPackageField.setText(value);
    }

    public String getServicePackageField() {
        return servicePackageField.getText();
    }

    public void setServicePackageField(String value) {
        servicePackageField.setText(value);
    }

    public String getRepositoryPackageField() {
        return repositoryPackageField.getText();
    }

    public void setRepositoryPackageField(String value) {
        repositoryPackageField.setText(value);
    }


}
