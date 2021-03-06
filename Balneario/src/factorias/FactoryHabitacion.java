package factorias;

import habitaciones.Doble;
import habitaciones.Familiar;
import habitaciones.Habitacion;
import java.util.Scanner;

/**
 * Se encarga del proceso de creación de Habitaciones
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class FactoryHabitacion implements Factoria<Habitacion>{ 
    
    @Override
    public Habitacion getInstancia(String numero){
        float precio = 0;
        boolean flag = true;
        byte respuesta = 0;
        
        System.out.println("Introduce el precio de la habitación (usar coma)");
        
        do{
            flag = true;
            try{
                Scanner sc = new Scanner(System.in);
                precio = sc.nextFloat();
                
                if (precio < 0){
                    System.out.println("El precio tiene que ser superior a 0");
                }else{
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("El valor introducido no es un numero");
            }
        }while(flag);
        
        Habitacion habit = new Habitacion(Integer.valueOf(numero), precio);
        
        System.out.println("Introduce el tipo de habitación:\n"
                + "1. Habitación individual\n"
                + "2. Habitación doble\n"
                + "3. Habitación familiar\n");
        flag = true;
        do{
            try{
                Scanner sc = new Scanner(System.in);
                respuesta = sc.nextByte();
                
                if ( (respuesta < 1) || (respuesta > 3)){
                    throw new Exception();
                }else{
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("\nPor favor, introduce una opción correcta\n");
            }
        }while(flag);
        
        switch (respuesta){
            case 2:
                String compartido = "";
                flag = true;
                
                System.out.println("\n¿El baño está compartido? (s/n): \n");
                do{
                    try{
                        Scanner sc = new Scanner(System.in);
                        compartido = sc.next("[ns]");
                        flag = false;
                    }catch(Exception e){
                        System.out.println("\nPor favor, introduce \"s\" o \"n\"\n");
                    }
                }while(flag);
                
                habit = new Doble(habit, (compartido.equals("s")));
                break;
            case 3:
                String camas = "";
                flag = true;
                
                System.out.println("\n¿Tiene camas supletorias? (s/n): \n");
                do{
                    try{
                        Scanner sc = new Scanner(System.in);
                        camas = sc.next("[ns]");
                        flag = false;
                    }catch(Exception e){
                        System.out.println("\nPor favor, introduce \"s\" o \"n\"\n");
                    }
                }while(flag);
                
                habit = new Familiar(habit, (camas.equals("s")));
                break;
        }
        
        return habit;
    }
}
