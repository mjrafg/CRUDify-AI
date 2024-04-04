package service;

import AI.chatGpt.GptRequest;
import AI.chatGpt.GptResponse;
import AI.chatGptTurbo.GptRequestTurbo;
import AI.chatGptTurbo.GptResponseTurbo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST("v1/completions")
    Call<GptResponse> chatGpt(@Body GptRequest gptRequest);

    @POST("v1/chat/completions")
    Call<GptResponseTurbo> chatGptTurbo(@Body GptRequestTurbo gptRequest);
}
