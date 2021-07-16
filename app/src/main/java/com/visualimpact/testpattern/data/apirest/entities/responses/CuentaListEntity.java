package com.visualimpact.testpattern.data.apirest.entities.responses;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.visualimpact.testpattern.data.apirest.entities.CuentaEntity;

import java.util.List;

@Keep
public class CuentaListEntity {

    @SerializedName("cuentas")
    @Expose
    private List<CuentaEntity> cuentas;

    public List<CuentaEntity> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaEntity> cuentas) {
        this.cuentas = cuentas;
    }
}
