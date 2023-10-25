
package entidades;


public class Laboratorio {

    private  int cuit;
    private String nomLaboratorio,pais,domComercial,marca;

    public Laboratorio(int cuit, String nomLaboratorio, String pais, String domComercial, String marca) {
        this.cuit = cuit;
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
        this.marca=marca;
    }
        public Laboratorio(String nomLaboratorio, String pais, String domComercial, String marca){
        this.nomLaboratorio = nomLaboratorio;
        this.pais = pais;
        this.domComercial=domComercial;
        this.marca=marca;
         }
    
        public Laboratorio(String pais){this.pais = pais;}
        
        public Laboratorio(){}

    public int getCuit() { return cuit;}    
    public void setCuit(int cuit) {this.cuit = cuit;}
    
  

    public String getNomLaboratorio() {return nomLaboratorio;} 
    public void setNomLaboratorio(String nomLaboratorio) {this.nomLaboratorio = nomLaboratorio;}
     
    
    public String getPais() {return pais;}    
    public void setPais(String pais) {this.pais = pais;}
       
   

    public String getDomComercial() {return domComercial;}     
    public void setDomComercial(String domComercial) {this.domComercial = domComercial;}
        
    
    public String marca(){return marca;}
    public void setMarca(String marca){this.marca=marca;}
    
    

    
}
