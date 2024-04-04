package config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PluginConfigurable implements Configurable {
    private PluginConfigurableGUI gui;

    @Override
    public String getDisplayName() {
        return "CRUDify AI Configuration";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        gui = new PluginConfigurableGUI();
        PluginSettings settings = PluginSettings.getInstance();
        if (settings != null) {
            gui.setChatGptApiKey(settings.getChatGptApiKey());
            gui.setEntityPackageField(settings.getEntityPackageField());
            gui.setControllerPackageField(settings.getControllerPackageField());
            gui.setServicePackageField(settings.getServicePackageField());
            gui.setRepositoryPackageField(settings.getRepositoryPackageField());
        }
        return gui.getMainPanel();
    }
//سیر 5 برنج 3 گوشت ماهیچه گاو هویج کلان 4 کشمش سرخ 1 کیلو لیمو 1 بسته پیاز 2 زیره نمک مورچ روغن بزرگ 2.6 لیتری تخم مرغ دوبسته نان 4 بسته بایجان رومی 3 خیار 3 نوشابه 24 عددی آب کوچیک 1 بسته مگ جو 1 بسته کچالو 4 کاهو 3 دانه

    @Override
    public boolean isModified() {
        PluginSettings settings = PluginSettings.getInstance();
        return settings != null && (!gui.getChatGptApiKey().equals(settings.getChatGptApiKey())
                || !gui.getEntityPackageField().equals(settings.getEntityPackageField())
                || !gui.getControllerPackageField().equals(settings.getControllerPackageField())
                || !gui.getServicePackageField().equals(settings.getServicePackageField())
                || !gui.getRepositoryPackageField().equals(settings.getRepositoryPackageField()));
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
    public void disposeUIResources() {
        gui = null;
    }
}
