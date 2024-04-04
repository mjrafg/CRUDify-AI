package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converters {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts a JSON string to an object of the specified type.
     *
     * @param json The JSON string to convert.
     * @param typeReference The type reference of the target object type.
     * @param <T> The type of the target object.
     * @return An object of type T populated with data from the given JSON string.
     * @throws JsonProcessingException If an error occurs during JSON parsing.
     */
    public static <T> T fromJson(String json, TypeReference<T> typeReference) throws JsonProcessingException {
        return objectMapper.readValue(json, typeReference);
    }

    public static String toCamelCase(String input){
        return input.substring(0,1).toLowerCase()+input.substring(1);
    }
}
