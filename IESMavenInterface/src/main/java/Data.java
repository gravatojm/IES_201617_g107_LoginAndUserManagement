

import webservice.Clientes;
/**
 *
 * @author Renato
 */
public class Data {
    private static Clientes cliente;

    public static Clientes getCliente() {return cliente;}
    public static void setCliente(Clientes cliente) {Data.cliente = cliente;}
}
