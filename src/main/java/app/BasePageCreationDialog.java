package app;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class BasePageCreationDialog extends DialogWrapper {
    private JTextField entityNameField;
    private JTextArea usageAreaField;
    private JTextArea propertiesAreaField;

    public BasePageCreationDialog(@Nullable Project project) {
        super(project);
        setTitle("Create New Base Page");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        entityNameField = new JTextField(50);
        propertiesAreaField = new JTextArea(20, 50);
        propertiesAreaField.setLineWrap(true);
        propertiesAreaField.setWrapStyleWord(true);

        usageAreaField = new JTextArea(5, 50);
        usageAreaField.setLineWrap(true);
        usageAreaField.setWrapStyleWord(true);

        panel.add(new JLabel("Entity Name*"), BorderLayout.NORTH);
        panel.add(entityNameField, BorderLayout.CENTER);

        // Modified part starts here
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS)); // Changed to BoxLayout

        JPanel descriptionPanel = new JPanel(new BorderLayout());
        JLabel propertiesLabel = new JLabel("Properties(one per line)");
        propertiesLabel.setToolTipText("Enter each property on a separate line.");
        descriptionPanel.add(propertiesLabel, BorderLayout.NORTH);
        descriptionPanel.add(new JScrollPane(propertiesAreaField), BorderLayout.CENTER);

//        JPanel usagePanel = new JPanel(new BorderLayout());
//        usagePanel.add(new JLabel("Usage"), BorderLayout.NORTH);
//        usagePanel.add(new JScrollPane(usageAreaField), BorderLayout.CENTER);

        // Adding the description and usage panels to the south panel
        southPanel.add(descriptionPanel);
//        southPanel.add(usagePanel);

        panel.add(southPanel, BorderLayout.SOUTH);
        // Modified part ends here

        return panel;
    }

    public String getEntityName() {
        return entityNameField.getText().trim();
    }

    public String getUsage() {
        return usageAreaField.getText().trim();
    }
    public String getProperties() {
        return propertiesAreaField.getText().trim();
    }



    @Override
    protected ValidationInfo doValidate() {
        if (getEntityName().isEmpty()) {
            return new ValidationInfo("Entity name cannot be empty", entityNameField);
        }
        return null;
    }
}
