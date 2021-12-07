import java.util.*;
import greenfoot.*;

/**
 * El experimento es donde se configuran distintos espacios con distintos aforos.
 * 
 * Esta clase crea la poblacion (con una persona aleatoriamente infectada). 
 * 
 * @author Felipe I. Anfurrutia
 * @version Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public class Experimento5 extends World
{
    private static final int[] NUM_PERSONAS = {100, 200, 300};
    private static final Color[] COLOR_LINEAS = {Color.BLACK, Color.MAGENTA, Color.RED};
    private static final Color[] COLOR_FONDOS = {Color.WHITE, Color.GRAY, new  Color(243, 215, 170)};
  
    private Espacio[] espacios = new Espacio[3];

    /**
    * Inicializa la simulación: crea la población con una persona infectada.
    */
    public Experimento5()
    {
        super(1000, 650, 1);
        getBackground().setColor( new  Color(243, 215, 170));
        getBackground().fill();
        preparar();
    }


    /**
     * Preparar el mundo para realizar un experimento, es decir,
     * crear varios espacios iniciales con distintas poblaciones (una persona infectada)
     * y los añade al mundo
     */
    private void preparar()
    {
        /* Define varios espacios del mismo tamaño (según el tamaño del array NUM_PERSONAS) y 
         * los coloca distribuidos de forma vertical en el mundo (teniendo en cuenta el nu'mero de espacios).
         * El color de línea y color de fondo para cada espacio esta'n definidos en COLOR_LINEAS y COLOR_FONDOS.
         * Añade el número de personas indicadas por NUM_PERSONAS en cada espacio, 
         * con un porcentaje de 10% aisladas.
         * Una de las personas estará infectada */
        Graficador[] grafs = new Graficador[3];
        grafs[0] = new GraficadorBarra(null, COLOR_LINEAS[0], 2, 0.25);
        grafs[1] = new GraficadorColumna(null, COLOR_LINEAS[1], 0.25,2);
        grafs[2] = new GraficadorArea(null, COLOR_LINEAS[2], 0.25,2);
        
        for (int i=0; i<3; i++){
            espacios[i]=new Espacio (getWidth()/3, getHeight(), COLOR_LINEAS[i], COLOR_FONDOS[i], grafs[i]);
            grafs[i].setImage(espacios[i].getImagen());
            addObject(espacios[i], (2*i+1)*getWidth()/6, getHeight()/2);
            espacios[i].poblar(NUM_PERSONAS[i], 10);
            espacios[i].obtenerPersona().infectar();
        }
    }
    
}
