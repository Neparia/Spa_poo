package factorias;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import clientes.Cliente;

/**
 * Se encarga del proceso de creación de Clientes
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class FactoryCliente implements Factoria<Cliente>{
    
    @Override
    public Cliente getInstancia(String idCliente){
        String nombreApellidos = " ";
        String telefonoMovil = " ";
        boolean flag = true;
        BufferedReader br;

        
        System.out.println("Introduce el nombre y apellidos del cliente:\n");             
        do {
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                nombreApellidos = br.readLine();
                
                flag = false;
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error de lectura. Vuelve a intentarlo.\n");
            }
        } while (flag);     
        
        System.out.println("Introduce el número de teléfono móvil del cliente:\n");             
        do {
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                telefonoMovil = br.readLine();
                
                flag = false;
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error de lectura. Vuelve a intentarlo.\n");
                
                flag = true;
            }

            //Validación teléfono móvil
            flag = !Cliente.validaMovil(telefonoMovil);
            if (flag) {
                System.out.println("Formato incorrecto. El número de móvil debe tener 9 cifras.\n");
            }
            
        } while (flag);
        
        Cliente cliente = new Cliente(idCliente, nombreApellidos, telefonoMovil);
        
        return cliente;
    }
}
