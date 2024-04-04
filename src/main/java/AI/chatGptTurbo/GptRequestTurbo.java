
package AI.chatGptTurbo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
public class GptRequestTurbo {

    private String model;
    private List<Message> messages;
    private Double temperature;
}
