package utils;

import lombok.Data;

@Data
public class Names {
    private static Names namesObj = new Names();
    private String name;
    private String entityName;
    private String entityNameCamelCase;
    private String entityFileName;
    private String controllerName;
    private String controllerNameCamelCase;
    private String controllerFileName;
    private String serviceName;
    private String serviceNameCamelCase;
    private String serviceFileName;
    private String repositoryName;
    private String repositoryNameCamelCase;
    private String repositoryFileName;
    public static Names setInstance(String name){
        namesObj.setName(name);
        namesObj.setEntityName(name+"Entity");
        namesObj.setEntityNameCamelCase(Converters.toCamelCase(namesObj.getEntityName()));
        namesObj.setEntityFileName(name+"Entity.java");
        namesObj.setControllerName(name+"Controller");
        namesObj.setControllerNameCamelCase(Converters.toCamelCase(namesObj.getControllerName()));
        namesObj.setControllerFileName(name+"Controller.java");
        namesObj.setServiceName(name+"Service");
        namesObj.setServiceNameCamelCase(Converters.toCamelCase(namesObj.getServiceName()));
        namesObj.setServiceFileName(name+"Service.java");
        namesObj.setRepositoryName(name+"Repository");
        namesObj.setRepositoryNameCamelCase(Converters.toCamelCase(namesObj.getRepositoryName()));
        namesObj.setRepositoryFileName(name+"Repository.java");
        return namesObj;
    }
    public static Names getInstance(){
        return namesObj;
    }
}
