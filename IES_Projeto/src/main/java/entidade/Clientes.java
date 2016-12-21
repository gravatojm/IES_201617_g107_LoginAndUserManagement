/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgravato
 */
@Entity
@Table(name = "Clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByClienteid", query = "SELECT c FROM Clientes c WHERE c.clienteid = :clienteid"),
    @NamedQuery(name = "Clientes.findByNome", query = "SELECT c FROM Clientes c WHERE c.nome = :nome"),
    @NamedQuery(name = "Clientes.findByMail", query = "SELECT c FROM Clientes c WHERE c.mail = :mail"),
    @NamedQuery(name = "Clientes.findByPassword", query = "SELECT c FROM Clientes c WHERE c.password = :password"),
    @NamedQuery(name = "Clientes.findByTipo", query = "SELECT c FROM Clientes c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Clientes.validadeLogin", query = "SELECT c FROM Clientes c WHERE c.mail = :mail AND c.password = :password")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteid")
    private int clienteid;
    @Size(max = 20)
    @Column(name = "nome")
    private String nome;
    @Size(max = 20)
    @Column(name = "mail", unique = true)
    private String mail;
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    @Column(name = "tipo")
    private Integer tipo;
    @Column(name = "token", unique = true)
    private String token;
    @Column(name = "grupo")
    private String grupo;

    public Clientes() {
    }

    public Clientes(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getClienteid() {
        return clienteid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public String getGrupo() {
        return grupo;
    }
    
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void createToken() {
        String alfb = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rand = new SecureRandom();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(alfb.charAt(rand.nextInt(alfb.length())));
        }
        String randomStr = sb.toString();
        try {
            String login = getMail() + getPassword() + randomStr;
            MessageDigest md = MessageDigest.getInstance("SHA");
            byte[] byteData = md.digest(login.getBytes());
            // return Base64.getEncoder().encodeToString(byteData);
            token = DatatypeConverter.printBase64Binary(byteData);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroyToken() {
        this.token = null;
    }

    @Override
    public String toString() {
        return "entidade.Clientes[ clienteid=" + clienteid + " ]";
    }

}
