import greenfoot.*;
/**
 * La clase Graficador ofrece distintas formas de graficar una variable.
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public abstract class Graficador  
{
    // instance variables - replace the example below with your own
    protected GreenfootImage imagen;
    protected Color colorLinea;
    protected double desplazamiento;
    protected double escala_x;
    protected double escala_y;

    /**
     * Constructor de la clase Graficador
     * @param imagen Imagen
     * @param colorLinea Color de la línea
     * @param escala_x Escala del eje X
     * @param escala_y Escala del eje Y
     */
    public Graficador(GreenfootImage imagen, Color colorLinea, double escala_x, double escala_y){
        this.imagen=imagen;
        this.colorLinea=colorLinea;
        this.escala_x=escala_x;
        this.escala_y=escala_y;
        desplazamiento=0;
    }
    
    /**
     * Desplaza la posición en el eje donde se debe mostrar el siguiente valor
     */
    protected abstract void desplazar();
    
    /**
     * Dado un valor, calcula y devuelve el valor escalado
     * @param valor Valor de la variable que queremos escalar
     */
    protected abstract int obtenerValorFinal(int valor);
    
    /**
     * Dibuja la traza del valor
     * @param valor Valor que se va a representar
     */
    public abstract void trazarValor(int valor);

    /**
     * Establece la imagen del graficador en la pasada por parámetro
     * @param imagen Imagen que se va a asignar al graficador
     */
    public void setImage(GreenfootImage imagen){
        this.imagen=imagen;
    }
}
