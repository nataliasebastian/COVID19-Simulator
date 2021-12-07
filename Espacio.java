import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * La clase espacio representa un espacio rectangular
 * 
 * @author Natalia Sebastian
 * @version 5 (Mayo 2021)
 */
public class Espacio extends Actor
{
    private GreenfootImage imagen;
    private int anchura;
    private int altura;
    private Color colorLinea;
    private Color colorFondo;
    private Graficador graficador;
    
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    private Datos datos = new Datos();

    
     /**
     * Crea un espacio rectangular de anchura x altura, utilizando por defecto el GraficadorLinea
     * @param anchura Anchura del espacio
     * @param altura Altura del espacio
     */
    public Espacio(int anchura, int altura){
        this.anchura = anchura;
        this.altura = altura;
        //this.graficador=graficador;
        this.colorLinea = Color.BLUE;
        this.colorFondo = Color.WHITE;
        this.imagen = crearImagen();
        this.graficador = new GraficadorLinea(imagen, colorLinea, 0.25, 2);
        //this.graficador = new GraficadorBarra(imagen, colorLinea, 2,2);
    }
    
    /**
     * Crea un espacio rectangular de anchura x altura
     * @param anchura Anchura del espacio
     * @param altura Altura del espacio
     * @param graficador Graficador utilizado
     */
    public Espacio(int anchura, int altura, Graficador graficador){
        this.anchura = anchura;
        this.altura = altura;
        this.colorLinea = Color.BLUE;
        this.colorFondo = Color.WHITE;
        this.imagen = crearImagen();
        this.graficador = graficador;
        //this.graficador = new GraficadorBarra(imagen, colorLinea, 2,2);
    }
    
    /**
     * Crea un espacio rectangular de anchura x altura, asignandole un color de fondo, color de línea y un GraficadorLinea por defecto.
     * @param anchura Anchura del espacio
     * @param altura Altura del espacio
     * @param colorLinea Color de la línea
     * @param colorFondo Color del fondo
     */
    public Espacio(int anchura, int altura, Color colorLinea, Color colorFondo){
        this.anchura = anchura;
        this.altura = altura;
        this.colorLinea = colorLinea;
        this.colorFondo = colorFondo;
        this.graficador = new GraficadorLinea(imagen, colorLinea, 0.25, 2);
        this.imagen = crearImagen();
        //this.graficador = new GraficadorBarra(imagen, colorLinea, 2, 2);
    }
    
    /**
     * Crea un espacio rectangular de anchura x altura, asignandole un color de fondo, color de línea y graficador.
     * @param anchura Anchura del espacio
     * @param altura Altura del espacio
     * @param colorLinea Color de la línea
     * @param colorFondo Color del fondo
     */
    public Espacio(int anchura, int altura, Color colorLinea, Color colorFondo, Graficador graficador){
        this.anchura = anchura;
        this.altura = altura;
        this.colorLinea = colorLinea;
        this.colorFondo = colorFondo;
        this.graficador = graficador;
        this.imagen = crearImagen();
        //this.graficador = new GraficadorBarra(imagen, colorLinea, 2, 2);
    }
    
    /**
     * Crea un rectángulo con un marco de 5 de grosor.
     * @return La imagen que contiene el rectángulo.
     */
    private GreenfootImage crearImagen(){
        GreenfootImage imagen = new GreenfootImage(anchura, altura);
        imagen.setColor(colorFondo);
        imagen.fill();
        imagen.setColor(colorLinea);
        for (int i=0; i <5; i++){
            int[] xs = {0+i, 0+i, anchura-1-i, anchura-1-i};
            int[] ys = {0+i, altura-1-i, altura-1-i, 0+i};
            imagen.drawPolygon(xs, ys, 4);
        }
        setImage(imagen);
        return imagen;
    }
    
    /**
     * Delvuelve la anchura del espacio
     * @return La anchura
     */
    public int getAnchura(){
        return anchura;
    }
    
    /**
     * Delvuelve la altura del espacio
     * @return La altura
     */
    public int getAltura(){
        return altura;
    }
   
