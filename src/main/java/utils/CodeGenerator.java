package utils;

import AI.payloads.AnnotationSpecific;
import AI.payloads.Property;
import AI.payloads.PropertyPayload;
import config.PluginSettings;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeGenerator {

    public static String generateEntityClassCodes(String entityName, PropertyPayload propertyPayload){
        PluginSettings pluginSettings = PluginSettings.getInstance();
        Names names = Names.getInstance();
        String content =
                "import "+pluginSettings.getEntityPackageField()+";\n" +
                        propertyPayload.getImports().stream().map(imp->"import "+imp.getImportProp()+";\n").collect(Collectors.joining(""))+
                        "import jdk.jfr.Description;\n" +
                        "import lombok.AllArgsConstructor;\n" +
                        "import lombok.Getter;\n" +
                        "import lombok.NoArgsConstructor;\n" +
                        "import lombok.Setter;\n" +
                        "\n" +
                        "@Entity\n" +
                        "@Getter\n" +
                        "@Setter\n" +
                        "@AllArgsConstructor\n" +
                        "@NoArgsConstructor\n" +
                        "@Description(\""+entityName+"\")\n" +
                        "public class "+names.getEntityName()+" extends BaseEntity {\n" +
                        propertyPayload.getProperties().stream().map(CodeGenerator::getPropertyStr).collect(Collectors.joining("\n"))+
                        "}";
        return content;
    }
    private static String getPropertyStr(Property property){
        StringBuilder sb = new StringBuilder();
        sb.append("\n    @Description(\"").append(property.getComment()).append("\")\n");
        if(property.getAnnotations().size() > 0){
            property.getAnnotations().forEach(annotation -> {
                sb.append("    @").append(annotation.getName());
                if(annotation.getSpecifics().size() > 0)
                {
                    sb.append("(");
                    List<AnnotationSpecific> specifics = annotation.getSpecifics();
                    for (int i = 0; i < specifics.size(); i++) {
                        AnnotationSpecific specific = specifics.get(i);
                        Object key = specific.getKey();
                        sb.append(key).append(" = ");
                        boolean isString = specific.getType().equalsIgnoreCase("string");
                        sb.append(isString ? "\"" : "").append(specific.getValue().replaceAll("\"","")).append(isString ? "\"" : "").append(i<specifics.size()-1? ",":"");
                    }
                    sb.append(")");
                }
                sb.append("\n");
            });
        }
        sb.append("    private ").append(property.getType()).append(" ").append(property.getName()).append(";");
        return sb.toString();
    }
    public static String generateControllerClassCodes(){
        PluginSettings pluginSettings = PluginSettings.getInstance();
        Names names = Names.getInstance();
        String content = "import "+pluginSettings.getControllerPackageField()+";\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import org.springframework.web.bind.annotation.GetMapping;\n" +
                "import org.springframework.web.bind.annotation.PathVariable;\n" +
                "import org.springframework.web.bind.annotation.RequestMapping;\n" +
                "import org.springframework.web.bind.annotation.RestController;\n" +
                "\n" +
                "@RestController\n" +
                "@RequestMapping(\"/api/"+Pluralizer.pluralize(names.getName()).toLowerCase()+"\")\n" +
                "public class "+names.getControllerName()+" extends GenericController<"+names.getEntityName()+", String> {\n" +
                "    "+names.getServiceName()+" "+names.getServiceNameCamelCase()+";\n" +
                "\n" +
                "    @Autowired\n" +
                "    public "+names.getControllerName()+"("+names.getServiceName()+" "+names.getServiceNameCamelCase()+") {\n" +
                "        super("+names.getServiceNameCamelCase()+");\n" +
                "        this."+names.getServiceNameCamelCase()+" = "+names.getServiceNameCamelCase()+";\n" +
                "    }\n" +
                "}\n" +
                "";


        return content;
    }
    public static String generateServiceClassCodes(){
        PluginSettings pluginSettings = PluginSettings.getInstance();
        Names names = Names.getInstance();
        String content = "import "+pluginSettings.getServicePackageField()+";\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "\n" +
                "@Service\n" +
                "public class "+names.getServiceName()+" extends GenericServiceImpl<"+names.getEntityName()+",String> {\n" +
                "    "+names.getRepositoryName()+" "+names.getRepositoryNameCamelCase()+";\n" +
                "\n" +
                "    @Autowired\n" +
                "    public "+names.getServiceName()+"("+names.getRepositoryName()+" "+names.getRepositoryNameCamelCase()+") {\n" +
                "        super("+names.getRepositoryNameCamelCase()+");\n" +
                "        this."+names.getRepositoryNameCamelCase()+" = "+names.getRepositoryNameCamelCase()+";\n" +
                "    }\n" +
                "}\n";

        return content;
    }
    public static String generateRepositoryClassCodes(){
        PluginSettings pluginSettings = PluginSettings.getInstance();
        Names names = Names.getInstance();
        String content = "import "+pluginSettings.getRepositoryPackageField()+";\n" +
                "\n" +
                "public interface "+names.getRepositoryName()+"  extends GenericRepository<"+names.getEntityName()+", String> {\n" +
                "}\n";
        return content;
    }
}
