
package AI.chatGptTurbo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Generated;

@Data
@AllArgsConstructor
public class Message {
    private String role;
    private String content;
}