    /**
    * Crea la población inicial, colocada aleatoriamente
    * @param numPersonas Número de personas del mundo
    * @param porcentajeAislados Porcentaje de aislados en el mundo
    */
    public void poblar(int numPersonas, int porcentajeAislados)
    {
        boolean aislado;
        int i = 0;
        while (i < numPersonas) {
            
            if ((Greenfoot.getRandomNumber(100)) < porcentajeAislados){
                aislado=true;
            }
            else{
                aislado=false;
            }
            //instancia la persona
            Persona p = new Persona(aislado);
            personas.add(p);
            getWorld().addObject(p, Greenfoot.getRandomNumber(anchura-30)+10+getX()-anchura/2, Greenfoot.getRandomNumber(altura-30)+10);
            i = i + 1;
            
            //instancia el niño si se cumple la condicion
            if(Greenfoot.getRandomNumber(100) < 10){
                if (p.getX()>=getX()+anchura/2-26){
                    Nino nino = new Nino (aislado, p);
                    getWorld().addObject(nino, p.getX()-16, p.getY());
                    i++;
                    personas.add(nino);
                }
                else{
                    Nino nino = new Nino (aislado, p);
                    getWorld().addObject(nino, p.getX()+16, p.getY());
                    i++;
                    personas.add(nino);
                }
            }
            
        
            //instancia el viejo si se cumple la condicion
            if(Greenfoot.getRandomNumber(100) < 10){
                if (p.getX()>=getX()+anchura/2-60){
                    Viejo viejo = new Viejo (aislado);
                    getWorld().addObject(viejo, p.getX()-50, p.getY()-50);
                    i++;
                    personas.add(viejo);
                }
                else{
                    Viejo viejo = new Viejo (aislado);
                    getWorld().addObject(viejo, p.getX()+50, p.getY()+50);
                    i++;
                    personas.add(viejo);
                }
            }
            
        }
        
        for (Persona persona: personas){
            persona.setEspacio(this);
        }
    }

    /**
     * La accion regular durante la simulación: mostrar informe.
     */
    public void act()
    {
        mostrarInforme();
    }

    /**
     * Muestra el informe del número de personas infectadas,
     * en modo texto y gráfico.
     */
    private void mostrarInforme()
    {
        /*int numInfectados=0;
        int maxInfectados = 0;
        
        
        for (final Persona persona : personas) {
            if (persona.estaInfectada()) {
                numInfectados = numInfectados + 1;
            }
        }
        if (numInfectados > maxInfectados) {
            maxInfectados = numInfectados;
        }
        
        
        getWorld().showText("Infectados:" + numInfectados, getX()-anchura/2+100, getY()-altura/2+20);
        getWorld().showText("Max:" + maxInfectados, getX()-anchura/2+250, getY()-altura/2+20);
        */
        datos.setNumInfectados(0);
        
        for (final Persona persona : personas) {
            if (persona.estaInfectada()) {
                datos.aumentarNumInfectados();
            }
        }
        
        if (datos.getNumInfectados() > datos.getMaxInfectados()) {
            datos.setMaxInfectados(datos.getNumInfectados());
            datos.setTiempoMax(datos.getTiempo());
        }
        datos.aumentarTiempo();
        getWorld().showText("Infectados: " + datos.getNumInfectados(), getX()-anchura/2+100, getY()-altura/2+20);
        getWorld().showText("Max: " + datos.getMaxInfectados(), getX()-anchura/2+66, getY()-altura/2+40);
        getWorld().showText("Tiempo: " + datos.getTiempo(), getX()-anchura/2+90, getY()-altura/2+60);
        getWorld().showText("Tiempo Max: " + datos.getTiempoMax(), getX()-anchura/2+115, getY()-altura/2+80);
       
        graficador.trazarValor(datos.getNumInfectados());
    }
    
    /**
     * Devuelve la primera persona de la lista
     * @return Primera persona de la lista
     */
    public Persona obtenerPersona(){
        return personas.get(0);
    }
    
    public GreenfootImage getImagen(){
        return imagen;
    }
    
    public Graficador getGraficador(){
        return graficador;
    }
    
}
