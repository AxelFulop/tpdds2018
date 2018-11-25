package Servicios;

import modelo.*;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DispositivoService extends Model {

    public static void eliminar(Dispositivo dispositivo) {
        try {
            Session.beginTransaction();
            Session.getSession().remove(dispositivo);
            Session.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }

    public static void persistir(Dispositivo dispositivo) {
        try {
            Session.beginTransaction();
            Session.getSession().persist(dispositivo);
            Session.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }


    public static void actualizar(Dispositivo dispositivo) {
        try {
            Session.beginTransaction();
            Session.getSession().merge(dispositivo); //TODO: Quitar esto
            Session.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }

    public static List<DispositivoInteligente> obtenerTodosDispositivosInteligentes() {
       List<DispositivoInteligente> dispositivos = (List<DispositivoInteligente>) Session.getSession().createQuery("FROM DispositivoInteligente").getResultList();
       return dispositivos;
    }
    public static List<DispositivoEstandar> obtenerTodosDispositivosEstandars() {
        List<DispositivoEstandar> dispositivos = (List<DispositivoEstandar>) Session.getSession().createQuery("FROM DispositivoEstandar").getResultList();
        return dispositivos;
    }

}