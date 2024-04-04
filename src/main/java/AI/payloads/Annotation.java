package AI.payloads;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Annotation {
    private String name;
    private List<AnnotationSpecific> specifics;
}
