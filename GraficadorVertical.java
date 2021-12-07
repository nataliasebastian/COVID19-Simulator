import greenfoot.*;
 
/**
 * La clase GraficadorVertical ofrece distintas formas de graficar una variable en vertical.
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */

public abstract class GraficadorVertical extends Graficador
{
    /**
     * Constructor de la clase GraficadorVertical
     * @param imagen Imagen
     * @param colorLinea Color de la línea
     * @param escala_x Escala del eje X
     * @param escala_y Escala del eje Y
     */
    public GraficadorVertical(GreenfootImage imagen, Color colorLinea, double escala_x, double escala_y){
        super(imagen, colorLinea, escala_x, escala_y);
    }
    
    /**
     * Desplaza la posición en el ejeY a donde se debe mostrar el siguiente valor
     */
    protected void desplazar(){
        desplazamiento = desplazamiento + escala_y;
    }
    
    /**
     * Dado un valor, calcula y devuelve el valor escalado
     * @param valor Valor de la variable que queremos escalar
     */
    protected int obtenerValorFinal(int valor){
        return (int) (valor*escala_x);
    }
}
