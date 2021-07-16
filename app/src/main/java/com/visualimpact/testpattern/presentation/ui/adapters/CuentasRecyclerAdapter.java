package com.visualimpact.testpattern.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.visualimpact.testpattern.R;
import com.visualimpact.testpattern.domain.entities.CuentaModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CuentasRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private List<CuentaModel> cuentas;

    public CuentasRecyclerAdapter(Context context, List<CuentaModel> cuentas) {
        this.context = context;
        this.cuentas = cuentas;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recycler_cuenta, null, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder){
            ViewHolder h = (ViewHolder) holder;
            CuentaModel c = cuentas.get(position);
            h.idAplicacion.setText(String.valueOf(c.getIdAplicacion()));
            h.colorfondo.setText(c.getColorFondo());
            h.colorBoton.setText(c.getColorBoton());
            h.idProyecto.setText(String.valueOf(c.getIdProyecto()));
            h.cuenta.setText(c.getCuenta());
            h.color.setText(c.getColor());
        }
    }

    @Override
    public int getItemCount() {
        return cuentas.size();
    }

    //
    //
    // VIEW HOLDER
    //
    //

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView idAplicacion;
        private final TextView cuenta;
        private final TextView colorfondo;
        private final TextView colorBoton;
        private final TextView idProyecto;
        private final TextView color;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            idAplicacion = itemView.findViewById(R.id.id_aplicacion);
            cuenta = itemView.findViewById(R.id.cuenta);
            colorfondo = itemView.findViewById(R.id.color_fondo);
            colorBoton = itemView.findViewById(R.id.color_boton);
            idProyecto = itemView.findViewById(R.id.id_proyecto);
            color = itemView.findViewById(R.id.color);
        }
    }
}
