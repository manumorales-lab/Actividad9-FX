package co.edu.poli.actividad5.servicios;

import co.edu.poli.actividad5.model.ActividadTuristica;

public interface OperacionCRUD {
    boolean create(ActividadTuristica obj);
    ActividadTuristica read(String id);
    boolean update(String id, ActividadTuristica obj);
    boolean delete(String id);
    ActividadTuristica[] listAll();
}
