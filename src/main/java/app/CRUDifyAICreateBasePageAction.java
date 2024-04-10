package app;

import AI.chatGptTurbo.ChatGptTurbo;
import AI.payloads.PropertyPayload;
import com.fasterxml.jackson.core.type.TypeReference;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.codeStyle.CodeStyleManager;
import config.PluginSettings;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import utils.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CRUDifyAICreateBasePageAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        VirtualFile selectedDir = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (project == null || selectedDir == null) return;
        PluginSettings pluginSettings = PluginSettings.getInstance();
        if (pluginSettings.getChatGptApiKey().trim().equals("") ||pluginSettings.getServicePackageField().trim().equals("") || pluginSettings.getEntityPackageField().trim().equals("")
                || pluginSettings.getControllerPackageField().trim().equals("") || pluginSettings.getRepositoryPackageField().trim().equals("")) {
            Messages.showErrorDialog(project, "Please check the plugin settings and fill all fields", "Settings is empty");
            return;
        }
        BasePageCreationDialog dialog = new BasePageCreationDialog(project);
        if (dialog.showAndGet()) {
            String entityName = dialog.getEntityName();
            String propertiesStr = dialog.getProperties();
            String prompt = Prompt.getPropertiesPrompt(entityName, propertiesStr);

            ProgressManager.getInstance().run(new Task.Backgroundable(project, "Let's do magic with AI please wait...", false) {
                @Override
                public void run(@NotNull ProgressIndicator progressIndicator) {
                    progressIndicator.setIndeterminate(true);

                    Thread gptAskThread = new Thread(() -> {
                        String result = "";
                        try {
                            result = ChatGptTurbo.help(prompt);
                            result = Arrays.stream(result.split("\n")).filter(p -> !p.contains("`")).collect(Collectors.joining("\n"));
                            PropertyPayload propertyPayload = Converters.fromJson(result, new TypeReference<>() {
                            });
                            WriteCommandAction.runWriteCommandAction(project, () -> {
                                try {
                                    PsiDirectory directory = PsiManager.getInstance(project).findDirectory(selectedDir);
                                    if (directory != null) {
                                        Names names = Names.setInstance(propertyPayload.getEntityName());
                                        FileType javaFileType = FileTypeManager.getInstance().getFileTypeByExtension("java");
                                        PsiDirectory entityDirectory = directory.createSubdirectory(names.getNameCamelCase());
                                        String entityClassContent = CodeGenerator.generateEntityClassCodes(entityName, propertyPayload);
                                        PsiFile entityFile = PsiFileFactory.getInstance(project).createFileFromText(names.getEntityFileName(), javaFileType, entityClassContent);
                                        CodeStyleManager.getInstance(project).reformat(entityFile);
                                        entityDirectory.add(entityFile);

                                        String controllerClassContent = CodeGenerator.generateControllerClassCodes();
                                        PsiFile controllerFile = PsiFileFactory.getInstance(project).createFileFromText(names.getControllerFileName(), javaFileType, controllerClassContent);
                                        CodeStyleManager.getInstance(project).reformat(controllerFile);
                                        entityDirectory.add(controllerFile);

                                        String serviceClassContent = CodeGenerator.generateServiceClassCodes();
                                        PsiFile serviceFile = PsiFileFactory.getInstance(project).createFileFromText(names.getServiceFileName(), javaFileType, serviceClassContent);
                                        CodeStyleManager.getInstance(project).reformat(serviceFile);
                                        entityDirectory.add(serviceFile);

                                        String repositoryClassContent = CodeGenerator.generateRepositoryClassCodes();
                                        PsiFile repositoryFile = PsiFileFactory.getInstance(project).createFileFromText(names.getRepositoryFileName(), javaFileType, repositoryClassContent);
                                        CodeStyleManager.getInstance(project).reformat(repositoryFile);
                                        entityDirectory.add(repositoryFile);
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            });
                            String s = "";
                        } catch (Exception ex) {
                            javax.swing.SwingUtilities.invokeLater(() -> {
                                // This ensures the error message dialog is shown in the Event Dispatch Thread (EDT)
                                Messages.showErrorDialog(project, "Failed to generate code with AI: " + ex.getMessage(), "Error");
                            });
                            progressIndicator.cancel();
                            Thread.currentThread().interrupt();
                        }
                    });
                    gptAskThread.start();

                    while (gptAskThread.isAlive()) {
                        try {
                            Thread.sleep(5000);
                            javax.swing.SwingUtilities.invokeLater(() -> progressIndicator.setText(Loader.getRandomLoadingText()));
                        } catch (InterruptedException ex) {
                            progressIndicator.cancel();
                            gptAskThread.interrupt();
                            Thread.currentThread().interrupt();
                            return;
                        }
                        if (progressIndicator.isCanceled()) {
                            gptAskThread.interrupt();
                            return;
                        }
                    }
                    javax.swing.SwingUtilities.invokeLater(() -> progressIndicator.setText("TaDaa!"));
                    try {
                        Thread.sleep(3000);
                        gptAskThread.join();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }
            });
        }
    }


}
