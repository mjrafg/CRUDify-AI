
package AI.chatGptTurbo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
public class GptResponseTurbo {

    private String id;
    private String object;
    private Integer created;
    private String model;
    private List<Choice> choices;
    private Usage usage;

}
