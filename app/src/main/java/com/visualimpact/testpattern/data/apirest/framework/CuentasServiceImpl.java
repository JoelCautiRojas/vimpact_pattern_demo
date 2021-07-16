package com.visualimpact.testpattern.data.apirest.framework;

import com.google.gson.GsonBuilder;
import com.visualimpact.testpattern.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CuentasServiceImpl {

    private static final String BASE_URL = BuildConfig.URL_HOST + BuildConfig.URL_API;
    private static CuentasService apiService;

    public static CuentasService getApiService(String token, String converter){
        OkHttpClient httpClient = ApiRestUtil.getHttpClientToken(token);
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.client(httpClient);
        switch (converter){
            case "jackson":
                builder.addConverterFactory(JacksonConverterFactory.create(ApiRestUtil.getObjectMapperConfiguration()));
                break;
            default:
                builder.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()));
                break;
        }
        Retrofit retrofit = builder.build();
        apiService = retrofit.create(CuentasService.class);
        return apiService;
    }

    public static CuentasService getApiService(String converter){
        OkHttpClient httpClient = ApiRestUtil.getHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.client(httpClient);
        switch (converter){
            case "jackson":
                builder.addConverterFactory(JacksonConverterFactory.create(ApiRestUtil.getObjectMapperConfiguration()));
                break;
            default:
                builder.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()));
                break;
        }
        Retrofit retrofit = builder.build();
        apiService = retrofit.create(CuentasService.class);
        return apiService;
    }
}
