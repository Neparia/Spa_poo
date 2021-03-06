package menus;

import factorias.FactoryServicio;
import servicios.Servicio;

/**
 * Permite al usuario acceder a las funciones que actúan sobre los servicios.
 * @author Gustavo Cortés Jiménez
 * @author Rodrigo Lázaro Escudero
 */
public class MenuServicios extends Menu{
  
    public MenuServicios(){
        super("1. Listado de todos los servicios\n"
                    + "2. Información de un servicio\n"
                    + "3. Añadir un servicio\n"
                    + "4. Eliminar un servicio\n"
                    + "5. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 5);
        
    }
    
    /**
     * Muestra los datos de todos los servicios guardados
     */
    private void listaServicios() {
        if(getBalneario().getServicios().isEmpty()){
            System.out.println("\nNo hay servicios registrados.\n");
        }else{  
            for(Servicio s: getBalneario().getServicios()){
                System.out.println(s.infoServicio());
            }
        }
    }
    
    /**
     * Muestra los datos de un servicio
     * @param codigo El codigo del servicio que mostrar
     */
    private void listaServicios(int codigo) { 
        Servicio s = getBalneario().buscarServicio(codigo);
        if (s != null){
            System.out.println(s.infoServicio());
            return;
        }        
        System.out.println("No existe ningún servicio con el código indicado.\n");
    }
    
    /**
     * Crea y añade un nuevo servicio al sistema.
     */
    private void agregarServicio(){
        int idServicio = Servicio.codigoMax++;
        FactoryServicio fs = new FactoryServicio();
          
        getBalneario().getServicios().add(fs.getInstancia(Integer.toString(idServicio)));
        System.out.println("Servicio añadido.\n");

    }
    
    /**
     * Elimina un servicio almacenado en el sistema
     * @param id el código del servicio que eliminar
     */
    private void eliminarServicio(int id){
        //Se pueden borrar servicios y habitaciones sin comprometer la integridad estructural, ya que
        //sólo se eliminan las referencias, no los objetos. Éstos quedan vinculados a las reservas y/o
        //a las facturas, manteniendo así el registro histórico y evitando null point exceptions.
        Servicio s = getBalneario().buscarServicio(id);
        if (s != null){
            getBalneario().getServicios().remove(s);
            return;
        }        
        System.out.println("No existe ningún servicio con el código indicado.\n");
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaServicios();
                break;
            case 2:
                listaServicios(Servicio.pedirId());
                break;
            case 3:
                agregarServicio();
                break;
            case 4:
                eliminarServicio(Servicio.pedirId());
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
