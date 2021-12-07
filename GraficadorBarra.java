import greenfoot.*; 
/**
 * La clase GraficadorBarra sirve para dibujar gráficos de barras.
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public class GraficadorBarra extends GraficadorVertical
{
    /**
     * Constructor de la clase GraficadorBarra
     * @param imagen Imagen
     * @param colorLinea Color de la línea
     * @param escala_x Escala del eje X
     * @param escala_y Escala del eje Y
     */
    public GraficadorBarra(GreenfootImage imagen, Color colorLinea, double escala_x, double escala_y){
       super(imagen, colorLinea, escala_x, escala_y);
    }
    
    /**
     * Dibuja la traza del valor
     * @param valor Valor que se va a representar
     */
    public void trazarValor(int valor)
    {   
        //if (Greenfoot.getRandomNumber(100) <11){
            imagen.fillRect(0, (int) desplazamiento, obtenerValorFinal(valor), 1);
            desplazar();
        //}   
    }
    
    protected void desplazar(){
        desplazamiento = desplazamiento + escala_y + 1;
    }
}
