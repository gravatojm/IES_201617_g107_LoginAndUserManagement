/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceRef;
import webservice.IESWebService_Service;

/**
 *
 * @author Renato
 */
@Named(value = "register")
@Dependent
public class register {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/IES_WebService/IES_WebService.wsdl")
    private IESWebService_Service service;
    public register() {
    }
    public String registerUser(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String name = request.getParameter("nome");
        int type = Integer.parseInt(request.getParameter("type"));
        String group = request.getParameter("group");
        
        System.out.println(mail);
        System.out.println(password);
        System.out.println(name);
        System.out.println(type);
        System.out.println(group);
        
        webservice.IESWebService port = service.getIESWebServicePort();
        boolean success = port.criarCliente(mail, password, name, type, group);
        if(success)
            return "index";
        return "register";
    }
}
