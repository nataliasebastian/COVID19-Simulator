import greenfoot.*; 
/**
 * La clase GraficadorLinea sirve para dibujar gráficos con una línea.
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public class GraficadorLinea extends GraficadorHorizontal
{
   /**
     * Constructor de la clase GraficadorLinea
     * @param imagen Imagen
     * @param colorLinea Color de la línea
     * @param escala_x Escala del eje X
     * @param escala_y Escala del eje Y
     */
   public GraficadorLinea(GreenfootImage imagen, Color colorLinea, double escala_x, double escala_y){
       super(imagen, colorLinea, escala_x, escala_y);
   }
   
   /**
     * Dibuja la traza del valor
     * @param valor Valor que se va a representar
     */
   public void trazarValor(int valor)
   {
       imagen.drawLine((int)desplazamiento, obtenerValorFinal(valor), (int)desplazamiento, obtenerValorFinal(valor) - 6);
       desplazar();    
   }
}
