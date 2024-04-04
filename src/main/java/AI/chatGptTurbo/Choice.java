
package AI.chatGptTurbo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.annotation.Generated;

@Data
public class Choice {
    private Integer index;
    private Message message;
    private String finishReason;
}
