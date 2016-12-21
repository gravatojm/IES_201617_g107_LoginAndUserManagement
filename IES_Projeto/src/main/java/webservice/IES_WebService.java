/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import beans.ClientesFacade;
import beans.LoggerFacade;
import entidade.Clientes;
import entidade.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import rabbitmq.ClientRMQ;

/**
 *
 * @author jgravato
 */
@WebService(serviceName = "IES_WebService")
@Stateless()
public class IES_WebService {

    @EJB
    private ClientesFacade ejbRef;
    @EJB
    private LoggerFacade logRef;
    
    private ClientRMQ rabbitMQ = new ClientRMQ();;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "criarCliente")
    public boolean criarCliente(
            @WebParam(name = "mail") String mail,
            @WebParam(name = "password") String password,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "tipo") int tipo,
            @WebParam(name = "grupo") String grupo) {

        Logger logger = new Logger();
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        logger.setData(dateFormat.format(new Date()));
        logger.setEventstatus("criar");
        logger.setUsermail(mail);

        Clientes cliente = new Clientes();

        if (!ejbRef.registExists(mail)) {
            cliente.setMail(mail);
            cliente.setNome(nome);
            cliente.setPassword(password);
            cliente.setTipo(tipo);
            cliente.setGrupo(grupo);
            //cliente.createToken();
            ejbRef.create(cliente);
            logger.setSuccess("yes");
            logRef.create(logger);
            
            rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
            
            return true;
        }
        logger.setSuccess("no");
        logRef.create(logger);
        
        rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
        
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public Clientes login(@WebParam(name = "mail") String mail,
            @WebParam(name = "password") String password) {
        Logger logger = new Logger();
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        logger.setData(dateFormat.format(new Date()));
        logger.setEventstatus("login");
        logger.setUsermail(mail);

        Clientes result = ejbRef.validateLogin(mail, password);

        if (result.getMail() != null) {
            logger.setSuccess("yes");
            logRef.create(logger);
            
            rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());

            return result;
        }

        logger.setSuccess("no");
        logRef.create(logger);
        
        rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaClientes")
    public List listaClientes() {
        return ejbRef.findAll();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "removerCliente")
    public boolean removerCliente(@WebParam(name = "mail") String mail,
            @WebParam(name = "password") String password,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "tipo") int tipo) {

        Logger logger = new Logger();
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        logger.setData(dateFormat.format(new Date()));
        logger.setEventstatus("remover");
        logger.setUsermail(mail);

        Clientes cliente = new Clientes();
        if (ejbRef.registExists(mail)) {
            cliente = ejbRef.getCliente(mail);
            ejbRef.remove(cliente);
        }
        if (!ejbRef.registExists(mail)) {
            logger.setSuccess("yes");
            logRef.create(logger);
            
            rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
            
            return true;
        }
        logger.setSuccess("false");
        logRef.create(logger);
        
        rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
        
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validateToken")
    public Clientes validateToken(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:     
        Logger logger = new Logger();
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        logger.setData(dateFormat.format(new Date()));
        logger.setEventstatus("login");
        logger.setUsermail(token);

        Clientes result = ejbRef.validateToken(token);

        if (result.getMail() != null) {
            logger.setSuccess("yes");
            logRef.create(logger);
            
            rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
            
            return result;
        }
        logger.setSuccess("no");
        logRef.create(logger);
        
        rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editarCliente")
    public boolean editarCliente(@WebParam(name = "mail") String mail,
            @WebParam(name = "password") String password,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "tipo") int tipo) {

        Logger logger = new Logger();
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        logger.setData(dateFormat.format(new Date()));
        logger.setEventstatus("editar");
        logger.setUsermail(mail);

        Clientes cliente = new Clientes();
        if (ejbRef.registExists(mail)) {
            cliente = ejbRef.getCliente(mail);
            cliente.setNome(nome);
            cliente.setPassword(password);
            cliente.setTipo(tipo);
            ejbRef.edit(cliente);

            logger.setSuccess("yes");
            logRef.create(logger);
            
            rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());

            return true;
        }

        logger.setSuccess("no");
        logRef.create(logger);
        
        rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());

        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "logout")
    public boolean logout(@WebParam(name = "mail") String mail, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:

        Logger logger = new Logger();
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        logger.setData(dateFormat.format(new Date()));
        logger.setEventstatus("logout");
        logger.setUsermail(mail);

        boolean result = ejbRef.validateLogout(mail, password);

        if (result) {
            logger.setSuccess("yes");
            logRef.create(logger);
            
            rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
            
            return result;
        }
        logRef.create(logger);
        logger.setSuccess("no");
        
        rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
        
        return result;
    }

    @WebMethod(operationName = "logoutToken")
    public boolean logoutToken(@WebParam(name = "token") String token) {

        Logger logger = new Logger();
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        logger.setData(dateFormat.format(new Date()));
        logger.setEventstatus("logout");

        Clientes cliente = ejbRef.validateToken(token);
        if (cliente.getMail() != null) {
            logger.setUsermail(cliente.getMail());
        } else {
            logger.setUsermail("N/D");
        }

        boolean result = ejbRef.validateLogout(token);

        if (result) {
            logger.setSuccess("yes");
            logRef.create(logger);
            
            rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
            
            return result;
        }
        logger.setSuccess("no");
        logRef.create(logger);
        
        rabbitMQ.sendMessage(logger.getData() + " | " + logger.getEventstatus() + " | " + logger.getUsermail() + " | " + logger.getSuccess());
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLog")
    public List<Logger> getLog(@WebParam(name = "password") String password) {
        if(password.equals("password")) {
            return logRef.findAll();
        }
        return null;
    }

}
