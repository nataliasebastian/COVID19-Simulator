import java.util.*;
import greenfoot.*;

/**
 * Una persona en nuestra simulación. Una persona puede estar sana, infectada o inmune.
 * 
 * @author Michael Kölling
 * @author Felipe I. Anfurrutia
 * @author Natalia Sebastian
 * 
 * @version 5 (Mayo 2021)
 */
public class Persona extends Actor
{
    private static final int TIEMPO_INFECCION = 500;
    
    private EstadoInfeccion estado=EstadoInfeccion.SUSCEPTIBLE;
    private int infeccion = 0;
    private boolean aislada;
    private Espacio espacio;

    /**
     * Crea una persona, inicialmente sana.
     * @param aislada Indica si la persona se encuentra aislada o no
     */
    public Persona(boolean aislada)
    {
        turn(Greenfoot.getRandomNumber(360));
        this.aislada=aislada;
    }

    /**
     * Va acerca de nuestra vida: moverse por los alrededores, ver lo que pasa.
     */
    public void act()
    {
        if (!aislada){
            mover();
        }
        if (estaInfectada()) {
            infectarOtros();
            curar();
        }
    }

    /**
     * Moverse por los alrededores (ligeramente aleatoriamente).
     */
    protected void mover()
    {
        
        if (isAtEdge()) {
            turn(90);
        }
        move(1);
        
        /* aleatoriamente gira un poco para realizar el movimiento menos uniforme*/
        if (Greenfoot.getRandomNumber(100) < 5) {
            turn(Greenfoot.getRandomNumber(40) - 20);
        }
        
    }

    /**
     * Si estamos tocando a alguna otra persona, se infecta. Si no, no hacer nada.
     */
    private void infectarOtros()
    {
        Persona otra = (Persona)getOneIntersectingObject(Persona.class);
        
        if (otra != null) {
            otra.infectar();
        }
    }

    /**
     * Intentar infectar a esta persona. Si esta persona no es inmune, sera' infectada.
     */
    public void infectar()
    {
        if (estado == EstadoInfeccion.SUSCEPTIBLE) {
            infeccion = TIEMPO_INFECCION;
            cambiarEstado(EstadoInfeccion.INFECTADA);
            /* una vez infectado, no puede volver a infectarse otra vez*/
        }
    }

    /**
     * Curarse segu'n pasa el tiempo. Si la infección se ha terminado, ahora somos inmunes.
     */
    private void curar()
    {
        infeccion = infeccion - 1;
        if (infeccion == 0) {
            cambiarEstado(EstadoInfeccion.INMUNE);
        }
        
    }

    /**
     * Devuelve verdadero si  la persona está infectada y falso, en caso contrario.
     * @return Verdadero si  la persona está infectada y falso en caso contrario
     */
    public boolean estaInfectada()
    {
        return estado == EstadoInfeccion.INFECTADA;

    }
    
    /**
    * Devuelve verdadero si  la persona es susceptible al virus y falso en caso contrario.
    * @return Verdadero si  la persona es susceptible al virus y falso en caso contrario
    */
    private boolean esSusceptible(){
        if (estado == EstadoInfeccion.SUSCEPTIBLE){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    /**
     * Cambia el estado de infección de la persona al indicado como parámetro
     * @param estado Estado de infección al que se desea cambiar
     */
    private void cambiarEstado(EstadoInfeccion estado){
        this.estado=estado;
        cambiarImagen(estado.getImagen());
    }
    
    /**
     * Cambia la imagen asignada a la persona
     * @param imagen Nombre de la imagen que se desea asignar
     */
    protected void cambiarImagen(String imagen){
        setImage(imagen);
    }
    
    /**
     * Asigna un espacio a esta persona
     * @param espacio Espacio se desea asignar
     */
    public void setEspacio(Espacio espacio){
        this.espacio=espacio;
    }
    
    /**
     * Devuelve si la persona está en el borde del espacio o no un espacio a esta persona
     * @return Verdadero si está en el borde del espacio, falso si no lo está
     */
    public boolean isAtEdge(){
        if (getX()-5<espacio.getX()-espacio.getAnchura()/2){
            return true;
        }
        if (getX()+5>=espacio.getX()+espacio.getAnchura()/2){
            return true;
        } 
        if (getY()-5<=espacio.getY()-espacio.getAltura()/2){
            return true;
        }
        
        if(getY()+5>=espacio.getY()+espacio.getAltura()/2){
            return true;
        }
        else{
            return false;
        }
            
        
    }
    
    
}
