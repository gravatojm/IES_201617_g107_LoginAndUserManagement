/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
@Named(value="edit")
@Dependent
@ManagedBean
public class Edit {

    public Edit(){
        Clientes c = Data.getCliente();
        this.mail = c.getMail();
        this.pass = c.getPassword();
        this.group = c.getGrupo();
        this.token = c.getToken();
        this.type = c.getTipo();
        this.nome = c.getNome();
    }
        private String mail;
        private String pass;
        private String group;
        private String token;
        private int type;
        private String nome;
        private Login login;
        
        
        
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/IES_WebService/IES_WebService.wsdl")
    private IESWebService_Service service;
        
    public String editUser(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String newpassword = request.getParameter("password");
        String newname = request.getParameter("nome");
        int newtype = Integer.parseInt(request.getParameter("type"));
        webservice.IESWebService port = service.getIESWebServicePort();
        boolean success = port.editarCliente(getMail(), newpassword, newname, newtype);
        if(success){
            this.pass = newpassword;
            this.type = newtype;
            this.nome = newname;
        }
        else{
            System.out.println("ERRO!");
        }
        return "main";
    }

    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}
    public String getPass() {return pass;}
    public void setPass(String pass) {this.pass = pass;}
    public String getGroup() {return group;}
    public void setGroup(String group) {this.group = group;}
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}
    public int getType() {return type;}
    public void setType(int type) {this.type = type;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}   
    public Login getLogin() {return login;}
    public void setLogin(Login login) {this.login = login;}
}
