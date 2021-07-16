package com.visualimpact.testpattern.data.apirest.framework;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visualimpact.testpattern.BuildConfig;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;

public class ApiRestUtil {

    private static final Integer timeoutHTTP = 240;

    //
    //
    // METODOS EXPUESTOS
    //
    //

    public static OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(timeoutHTTP, TimeUnit.SECONDS);
        httpClient.connectTimeout(timeoutHTTP, TimeUnit.SECONDS);
        httpClient.connectionSpecs(Arrays.asList(getConnectionSpecModernTLS(), ConnectionSpec.COMPATIBLE_TLS,ConnectionSpec.CLEARTEXT));
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(getHttpLoggingInterceptor());
        }
        httpClient.cache(null);
        return httpClient.build();
    }

    public static OkHttpClient getHttpClientToken(String token) {
        if (token.trim().length() > 0){
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(timeoutHTTP, TimeUnit.SECONDS);
            httpClient.connectTimeout(timeoutHTTP, TimeUnit.SECONDS);
            httpClient.connectionSpecs(Arrays.asList(getConnectionSpecModernTLS(),ConnectionSpec.COMPATIBLE_TLS,ConnectionSpec.CLEARTEXT));
            httpClient.addInterceptor(getHttpTokenInterceptor(token));
            if (BuildConfig.DEBUG) {
                httpClient.addInterceptor(getHttpLoggingInterceptor());
            }
            httpClient.cache(null);
            return httpClient.build();
        }else{
            return getHttpClient();
        }
    }

    //
    //
    // METODOS AUXILIARES
    //
    //

    private static Interceptor getHttpTokenInterceptor(final String token){
        return chain -> {
            Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token).build();
            return chain.proceed(request);
        };
    }

    private static ConnectionSpec getConnectionSpecModernTLS(){
        ConnectionSpec spec = new
            ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_2)
            .cipherSuites(
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
            .build();
        return spec;
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logInterceptor;
    }

    public static ObjectMapper getObjectMapperConfiguration() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }
}
