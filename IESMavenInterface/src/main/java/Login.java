

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceRef;
import webservice.Clientes;
import webservice.IESWebService_Service;

/**
 *
 * @author Renato
 */
@Named(value = "login")
@ManagedBean(name = "login")
@Dependent
public class Login {
    private Clientes c;
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/IES_WebService/IES_WebService.wsdl")
    private IESWebService_Service service;

    public Login() {
        this.c=null;
    }
    public String validateLogin(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        webservice.IESWebService port = service.getIESWebServicePort();
        
        System.out.println(mail);
        System.out.println(password);
        
        c = port.login(mail, password);
        if(c.getMail() != null){
            Data.setCliente(c);
            return "main";   
        }
        return "index";
    }

    public Clientes getC() {return c;}
    public void setC(Clientes c) {this.c = c;}
}
