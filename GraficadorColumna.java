import greenfoot.*; 
/**
 * La clase GraficadorColumna sirve para dibujar gráficos de columnas.
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public class GraficadorColumna extends GraficadorHorizontal
{
   /**
     * Constructor de la clase GraficadorColumna
     * @param imagen Imagen
     * @param colorLinea Color de la línea
     * @param escala_x Escala del eje X
     * @param escala_y Escala del eje Y
     */
   public GraficadorColumna(GreenfootImage imagen, Color colorLinea, double escala_x, double escala_y){
       super(imagen, colorLinea, escala_x, escala_y);
   }
    
   /**
     * Dibuja la traza del valor
     * @param valor Valor que se va a representar
     */
   public void trazarValor(int valor)
   {
        //if (Greenfoot.getRandomNumber(100) < 6){
            imagen.fillRect((int)desplazamiento, obtenerValorFinal(valor), 1, imagen.getHeight() - obtenerValorFinal(valor));
            desplazar();
        //}
    }
    
     protected void desplazar(){
        desplazamiento = desplazamiento + escala_x + 1;
    }
}
