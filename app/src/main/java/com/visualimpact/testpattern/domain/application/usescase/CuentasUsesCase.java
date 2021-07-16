package com.visualimpact.testpattern.domain.application.usescase;

import com.visualimpact.testpattern.domain.entities.CuentaModel;

import java.util.List;

public interface CuentasUsesCase {

    void getCuentas(Callback callback);

    interface Callback{

        void successGetCuentas(List<CuentaModel> cuentas);
    }
}
