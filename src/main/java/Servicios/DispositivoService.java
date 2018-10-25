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
  /*  public static Usuario obtenerUsuarioPorId(Long id)
    {
    return Session.getSession().find(Usuario.class,id);
    }

    public static Cliente obtenerClientePorId(Long id)
    {
    return Session.getSession().find(Cliente.class,id);
    }



    public static Usuario obtenerUsuario(String username,String password)
    {
    Usuario user = null;
    try{
    Query query = Session.getSession().createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nomUsuario and u.contrasenia = :pass");
    query.setParameter("nomUsuario", username);
    query.setParameter("pass",password);
    query.setMaxResults(1);
    user = (Usuario) query.getSingleResult();
    }
    catch(NoResultException e){
    e.toString();
    }
    return user;
    }

    public static List<DispositivoInteligente> obtenerDispositivosInteligentes(String username,String password)
    {
        Query query = Session.getSession().createQuery("SELECT c.dispositivosInteligentes FROM Cliente c WHERE c.nombreUsuario = :nomUsuario and c.contrasenia = :pass");
        query.setParameter("nomUsuario", username);
        query.setParameter("pass", password);
        List<DispositivoInteligente> dispInteligente =  query.getResultList();
        return dispInteligente;

    }


    public static List<DispositivoEstandar> obtenerDispositivosEstandar(String username,String password)
    {
        Query query = Session.getSession().createQuery("SELECT c.dispositivosEstandares FROM Cliente c WHERE c.nombreUsuario = :nomUsuario and c.contrasenia = :pass");
        query.setParameter("nomUsuario", username);
        query.setParameter("pass", password);
        List<DispositivoEstandar> dispEstandar =  query.getResultList();
        return dispEstandar;

    }*/

    //hogar = cliente
    public static List<DispositivoInteligente> obtenerTodosDispositivosInteligentes() {
       List<DispositivoInteligente> dispositivos = (List<DispositivoInteligente>) Session.getSession().createQuery("FROM DispositivoInteligente").getResultList();
       return dispositivos;
    }
    public static List<DispositivoEstandar> obtenerTodosDispositivosEstandars() {
        List<DispositivoEstandar> dispositivos = (List<DispositivoEstandar>) Session.getSession().createQuery("FROM DispositivoEstandar").getResultList();
        return dispositivos;
    }

}
	

	


