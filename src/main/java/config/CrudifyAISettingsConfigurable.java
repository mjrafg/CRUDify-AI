package config;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrudifyAISettingsConfigurable implements SearchableConfigurable {
    private static final String DESCRIPTION_TEXT = "Manage settings for Crudify AI, including JPA configurations and database connections.";

    @NotNull
    @Override
    public String getId() {
        return "preferences.CrudifyAI";
    }

    @Override
    public String getDisplayName() {
        return "Crudify AI";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel descriptionLabel = new JLabel("<html><div style='width:400px;'>" + DESCRIPTION_TEXT + "</div></html>");
        JLabel jpaLink = new JLabel("<html><a href=''>Configure JPA Settings</a></html>");
        JLabel databaseLink = new JLabel("<html><a href=''>Configure Database Settings</a></html>");

        setupLink(jpaLink, PluginJpaConfigurable.class);
        setupLink(databaseLink, PluginDatabaseConfigurable.class);

        panel.add(descriptionLabel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(jpaLink);
        panel.add(Box.createVerticalStrut(5));
        panel.add(databaseLink);

        return panel;
    }

    private void setupLink(JLabel linkLabel, Class<? extends Configurable> settingsClass) {
        linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        linkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Project project = ProjectManager.getInstance().getDefaultProject();
                ShowSettingsUtil.getInstance().showSettingsDialog(project, settingsClass);
            }
        });
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() {
    }

    @Override
    public void reset() {
    }

    @Override
    public void disposeUIResources() {
    }
}

