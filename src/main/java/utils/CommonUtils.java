package utils;

public class CommonUtils {
    /**
     * Extracts the last word from a qualified name that is delimited by periods.
     *
     * @param qualifiedName The fully qualified name, e.g., a Java class name or package name.
     * @return The last word after the last period.
     */
    public static String getLastWordFromQualifiedName(String qualifiedName) {
        if (qualifiedName == null || qualifiedName.isEmpty()) {
            return "";  // Return empty string if input is null or empty
        }

        String[] parts = qualifiedName.split("\\.");  // Split the string on the period character
        return parts[parts.length - 1];  // Return the last element of the array
    }
}
