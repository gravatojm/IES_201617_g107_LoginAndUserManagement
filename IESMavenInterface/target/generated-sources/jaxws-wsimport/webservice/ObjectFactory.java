
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Logout_QNAME = new QName("http://webservice/", "logout");
    private final static QName _LogoutToken_QNAME = new QName("http://webservice/", "logoutToken");
    private final static QName _RemoverClienteResponse_QNAME = new QName("http://webservice/", "removerClienteResponse");
    private final static QName _LogoutTokenResponse_QNAME = new QName("http://webservice/", "logoutTokenResponse");
    private final static QName _ValidateToken_QNAME = new QName("http://webservice/", "validateToken");
    private final static QName _Clientes_QNAME = new QName("http://webservice/", "clientes");
    private final static QName _CriarClienteResponse_QNAME = new QName("http://webservice/", "criarClienteResponse");
    private final static QName _EditarCliente_QNAME = new QName("http://webservice/", "editarCliente");
    private final static QName _LoginResponse_QNAME = new QName("http://webservice/", "loginResponse");
    private final static QName _LogoutResponse_QNAME = new QName("http://webservice/", "logoutResponse");
    private final static QName _ValidateTokenResponse_QNAME = new QName("http://webservice/", "validateTokenResponse");
    private final static QName _GetLog_QNAME = new QName("http://webservice/", "getLog");
    private final static QName _Logger_QNAME = new QName("http://webservice/", "logger");
    private final static QName _RemoverCliente_QNAME = new QName("http://webservice/", "removerCliente");
    private final static QName _ListaClientes_QNAME = new QName("http://webservice/", "listaClientes");
    private final static QName _EditarClienteResponse_QNAME = new QName("http://webservice/", "editarClienteResponse");
    private final static QName _GetLogResponse_QNAME = new QName("http://webservice/", "getLogResponse");
    private final static QName _Login_QNAME = new QName("http://webservice/", "login");
    private final static QName _CriarCliente_QNAME = new QName("http://webservice/", "criarCliente");
    private final static QName _ListaClientesResponse_QNAME = new QName("http://webservice/", "listaClientesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateTokenResponse }
     * 
     */
    public ValidateTokenResponse createValidateTokenResponse() {
        return new ValidateTokenResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link GetLog }
     * 
     */
    public GetLog createGetLog() {
        return new GetLog();
    }

    /**
     * Create an instance of {@link Logger }
     * 
     */
    public Logger createLogger() {
        return new Logger();
    }

    /**
     * Create an instance of {@link ListaClientes }
     * 
     */
    public ListaClientes createListaClientes() {
        return new ListaClientes();
    }

    /**
     * Create an instance of {@link RemoverCliente }
     * 
     */
    public RemoverCliente createRemoverCliente() {
        return new RemoverCliente();
    }

    /**
     * Create an instance of {@link GetLogResponse }
     * 
     */
    public GetLogResponse createGetLogResponse() {
        return new GetLogResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link CriarCliente }
     * 
     */
    public CriarCliente createCriarCliente() {
        return new CriarCliente();
    }

    /**
     * Create an instance of {@link ListaClientesResponse }
     * 
     */
    public ListaClientesResponse createListaClientesResponse() {
        return new ListaClientesResponse();
    }

    /**
     * Create an instance of {@link EditarClienteResponse }
     * 
     */
    public EditarClienteResponse createEditarClienteResponse() {
        return new EditarClienteResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutToken }
     * 
     */
    public LogoutToken createLogoutToken() {
        return new LogoutToken();
    }

    /**
     * Create an instance of {@link RemoverClienteResponse }
     * 
     */
    public RemoverClienteResponse createRemoverClienteResponse() {
        return new RemoverClienteResponse();
    }

    /**
     * Create an instance of {@link Clientes }
     * 
     */
    public Clientes createClientes() {
        return new Clientes();
    }

    /**
     * Create an instance of {@link CriarClienteResponse }
     * 
     */
    public CriarClienteResponse createCriarClienteResponse() {
        return new CriarClienteResponse();
    }

    /**
     * Create an instance of {@link EditarCliente }
     * 
     */
    public EditarCliente createEditarCliente() {
        return new EditarCliente();
    }

    /**
     * Create an instance of {@link LogoutTokenResponse }
     * 
     */
    public LogoutTokenResponse createLogoutTokenResponse() {
        return new LogoutTokenResponse();
    }

    /**
     * Create an instance of {@link ValidateToken }
     * 
     */
    public ValidateToken createValidateToken() {
        return new ValidateToken();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "logoutToken")
    public JAXBElement<LogoutToken> createLogoutToken(LogoutToken value) {
        return new JAXBElement<LogoutToken>(_LogoutToken_QNAME, LogoutToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "removerClienteResponse")
    public JAXBElement<RemoverClienteResponse> createRemoverClienteResponse(RemoverClienteResponse value) {
        return new JAXBElement<RemoverClienteResponse>(_RemoverClienteResponse_QNAME, RemoverClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "logoutTokenResponse")
    public JAXBElement<LogoutTokenResponse> createLogoutTokenResponse(LogoutTokenResponse value) {
        return new JAXBElement<LogoutTokenResponse>(_LogoutTokenResponse_QNAME, LogoutTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "validateToken")
    public JAXBElement<ValidateToken> createValidateToken(ValidateToken value) {
        return new JAXBElement<ValidateToken>(_ValidateToken_QNAME, ValidateToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "clientes")
    public JAXBElement<Clientes> createClientes(Clientes value) {
        return new JAXBElement<Clientes>(_Clientes_QNAME, Clientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "criarClienteResponse")
    public JAXBElement<CriarClienteResponse> createCriarClienteResponse(CriarClienteResponse value) {
        return new JAXBElement<CriarClienteResponse>(_CriarClienteResponse_QNAME, CriarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "editarCliente")
    public JAXBElement<EditarCliente> createEditarCliente(EditarCliente value) {
        return new JAXBElement<EditarCliente>(_EditarCliente_QNAME, EditarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "validateTokenResponse")
    public JAXBElement<ValidateTokenResponse> createValidateTokenResponse(ValidateTokenResponse value) {
        return new JAXBElement<ValidateTokenResponse>(_ValidateTokenResponse_QNAME, ValidateTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLog")
    public JAXBElement<GetLog> createGetLog(GetLog value) {
        return new JAXBElement<GetLog>(_GetLog_QNAME, GetLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "logger")
    public JAXBElement<Logger> createLogger(Logger value) {
        return new JAXBElement<Logger>(_Logger_QNAME, Logger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "removerCliente")
    public JAXBElement<RemoverCliente> createRemoverCliente(RemoverCliente value) {
        return new JAXBElement<RemoverCliente>(_RemoverCliente_QNAME, RemoverCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaClientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "listaClientes")
    public JAXBElement<ListaClientes> createListaClientes(ListaClientes value) {
        return new JAXBElement<ListaClientes>(_ListaClientes_QNAME, ListaClientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "editarClienteResponse")
    public JAXBElement<EditarClienteResponse> createEditarClienteResponse(EditarClienteResponse value) {
        return new JAXBElement<EditarClienteResponse>(_EditarClienteResponse_QNAME, EditarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLogResponse")
    public JAXBElement<GetLogResponse> createGetLogResponse(GetLogResponse value) {
        return new JAXBElement<GetLogResponse>(_GetLogResponse_QNAME, GetLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "criarCliente")
    public JAXBElement<CriarCliente> createCriarCliente(CriarCliente value) {
        return new JAXBElement<CriarCliente>(_CriarCliente_QNAME, CriarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "listaClientesResponse")
    public JAXBElement<ListaClientesResponse> createListaClientesResponse(ListaClientesResponse value) {
        return new JAXBElement<ListaClientesResponse>(_ListaClientesResponse_QNAME, ListaClientesResponse.class, null, value);
    }

}
