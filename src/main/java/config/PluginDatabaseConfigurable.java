package config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PluginDatabaseConfigurable implements Configurable {
    private PluginDatabaseConfigurableGUI gui;

    @Override
    public String getDisplayName() {
        return "CRUDify AI Configuration";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        gui = new PluginDatabaseConfigurableGUI();
        initGuiValues();
        return gui.getMainPanel();
    }
    private void initGuiValues(){
        PluginSettings settings = PluginSettings.getInstance();
        if (settings != null) {
            gui.setDatabaseTypeField(settings.getDatabaseTypeField());
            gui.setDatabaseHostField(settings.getDatabaseHostField());
            gui.setDatabasePortField(settings.getDatabasePortField());
            gui.setDatabaseUserNameField(settings.getDatabaseUserNameField());
            gui.setDatabasePasswordField(settings.getDatabasePasswordField());
        }
    }
    @Override
    public boolean isModified() {
        PluginSettings settings = PluginSettings.getInstance();
        return settings != null && (
                 !gui.getDatabaseHostField().equals(settings.getDatabaseHostField())
//                || !gui.getDatabaseTypeField().equals(settings.getDatabaseTypeField())
                || !gui.getDatabasePortField().equals(settings.getDatabasePortField())
                || !gui.getDatabaseUserNameField().equals(settings.getDatabaseUserNameField())
                || !gui.getDatabasePasswordField().equals(settings.getDatabasePasswordField())
        );
    }

    @Override
    public void apply() {
        PluginSettings settings = PluginSettings.getInstance();
        if (settings != null) {
//            settings.setDatabaseTypeField(gui.getDatabaseTypeField());
            settings.setDatabaseHostField(gui.getDatabaseHostField());
            settings.setDatabasePortField(gui.getDatabasePortField());
            settings.setDatabaseUserNameField(gui.getDatabaseUserNameField());
            settings.setDatabasePasswordField(gui.getDatabasePasswordField());
        }
    }

    @Override
    public void reset() {
        initGuiValues();
    }

    @Override
    public void disposeUIResources() {
        gui = null;
    }
}
