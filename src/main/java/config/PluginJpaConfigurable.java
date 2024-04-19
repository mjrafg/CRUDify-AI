package config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PluginJpaConfigurable implements Configurable {
    private PluginJpaConfigurableGUI gui;

    @Override
    public String getDisplayName() {
        return "CRUDify AI Configuration";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        gui = new PluginJpaConfigurableGUI();
        initGuiValues();
        return gui.getMainPanel();
    }
    private void initGuiValues(){
        PluginSettings settings = PluginSettings.getInstance();
        if (settings != null) {
            gui.setChatGptApiKey(settings.getChatGptApiKey());
            gui.setEntityPackageField(settings.getEntityPackageField());
            gui.setControllerPackageField(settings.getControllerPackageField());
            gui.setServicePackageField(settings.getServicePackageField());
            gui.setRepositoryPackageField(settings.getRepositoryPackageField());
        }
    }
    @Override
    public boolean isModified() {
        PluginSettings settings = PluginSettings.getInstance();
        return settings != null && (!gui.getChatGptApiKey().equals(settings.getChatGptApiKey())
                || !gui.getEntityPackageField().equals(settings.getEntityPackageField())
                || !gui.getControllerPackageField().equals(settings.getControllerPackageField())
                || !gui.getServicePackageField().equals(settings.getServicePackageField())
                || !gui.getRepositoryPackageField().equals(settings.getRepositoryPackageField())
        );
    }

    @Override
    public void apply() {
        PluginSettings settings = PluginSettings.getInstance();
        if (settings != null) {
            settings.setChatGptApiKey(gui.getChatGptApiKey());
            settings.setEntityPackageField(gui.getEntityPackageField());
            settings.setControllerPackageField(gui.getControllerPackageField());
            settings.setServicePackageField(gui.getServicePackageField());
            settings.setRepositoryPackageField(gui.getRepositoryPackageField());
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
