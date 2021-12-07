import greenfoot.*; 
/**
 * La clase GraficadorHorizontal ofrece distintas formas de graficar una variable en horizontal.
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public abstract class GraficadorHorizontal extends Graficador
{
    
    /**
     * Constructor de la clase GraficadorHorizontal
     * @param imagen Imagen
     * @param colorLinea Color de la línea
     * @param escala_x Escala del eje X
     * @param escala_y Escala del eje Y
     */
    public GraficadorHorizontal(GreenfootImage imagen, Color colorLinea, double escala_x, double escala_y){
        super(imagen, colorLinea, escala_x, escala_y);
    }
    
    /**
     * Desplaza la posición en el ejeX a donde se debe mostrar el siguiente valor
     */
    protected void desplazar(){
        desplazamiento = desplazamiento + escala_x;
    }
    
    /**
     * Dado un valor, calcula y devuelve el valor escalado
     * @param valor Valor de la variable que queremos escalar
     */
    protected int obtenerValorFinal(int valor){
        return (int) (imagen.getHeight() - valor * escala_y);
    }
}
