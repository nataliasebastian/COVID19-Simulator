import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Un niño en nuestra simulación. Un niño puede estar sano, infectado o inmune.
 * 
 * @author Natalia Sebastian
 * 
 * @version 5 (Mayo 2021)
 */
public class Nino extends Persona
{
    private Persona madre;
    
    /**
     * Crea un niño que podrá estar aislado o no, y se relacionará con su madre.
     * @param aislado Indica si el niño se encuentra aislado o no
     * @param madre La madre del niño
     */
    public Nino(boolean aislado, Persona madre)
    {
        super(aislado);
        this.madre=madre;
    }
    
    /**
     * Cambia la imagen asignada al niño.
     * @param imagen Nombre de la imagen que se le quiere asignar. 
     */
    protected void cambiarImagen(String imagen){
        setImage("n_" + imagen);
    }
    
    /**
     * Se mueve con su madre
     */
    protected void mover()
    {
        turnTowards(madre.getX()+16, madre.getY());
        move(1);
        
    }
}
