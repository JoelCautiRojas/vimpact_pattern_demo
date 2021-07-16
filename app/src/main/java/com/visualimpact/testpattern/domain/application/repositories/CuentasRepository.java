package com.visualimpact.testpattern.domain.application.repositories;

import com.visualimpact.testpattern.domain.entities.CuentaModel;

import java.util.List;

public interface CuentasRepository {

    List<CuentaModel> getCuentas(Callback callback);

    interface Callback{

        void successGetCuentas(List<CuentaModel> list);
        void errorRequest(int errorCode, String method);
        void unauthorized(String method);
    }
}
