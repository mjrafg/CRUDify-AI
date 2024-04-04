package AI.chatGpt;


import service.APIClient;
import service.APIService;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatGpt {
    public static List<Choice> tellMeDavinci(String prompt) throws IOException {
        APIService apiService = APIClient.getClient().create(APIService.class);
        GptRequest gptRequest = new GptRequest();
        gptRequest.setModel("gpt-3.5-turbo-instruct");
        gptRequest.setPrompt(prompt);
        gptRequest.setTemperature(0.0);
        gptRequest.setMaxTokens(3500);
        gptRequest.setTopP(1.0);
        gptRequest.setFrequencyPenalty(0.0);
        gptRequest.setPresencePenalty(0.0);
        List<String> stop = new ArrayList<>();
        stop.add("\"\"\"");
        gptRequest.setStop(stop);
        Response<GptResponse> response = apiService.chatGpt(gptRequest).execute();
        if (response.isSuccessful()) {
            GptResponse gptResponse = response.body();
            if (gptResponse != null) {
                return gptResponse.getChoices();
            }
        }
        else{
            String error = response.errorBody().string();
            error = error +"";
        }
        return null;
    }
    public static List<Choice> tellMeGpt(String prompt) throws IOException {
        APIService apiService = APIClient.getClient().create(APIService.class);
        GptRequest gptRequest = new GptRequest();
        gptRequest.setModel("text-davinci-003");
        gptRequest.setPrompt(prompt);
        gptRequest.setTemperature(0.0);
        gptRequest.setMaxTokens(3500);
        gptRequest.setTopP(1.0);
        gptRequest.setFrequencyPenalty(0.0);
        gptRequest.setPresencePenalty(0.0);
        List<String> stop = new ArrayList<>();
        stop.add("\"\"\"");
        gptRequest.setStop(stop);
        Response<GptResponse> response = apiService.chatGpt(gptRequest).execute();
        if (response.isSuccessful()) {
            GptResponse gptResponse = response.body();
            if (gptResponse != null) {
                return gptResponse.getChoices();
            }
        }
        else{
            String error = response.errorBody().string();
            error = error +"";
        }
        return null;
    }
}
