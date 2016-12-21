/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.xml.ws.WebServiceRef;
import webservice.IESWebService_Service;

/**
 *
 * @author Renato
 */
@Named(value = "logout")
@Dependent
public class logOut {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/IES_WebService/IES_WebService.wsdl")
    private IESWebService_Service service;

    public logOut() {
    }
    
    public String out(){
        webservice.IESWebService port = service.getIESWebServicePort();
        port.logoutToken(Data.getCliente().getToken());
        //Data.setCliente(null);
        return "index";
    }
}
