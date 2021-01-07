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
public class Familiar extends DecoradorHabitacion{
    boolean camasSupletorias;
    private static float extra = 20;
    
    public Familiar(Habitacion habitacion, boolean camasSupletorias){
        super(habitacion);
        this.camasSupletorias = camasSupletorias;
    }

    public static float getExtra() {
        return extra;
    }


    public static void setExtra(float extra) {
        Familiar.extra = extra;
    }
    
    
    @Override
    public float getPrecio() {
        if (camasSupletorias){
            return (float)(super.getPrecio() + getExtra());
        }
        
        return super.getPrecio();
    }
    
    @Override
    public void infoHabitacion(){
        super.infoHabitacion();
        System.out.println("Habitacion familiar");
        
        if (camasSupletorias){
            System.out.println("Tiene camas supletorias");
        }else{
            System.out.println("No tiene camas supletorias");
        }
    }
}
