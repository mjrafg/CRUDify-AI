package AI.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Import {
    @JsonProperty("import")
    private String importProp;
}
