
package entidades;


public class Laboratorio {

    private  int cuit;
    private String nomLaboratorio,pais,domComercial;

    public Laboratorio(int cuit, String nomLaboratorio, String pais, String domComercial) {
        this.cuit = cuit;
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
    }

    public int getCuit() { return cuit;}    
    public void setCuit(int cuit) {this.cuit = cuit;}
    
  

    public String getNomLaboratorio() {return nomLaboratorio;} 
    public void setNomLaboratorio(String nomLaboratorio) {this.nomLaboratorio = nomLaboratorio;}
     
    
    public String getPais() {return pais;}    
    public void setPais(String pais) {this.pais = pais;}
       
   

    public String getDomComercial() {return domComercial;}     
    public void setDomComercial(String domComercial) {this.domComercial = domComercial;}
        
    

    
    

    
}
