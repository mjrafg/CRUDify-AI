package config;

import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
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
    private String entityPackageField = "";
    private String controllerPackageField = "";
    private String servicePackageField = "";
    private String repositoryPackageField = "";
    private String databaseTypeField = "";
    private String databaseHostField = "";
    private String databasePortField = "";
    private String databaseUserNameField = "";
    private String databasePasswordField = "";

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
        if (isVersion2019_2OrNewer()) {
            return ApplicationManager.getApplication().getService(PluginSettings.class);
        } else {
            return ServiceManager.getService(PluginSettings.class);
        }
    }

    private static boolean isVersion2019_2OrNewer() {
        String ideVersion = ApplicationInfo.getInstance().getBuild().asString();
        return ideVersion.compareTo("192") >= 0; // "192" is the build number for 2019.2
    }
}
