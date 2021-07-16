package com.visualimpact.testpattern.domain.application.usescase;

import com.visualimpact.testpattern.data.repositories.CuentasRepositoryImpl;
import com.visualimpact.testpattern.domain.application.repositories.CuentasRepository;
import com.visualimpact.testpattern.domain.entities.CuentaModel;

import java.util.List;

public class CuentasUsesCaseImpl implements CuentasUsesCase, CuentasRepository.Callback {

    private CuentasRepository cuentasRepository;
    private Callback callback;

    public CuentasUsesCaseImpl() {
        this.cuentasRepository = new CuentasRepositoryImpl();
    }

    @Override
    public void getCuentas(Callback callback) {
        this.callback = callback;
        cuentasRepository.getCuentas(CuentasUsesCaseImpl.this);
    }

    //
    //
    // CALLBACKS
    //
    //

    @Override
    public void successGetCuentas(List<CuentaModel> list) {
        callback.successGetCuentas(list);
    }

    @Override
    public void errorRequest(int errorCode, String method) {

    }

    @Override
    public void unauthorized(String method) {

    }
}
