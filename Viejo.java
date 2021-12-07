import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Un viejo en nuestra simulación. Un viejo puede estar sano, infectado o inmune.
 * 
 * @author Natalia Sebastian
 * 
 * @version 5 (Mayo 2021)
 */
public class Viejo extends Persona
{
    /**
     * Crea un viejo que podrá estar aislado o no..
     * @param aislado Indica si el viejo se encuentra aislado o no
     */
    public Viejo(boolean aislado){
        super(aislado);
    }
    
    /**
     * Moverse por los alrededores (ligeramente aleatoriamente).
     */
    protected void mover()
    {
        if(Greenfoot.getRandomNumber(100) < 10){
            move(1);
            if (isAtEdge()) {
                turn(90);
            }
            /* aleatoriamente gira un poco para realizar el movimiento menos uniforme*/
            if (Greenfoot.getRandomNumber(100) < 5) {
                turn(Greenfoot.getRandomNumber(40) - 20);
            }
        }
    }
      
}
