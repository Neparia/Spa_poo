/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balneario;

/**
 *
 * @author maxpi
 */
public abstract class DecoradorHabitacion extends Habitacion{
    private final Habitacion habitacion;
    
    public DecoradorHabitacion(Habitacion habitacion){
        super(0,0);
        this.habitacion = habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    @Override
    public int getNumero() {
        return habitacion.getNumero();
    }

    @Override
    public void setNumero(int numero) {
        habitacion.setNumero(numero);
    }

    @Override
    public float getPrecio() {
        return habitacion.getPrecio();
    }

    @Override
    public void setPrecio(float precio) {
        habitacion.setPrecio(precio);
    }
    
    @Override
    public void infoHabitacion(){
        habitacion.infoHabitacion();
    }
}
