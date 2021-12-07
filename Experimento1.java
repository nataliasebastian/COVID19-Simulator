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
public class Experimento1 extends World
{
    private static final int NUM_PERSONAS = 200;
    
    private Espacio espacio;


    /**
     * Inicializa la simulación: crea la población con una persona infectada.
     */
    public Experimento1()
    {
        super(1000, 650, 1);
        getBackground().setColor(new  Color(243, 215, 170));
        getBackground().fill();
        preparar();
    }


    /**
     * Prepara el mundo para realizar un experimento, es decir,
     * crea la población del espacio con varias personas (una infectada)
     * y lo añade al mundo
     */
    private void preparar()
    {
	// Define un espacio del mismo tamaño que el mundo y lo añade en la mitad
	Espacio e = new Espacio (getWidth(), getHeight());
	addObject(e, getWidth()/2, getHeight()/2);
	e.getGraficador().setImage(e.getImagen());
	
	/* Añade al espacio el número de personas indicadas por NUM_PERSONAS, 
	con un porcentaje de 10% aisladas. */
	e.poblar(NUM_PERSONAS, 10);
	
	// Una de las personas estará infectada  
	e.obtenerPersona().infectar();
    }
}
