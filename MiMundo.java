import java.util.*;
import greenfoot.*;

/**
 * El mundo es el espacio donde vive la gente.
 * 
 * Esta clase crea la población (con una persona aleatoriamente infectada). También dibuja el gráfico en el fondo del mundo.
 * 
 * @author Felipe I. Anfurrutia
 * @version 5 (Mayo 2021)
 */

public class MiMundo extends World
{
    private static final int NUM_PERSONAS = 200;
    private static final int PORCENTAJE_AISLADO = 20;
    private int maxInfectados = 0;
    private double desplazamientoX = 0;

    /**
     * Inicializa la simulación: crea la población con una persona infectada.
     */
    public MiMundo()
    {
        super(1000, 650, 1);
        getBackground().setColor( new  Color(243, 215, 170));
        getBackground().fill();
        getBackground().setColor(Color.BLACK);
        GraficadorLinea graf = new GraficadorLinea(null, Color.BLUE, 1,4);
        Espacio e1 = new Espacio (getWidth(), getHeight(),graf);
        this.addObject(e1, getWidth()/2, getHeight()/2);
        graf.setImage(e1.getImagen());
        e1.poblar(NUM_PERSONAS, PORCENTAJE_AISLADO);
        getObjects(Persona.class).get(0).infectar();
    }

    /**
     * Crea la población inicial, colocada aleatoriamente
     * @param numPersonas Número de personas del mundo
     * @param porcentajeAislados Porcentaje de aislados en el mundo
     */
    private void poblar(int numPersonas, float porcentajeAislados)
    {
        boolean aislado;
        int i = 0;
        while (i < NUM_PERSONAS) {
            
            if ((Greenfoot.getRandomNumber(100)+1) < porcentajeAislados*100){
                aislado=true;
            }
            else{
                aislado=false;
            }
            //instancia la persona
            Persona p = new Persona(aislado);
            addObject(p, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            i = i + 1;
            
            //instancia el niño si se cumple la condicion
            if(Greenfoot.getRandomNumber(100)+1 < 10){
                Nino nino = new Nino (aislado, p);
                addObject(nino, p.getX()+16, p.getY());
                i++;
            }
        
            //instancia el viejo si se cumple la condicion
            if(Greenfoot.getRandomNumber(100)+1 < 10){
                Viejo viejo = new Viejo (aislado);
                addObject(viejo, p.getX()+50, p.getY()+50);
                i++;
            }
        }
    }
}
