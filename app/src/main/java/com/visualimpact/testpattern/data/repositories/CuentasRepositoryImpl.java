package com.visualimpact.testpattern.data.repositories;

import com.visualimpact.testpattern.data.apirest.entities.responses.CuentaListEntity;
import com.visualimpact.testpattern.data.apirest.framework.CuentasServiceImpl;
import com.visualimpact.testpattern.domain.application.repositories.CuentasRepository;
import com.visualimpact.testpattern.domain.entities.CuentaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static com.visualimpact.testpattern.data.apirest.mappers.CuentaMapper.mapFromEntities;

public class CuentasRepositoryImpl implements CuentasRepository {

    public List<CuentaModel> getCuentas(Callback callback){
        final String method = "getCuentas";
        CuentasServiceImpl.getApiService("jackson").getAllCuentas().enqueue(new retrofit2.Callback<CuentaListEntity>() {
            @Override
            public void onResponse(Call<CuentaListEntity> call, Response<CuentaListEntity> response) {
                switch (response.code()){
                    case 200:
                    case 201:
                        if(response.body() != null){
                            CuentaListEntity listEntity = response.body();
                            callback.successGetCuentas(mapFromEntities(listEntity.getCuentas()));
                        }else{
                            callback.errorRequest(3,method);
                        }
                        break;
                    case 401:
                        callback.unauthorized(method);
                        break;
                    case 500:
                        callback.errorRequest(2,method);
                        break;
                    default:
                        callback.errorRequest(1,method);
                        break;
                }
            }

            @Override
            public void onFailure(Call<CuentaListEntity> call, Throwable t) {
                callback.errorRequest(0,method);
            }
        });
        return null;
    }
}
