/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lucia
 */
public class Usuario {
     private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String nif;
    
    /*constructor por defecto*/
    public Usuario(){}
    
    /*constructor con parámetros*/
    public Usuario(long id, String nombre, String apellido, String email, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
    }
    
    /*constructor de copia*/
    public Usuario(Usuario u){
       this.id = u.id;
        this.nombre = u.nombre;
        this.apellido = u.apellido;
        this.email = u.email;
        this.nif = u.nif; 
    }
    
    /*getters y setters de cada atributo*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    
    /*metodo toString*/
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", nif=" + nif + '}';
    }
    
}
