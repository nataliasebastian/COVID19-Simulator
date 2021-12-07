/**
 * La clase Datos contiene los datos calculados (el número de infectados, el número máximo de infectados, el tiempo en el que se ha llegado
 * al máximo de infectados y el tiempo). 
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public class Datos  
{
    private int numInfectados;
    private int maxInfectados;
    private int tiempo;
    private int tiempoMax;
    
    /**
     * Constructor de la clase Datos
     */
    public Datos(){
        this.numInfectados=0;
        this.maxInfectados=0;
        this.tiempo=0;
        this.tiempoMax=0;
    }
    
    /**
     * Aumenta en 1 el número de infectados.
     */
    public void aumentarNumInfectados(){
        numInfectados++;
    }
    
    /**
     * Aumenta en 1 el tiempo.
     */
    public void aumentarTiempo(){
        tiempo++;
    }
    
    /**
     * Devuelve el número de infectados.
     * @return El número de infectados
     */
    public int getNumInfectados(){
        return numInfectados;
    }
    
    /**
     * Establece el número de infectados en la cantidad pasada por parámetro. 
     * @param num Número de infectados
     */
    public void setNumInfectados(int num){
        numInfectados=num;
    }
    
    /**
     * Devuelve el número máximo de infectados.
     * @return El número máximo de infectados
     */
    public int getMaxInfectados(){
        return maxInfectados;
    }
    
    /**
     * Establece el número máximo de infectados en la cantidad pasada por parámetro. 
     * @param num Número máximo de infectados
     */
    public void setMaxInfectados(int num){
        maxInfectados = num;
    }
    
    /**
     * Devuelve el tiempo transcurrido. 
     * @return El tiempo transcurrido
     */
    public int getTiempo(){
        return tiempo;
    }
    
    /**
     * Establece el tiempo en el que se ha llegado al máximo de infectados en el valor pasado por parámetro. 
     * @param num Tiempo en el que se ha llegado al máximo de infectados
     */
    public void setTiempoMax(int num){
        tiempoMax = num;
    }
    
    /**
     * Devuelve el tiempo en el que se ha llegado al máximo de infectados
     * @return El tiempo en el que se ha llegado al máximo de infectados
     */
    public int getTiempoMax(){
        return tiempoMax;
    }
}
