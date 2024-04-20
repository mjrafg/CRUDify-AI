package utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Prompt {
    private static String formatProperties(String propertiesStr) {
        return Arrays.stream(propertiesStr.split("\n"))
                .filter(property -> !property.trim().isEmpty())
                .map(property -> "`   \"" + property + "\",\\n`+\n")
                .collect(Collectors.joining());
    }

    public static String getPropertiesPrompt(String entityName, String propertiesStr) {
        return "{\n" +
                "`  \"task\": \"generate-spring-boot-entity-properties\",\\n`+\n" +
                "`  \"entityName\": \"" + entityName + "\",\\n`+\n" +
                "`  \"properties\": [\\n`+\n" +
                formatProperties(propertiesStr) +
                "`  ],\\n`+\n" +
                "  \"requirements\": {\n" +
                "    \"translate\": \"EN\",\n" +
                "    \"language\": \"Java\",\n" +
                "    \"framework\": \"Spring Boot\",\n" +
                "    \"expected\": \"Json array of properties with details and Java imports\",\n" +
                "    \"responseDescription\": {\n" +
                "      \"before\": false,\n" +
                "      \"after\": false\n" +
                "    },\n" +
                "    \"jsonStructure\": {\n" +
                "      \"imports\": [\n" +
                "        {\n" +
                "          \"import\": \"String indicating the import\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"entityName\": \"Translate entityName to english and place here\",\n" +
                "      \"properties\": [\n" +
                "        {\n" +
                "          \"name\": \"String indicating the property name\",\n" +
                "          \"type\": \"String indicating the data type\",\n" +
                "          \"comment\": \"String providing a description of the property in detected properties language\",\n" +
                "          \"annotations\": [\n" +
                "            {\n" +
                "              \"name\": \"String indicating the annotation name\",\n" +
                "              \"specifics\": [\n" +
                "                {\n" +
                "                  \"key\": \"String indicating the annotation parameter name\",\n" +
                "                  \"value\": \"String indicating the annotation parameter value\",\n" +
                "                  \"type\": \"String indicating the annotation parameter value is string or number\"\n" +
                "                }\n" +
                "              ]\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"context\": \"Entity class generation based on property names\",\n" +
                "    \"exclude\": [\n" +
                "      \"id\"\n" +
                "    ],\n" +
                "    \"annotations\": {\n" +
                "      \"includeValidation\": true,\n" +
                "      \"includeJPA\": true,\n" +
                "      \"imports\": \"use jakarta.persistence for jpa annotations\"\n" +
                "      \"swagger\": \"add Schema annotation for each entity fill description and example in detected properties language\"\n" +
                "    }\n" +
                "  }\n" +
                "}\n";

    }
}
