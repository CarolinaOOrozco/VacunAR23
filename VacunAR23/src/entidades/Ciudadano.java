/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class Ciudadano {
   
    public int dni;
    private String nombreCompleto;
    private String email;
    private String celular;
    private String patologia;
    private String ambitoTrabajo;
    
    public Ciudadano(){}
    
    public Ciudadano(int dni, String nombreCompleto, String email, String celular, String patologia, String ambitoTrabajo){
        
        this.dni= dni;
        this.nombreCompleto=nombreCompleto;
        this.email=email;
        this.celular=celular;
        this.patologia=patologia;
        this.ambitoTrabajo=ambitoTrabajo;
        
    }    
                
    public Ciudadano( String nombreCompleto, String email, String celular, String patologia, String ambitoTrabajo){
       
        this.nombreCompleto=nombreCompleto;
        this.email=email;
        this.celular=celular;
        this.patologia=patologia;
        this.ambitoTrabajo=ambitoTrabajo;
        
    }    

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getAmbitoTrabajo() {
        return ambitoTrabajo;
    }

    public void setAmbitoTrabajo(String ambitoTrabajo) {
        this.ambitoTrabajo = ambitoTrabajo;
    }
    
    
    @Override
    public String toString(){
     return "DNI= " + dni + " Nombte Completo= " + nombreCompleto + ", Email= " + email + ", Celular= " + celular + ", Patologia= " + patologia + ", Ambito de Trabajo= " + ambitoTrabajo;
     
    }

}
    

