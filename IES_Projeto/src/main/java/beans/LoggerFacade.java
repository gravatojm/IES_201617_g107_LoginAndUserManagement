/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidade.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jgravato
 */
@Stateless
public class LoggerFacade extends AbstractFacade<Logger> {

    @PersistenceContext(unitName = "pt.ua.ies_IES_Projeto_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoggerFacade() {
        super(Logger.class);
    }
    
}
