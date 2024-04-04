package utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Prompt {
    public static String getPropertiesPrompt(String entityName,String propertiesStr){
        return "`{\\n`+\n" +
                "`  \"task\": \"generate-spring-boot-entity-properties\",\\n`+\n" +
                "`  \"entityName\": \"" + entityName + "\",\\n`+\n" +
                "`  \"properties\": [\\n`+\n" +
                Arrays.stream(propertiesStr.split("\n")).toList().stream().filter(property -> !property.equals("")).map(property -> "`   \"" + property + "\",\\n`+\n").collect(Collectors.joining("")) +
                "`  ],\\n`+\n" +
                "`  \"requirements\": {\\n`+\n" +
                "`    \"translate\": \"EN\",\\n`+\n" +
                "`    \"language\": \"Java\",\\n`+\n" +
                "`    \"framework\": \"Spring Boot\",\\n`+\n" +
                "`    \"expected\": \"Json array of properties with details and Java imports\",\\n`+\n" +
                "`    \"responseDescription\":{\\n`+\n" +
                "`          before:false,\\n`+\n" +
                "`          after:false\\n`+\n" +
                "`      },\\n`+\n" +
                "`    \"jsonStructure\": [\\n`+\n" +
                "`     \"imports\":[{\"import\":\"String indicating the import\"}]\\n`+\n" +
                "`     \"entityName\":\"Translate entityName to english and place here\"\\n`+\n" +
                "`     \"properties\":{\\n`+\n" +
                "`      \"name\": \"String indicating the property name\",\\n`+\n" +
                "`      \"type\": \"String indicating the data type\",\\n`+\n" +
                "`      \"comment\": \"String providing a description of the property in detected properties language\",\\n`+\n" +
                "`      \"annotations\": [\\n`+\n" +
                "`        {\\n`+\n" +
                "`          \"name\": \"String indicating the annotation name\",\\n`+\n" +
                "`          \"specifics\": [\\n`+\n" +
                "`            {\\n`+\n" +
                "`              \"key\": \"String indicating the annotation parameter name\",\\n`+\n" +
                "`              \"value\": \"String indicating the annotation parameter value\"\\n`+\n" +
                "`              \"type\": \"String indicating the annotation parameter value is string or number\"\\n`+\n" +
                "`            }\\n`+\n" +
                "`          ]\\n`+\n" +
                "`        }\\n`+\n" +
                "`      ]\\n`+\n" +
                "`    },\\n`+\n" +
                "`]\\n`+\n" +
                "`    \"context\": \"Entity class generation based on property names\",\\n`+\n" +
                "`    \"exclude\": [\"id\"],\\n`+\n" +
                "`    \"annotations\": {\\n`+\n" +
                "`      \"includeValidation\": true,\\n`+\n" +
                "`      \"includeJPA\": true\\n`+\n" +
                "`    }\\n`+\n" +
                "`  }\\n`+\n" +
                "`}\\n`";
    }
}
