
package AI.chatGpt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Choice {
    private String text;
    private Integer index;
    private Object logprobs;
    private String finishReason;
}
