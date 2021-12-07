import greenfoot.*; 
/**
 * La clase GraficadorArea sirve para dibujar gráficos de áreas.
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public class GraficadorArea extends GraficadorHorizontal
{
   /**
     * Constructor de la clase GraficadorArea
     * @param imagen Imagen
     * @param colorLinea Color de la línea
     * @param escala_x Escala del eje X
     * @param escala_y Escala del eje Y
     */
   public GraficadorArea(GreenfootImage imagen, Color colorLinea, double escala_x, double escala_y){
       super(imagen, colorLinea, escala_x, escala_y);
   }
   
   /**
     * Dibuja la traza del valor
     * @param valor Valor que se va a representar
     */
   public void trazarValor(int valor)
   {
        imagen.drawRect((int)desplazamiento, obtenerValorFinal(valor), 1, imagen.getHeight() - obtenerValorFinal(valor));
        desplazar(); 
   }    
}
