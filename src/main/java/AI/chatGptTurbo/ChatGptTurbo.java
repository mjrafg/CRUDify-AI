package AI.chatGptTurbo;


import okhttp3.ResponseBody;
import org.json.JSONObject;
import service.APIClient;
import service.APIService;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatGptTurbo {
    public static String help(String prompt) throws IOException {
        prompt = prompt + " just and only just send the requirement and do not send any description.";
        APIService apiService = APIClient.getClient().create(APIService.class);
        GptRequestTurbo gptRequest = new GptRequestTurbo();
        gptRequest.setModel("gpt-4-0125-preview");
        gptRequest.setTemperature(0.5);
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("user",prompt));
        messages.add(new Message("assistant","roll as a senior developer"));
        gptRequest.setMessages(messages);
        Response<GptResponseTurbo> response = apiService.chatGptTurbo(gptRequest).execute();
        if (response.isSuccessful()) {
            GptResponseTurbo gptResponse = response.body();
            if (gptResponse != null && gptResponse.getChoices().size() > 0) {
                Choice choice = gptResponse.getChoices().get(0);
                Message message = choice.getMessage();
                return message.getContent();
            }
        }else {
            ResponseBody errorBody = response.errorBody();
            if (errorBody != null) {
                try {
                    String errorString = errorBody.string();
                    JSONObject jsonObject = new JSONObject(errorString);
                    JSONObject errorObject = jsonObject.getJSONObject("error");
                    String errorMessage = errorObject.getString("message");
                    throw new IOException(errorMessage);
                } catch (Exception e) {
                    throw new IOException(e.getMessage());
                }
            }
        }

        return "";
    }
}
