package com.visualimpact.testpattern.data.apirest.mappers;

import com.visualimpact.testpattern.data.apirest.entities.CuentaEntity;
import com.visualimpact.testpattern.domain.entities.CuentaModel;

import java.util.ArrayList;
import java.util.List;

import static com.visualimpact.testpattern.domain.entities.CuentaModel.ColorCuenta.DEFAULT;
import static com.visualimpact.testpattern.domain.entities.CuentaModel.ColorCuenta.GRAY;
import static com.visualimpact.testpattern.domain.entities.CuentaModel.ColorCuenta.GREEN;
import static com.visualimpact.testpattern.domain.entities.CuentaModel.ColorCuenta.RED;
import static com.visualimpact.testpattern.domain.entities.CuentaModel.ColorCuenta.YELLOW;

public class CuentaMapper {

    public static CuentaModel mapFromEntity(CuentaEntity entity) {
        CuentaModel model = new CuentaModel();
        if(entity != null){
            model.setColorBoton(entity.getColorBoton() != null ? entity.getColorBoton() : "");
            model.setColorFondo(entity.getColorFondo() != null ? entity.getColorFondo() : "");
            model.setCuenta(entity.getCuenta() != null ? entity.getCuenta() : "");
            model.setIdAplicacion(entity.getIdAplicacion());
            model.setIdProyecto(entity.getIdProyecto());
            if(entity.getColorFondo().toLowerCase().equals("f20519")) model.setColor(RED.getColor());
            else if(entity.getColorFondo().toLowerCase().equals("f1b51c")) model.setColor(YELLOW.getColor());
            else if(entity.getColorFondo().toLowerCase().equals("737373")) model.setColor(GRAY.getColor());
            else if(entity.getColorFondo().toLowerCase().equals("78b833")) model.setColor(GREEN.getColor());
            else  model.setColor(DEFAULT.getColor());
        }
        return model;
    }

    public static List<CuentaModel> mapFromEntities(List<CuentaEntity> entities){
        List<CuentaModel> models = new ArrayList<>();
        if(entities != null){
            for (CuentaEntity entity: entities){
                CuentaModel model = mapFromEntity(entity);
                if(model != null){
                    models.add(model);
                }
            }
        }
        return models;
    }

    public static CuentaEntity mapToEntity(CuentaModel model) {
        CuentaEntity entity = new CuentaEntity();
        if(model != null){
            model.setIdProyecto(entity.getIdProyecto());
            model.setIdAplicacion(entity.getIdAplicacion());
            model.setCuenta(entity.getCuenta());
            model.setColorFondo(entity.getColorFondo());
            model.setColorBoton(entity.getColorBoton());
        }
        return entity;
    }

    public static List<CuentaEntity> mapToEntities(List<CuentaModel> models) {
        List<CuentaEntity> entities = new ArrayList<>();
        if(models != null){
            for (CuentaModel model: models){
                CuentaEntity entity = mapToEntity(model);
                if(entity != null){
                    entities.add(entity);
                }
            }
        }
        return entities;
    }
}
