package AI.payloads;

import lombok.Data;

import java.util.List;

@Data
public class Property {
    private String name;
    private String type;
    private String comment;
    private List<Annotation> annotations;
}
