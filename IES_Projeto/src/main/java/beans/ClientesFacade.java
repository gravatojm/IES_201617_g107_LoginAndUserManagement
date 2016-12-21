/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidade.Clientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jgravato
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "pt.ua.ies_IES_Projeto_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    public Clientes validateLogin(String mail, String password) {
        if (registExists(mail)) {
            try {
                TypedQuery<Clientes> query = getEntityManager().createQuery("SELECT c FROM Clientes c WHERE c.mail = :mail AND c.password = :password", Clientes.class);
                Clientes cliente = query.setParameter("mail", mail).setParameter("password", password).getSingleResult();
                cliente.createToken();
                super.edit(cliente);
                return cliente;
            } catch (NoResultException ex) {
                return new Clientes();
            }
        }
        return new Clientes();
    }

    public boolean validateLogout(String mail, String password) {
        try {
            TypedQuery<Clientes> query = getEntityManager().createQuery("SELECT c FROM Clientes c WHERE c.mail = :mail AND c.password = :password", Clientes.class);
            Clientes cliente = query.setParameter("mail", mail).setParameter("password", password).getSingleResult();
            cliente.destroyToken();
            super.edit(cliente);
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    }

    public boolean validateLogout(String token) {
        try {
            TypedQuery<Clientes> query = getEntityManager().createQuery("SELECT c FROM Clientes c WHERE c.token = :token", Clientes.class);
            Clientes cliente = query.setParameter("token", token).getSingleResult();
            cliente.destroyToken();
            super.edit(cliente);
            return true;
        } catch (NoResultException ex) {
            return false;
        }

    }

    public Clientes validateToken(String token) {
        try {
            TypedQuery<Clientes> query = getEntityManager().createQuery("SELECT c FROM Clientes c WHERE c.token = :token", Clientes.class);
            Clientes cliente = query.setParameter("token", token).getSingleResult();
            //return query.setParameter("token", token).getSingleResult() != null;
            return cliente;
        } catch (NoResultException ex) {
            return new Clientes();
        }
    }

    public boolean registExists(String mail) {
        TypedQuery<Clientes> query = getEntityManager().createQuery("SELECT c FROM Clientes c WHERE c.mail = :mail", Clientes.class);
        boolean resp;
        try {
            resp = query.setParameter("mail", mail).getSingleResult() != null;
        } catch (NoResultException ex) {
            return false;
        }
        return true;
    }

    public Clientes getCliente(String mail) {
        TypedQuery<Clientes> query = getEntityManager().createQuery("SELECT c FROM Clientes c WHERE c.mail = :mail", Clientes.class);
        return query.setParameter("mail", mail).getSingleResult();
    }

}
