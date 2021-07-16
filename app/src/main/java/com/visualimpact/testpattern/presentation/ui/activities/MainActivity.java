package com.visualimpact.testpattern.presentation.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.visualimpact.testpattern.databinding.ActivityMainBinding;
import com.visualimpact.testpattern.presentation.ui.adapters.CuentasRecyclerAdapter;
import com.visualimpact.testpattern.presentation.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements BaseActivity{

    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private CuentasRecyclerAdapter adapter;

    //
    //
    // BASE
    //
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getExtras();
        getSession();
        initViewModel();
        bindUI();
        initUI();
        initEvents();
    }

    @Override
    public void getExtras() {

    }

    @Override
    public void getSession() {

    }

    @Override
    public void initViewModel() {
        viewModel = new ViewModelProvider(MainActivity.this).get(MainViewModel.class);
    }

    @Override
    public void bindUI() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setMainViewModel(viewModel);
        setContentView(binding.getRoot());
    }

    @Override
    public void initUI() {
        binding.cuentas.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.estado.setText("Cargando...");
        viewModel.getCuentas().observe(MainActivity.this, list -> {
            binding.estado.setText("Completado");
            if(list != null){
                adapter = new CuentasRecyclerAdapter(MainActivity.this, list);
                binding.cuentas.setAdapter(adapter);
            }
        });
    }

    @Override
    public void initEvents() {

    }
}