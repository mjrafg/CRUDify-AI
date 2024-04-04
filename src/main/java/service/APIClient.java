package service;

import com.intellij.openapi.application.ApplicationManager;
import config.PluginSettings;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class APIClient {
    private static Retrofit retrofit = null;
   public static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                PluginSettings pluginSettings = ApplicationManager.getApplication().getService(PluginSettings.class);
                String token = pluginSettings.getChatGptApiKey();
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(newRequest);
            }
        }) .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        return retrofit;
    }
}
