package com.visualimpact.testpattern.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.visualimpact.testpattern.domain.application.usescase.CuentasUsesCase;
import com.visualimpact.testpattern.domain.application.usescase.CuentasUsesCaseImpl;
import com.visualimpact.testpattern.domain.entities.CuentaModel;

import java.util.List;

public class MainViewModel extends ViewModel{

    private MutableLiveData<String> estado;
    private MutableLiveData<List<CuentaModel>> cuentas;
    private CuentasUsesCase cuentasUsesCase;

    public MainViewModel() {
        cuentasUsesCase = new CuentasUsesCaseImpl();
    }

    public LiveData<String> getEstado() {
        if(estado == null){
            estado = new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<List<CuentaModel>> getCuentas(){
        if (cuentas == null){
            cuentas = new MutableLiveData<>();
            loadCuentas();
        }
        return cuentas;
    }

    public String getEstadoValue(){
        return estado.getValue();
    }

    public void setEstado(String cadena) {
        if(estado == null){
            estado = new MutableLiveData<>();
        }
        this.estado.setValue(cadena);
    }

    //
    //
    // CASOS DE USO
    //
    //

    public void loadCuentas(){
        cuentasUsesCase.getCuentas(list -> cuentas.setValue(list));
    }
}
