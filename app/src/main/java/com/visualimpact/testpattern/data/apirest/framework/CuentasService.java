package com.visualimpact.testpattern.data.apirest.framework;

import com.visualimpact.testpattern.BuildConfig;
import com.visualimpact.testpattern.data.apirest.entities.responses.CuentaListEntity;

import retrofit2.Call;
import retrofit2.http.POST;

public interface CuentasService {

    @POST(BuildConfig.VALIDAR_CUENTA)
    Call<CuentaListEntity> getAllCuentas();
}
