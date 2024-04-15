package config;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class PluginConfigurableGUI {
    private JPanel mainPanel;
    private JTextField chatGptApiKeyField;
    private JTextField entityPackageField;
    private JTextField controllerPackageField;
    private JTextField servicePackageField;
    private JTextField repositoryPackageField;

    public PluginConfigurableGUI() {
        mainPanel = new JPanel(null);
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        chatGptApiKeyField = new JTextField(40);
        entityPackageField = new JTextField(40);
        controllerPackageField = new JTextField(40);
        servicePackageField = new JTextField(40);
        repositoryPackageField = new JTextField(40);

        setupTextFieldWithLabel(chatGptApiKeyField, "ChatGPT API Key:",0);
        setupTextFieldWithLabel(entityPackageField, "Generic Entity Class Path:",1);
        setupTextFieldWithLabel(controllerPackageField, "Generic Controller Class Path:",2);
        setupTextFieldWithLabel(servicePackageField, "Generic Service Class Path:",3);
        setupTextFieldWithLabel(repositoryPackageField, "Generic Repository Class Path:",4);
    }
    public void addGroupBox(String title, Component... components) {
        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new BoxLayout(borderPanel, BoxLayout.Y_AXIS));
        borderPanel.setBorder(BorderFactory.createTitledBorder(title));

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (Component component : components) {
            innerPanel.add(component);
        }

        borderPanel.add(innerPanel);
        mainPanel.add(borderPanel);
    }
    private JPanel setupTextFieldWithLabel(JTextField textField, String labelText,int index) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(2, 0, 2, 0); // Top and bottom padding to reduce space between fields
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
                // This can mark the settings as modified, enabling the "Apply" button
            }
        });
        JPanel fieldPanel = new JPanel(new GridBagLayout());

        fieldPanel.add(new JLabel(labelText), gbc); // Add label with constraints
        fieldPanel.add(textField, gbc); // Add text field with the same constraints
        fieldPanel.setBounds(10,index*60,400,50);
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
