package balneario;
import ahabitaciones.Habitacion;
import java.util.ArrayList;
import reservas.Reserva;
import reservas.Servicio;
/**
 *
 * @author maxpi
 */
public class Balneario {
    private static Balneario instancia;
    private final ArrayList<Habitacion> habitaciones= new ArrayList();
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    
    
    private Balneario(){}
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    
    public boolean cargarDatos(){
        System.out.println("Datos cargados");
        return true;
    }
    
    public boolean guardarDatos(){
        System.out.println("\nDatos guardados\n");
        return true;
    }
    
    public Habitacion buscarHabitacion(int numero){
        for (Habitacion h: habitaciones){
            if (h.getNumero() == numero){
                return h;
            }
        }
        return null;
    }
    
    
        //Getters y Setters
    
    public static Balneario getInstancia(){
        if(instancia == null){
            instancia = new Balneario();
        }
        
        return instancia;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }    
}
