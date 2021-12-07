/**
 * El estado en el que se puede encontrar una persona: susceptible, infectada o inmune.
 * 
 * @author Natalia Sebastián)
 * @version 5 (Mayo 2021)
 */
public enum EstadoInfeccion  
{
    SUSCEPTIBLE("normal.png"), 
    INFECTADA("infectada.png"), 
    INMUNE("inmune.png");
    
    private final String nombreImagen;
    
    EstadoInfeccion(String nombreImagen){
        this.nombreImagen=nombreImagen;
    }
    
    /**
     * Devuelve la imagen relacionada con el estado de infección.
     * @return Nombre de la imagen
     */
    public String getImagen(){
        return nombreImagen;
    }
    
}
