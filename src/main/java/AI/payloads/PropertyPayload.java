package AI.payloads;

import lombok.Data;

import java.util.List;

@Data
public class PropertyPayload {
    private List<Import> imports;
    private List<Property> properties;
    String entityName;
}
