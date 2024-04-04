package config;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@State(
        name = "Mjr.Life.Saver.PluginSettings",
        storages = {@Storage("MjrLifeSaverPluginSettings.xml")}
)
public class PluginSettings implements PersistentStateComponent<PluginSettings> {
    private String chatGptApiKey = "";
    private String entityPackageField="";
    private String controllerPackageField="";
    private String servicePackageField="";
    private String repositoryPackageField="";
    @Nullable
    @Override
    public PluginSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull PluginSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static PluginSettings getInstance() {
        PluginSettings pluginSettings = ApplicationManager.getApplication().getService(PluginSettings.class);
        return pluginSettings;
    }
}
