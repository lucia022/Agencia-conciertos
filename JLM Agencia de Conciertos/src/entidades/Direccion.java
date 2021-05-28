/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author usuario
 */
public class Direccion {
    
    private int id; 
    private String calle;   
    private String codigoPostal;  
    private String pais;   
    private String ciudad;
    private String municipio;

    public Direccion() {
    }
    
    public Direccion(int id, String calle, String codigoPostal, String pais, String ciudad, String municipio) {
        this.id = id;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.ciudad = ciudad;
        this.municipio = municipio;
    }
public Direccion( String calle, String codigoPostal, String pais, String ciudad, String municipio) {

        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.ciudad = ciudad;
        this.municipio = municipio;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    
}
