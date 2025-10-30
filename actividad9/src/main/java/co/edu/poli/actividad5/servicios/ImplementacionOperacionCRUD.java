package co.edu.poli.actividad5.servicios;

import co.edu.poli.actividad5.model.ActividadTuristica;

public class ImplementacionOperacionCRUD implements OperacionCRUD {

    private static ActividadTuristica[] storage = new ActividadTuristica[10];
    private static int initialSize = 10;

    @Override
    public boolean create(ActividadTuristica obj) {
        if (obj == null) return false;
        for (ActividadTuristica a : storage) {
            if (a != null && a.getIdActividad().equals(obj.getIdActividad())) {
                return false; // ya existe ese id
            }
        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = obj;
                return true;
            }
        }
        return false;
    }

    @Override
    public ActividadTuristica read(String id) {
        for (ActividadTuristica a : storage) {
            if (a != null && id.equals(a.getIdActividad())) {
                return a;
            }
        }
        return null;
    }

    @Override
    public boolean update(String id, ActividadTuristica obj) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && id.equals(storage[i].getIdActividad())) {
                storage[i] = obj;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && id.equals(storage[i].getIdActividad())) {
                storage[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public ActividadTuristica[] listAll() {
        return storage;
    }

    public static int getInitialSize() {
        return initialSize;
    }

    public static void setInitialSize(int initialSize) {
        ImplementacionOperacionCRUD.initialSize = initialSize;
    }
}
