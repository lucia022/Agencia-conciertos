/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import dao.TrabajoDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Trabajo {
    
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String nif;
    private String telefono;
    private String sexo;
    private String estudios;
    private String tipoestudios;
    private int edad;
    private int carnet;
    private String cualidades;

    public Trabajo() {
    }

    
    
    public Trabajo(int id, String nombre, String apellido, String email, String nif, String telefono, String sexo, String estudios, String tipoestudios, int edad, int carnet, String cualidades) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estudios = estudios;
        this.tipoestudios = tipoestudios;
        this.edad = edad;
        this.carnet = carnet;
        this.cualidades = cualidades;
    }
    
    public Trabajo( String nombre, String apellido, String email, String nif, String telefono, String sexo, String estudios, String tipoestudios, int edad, int carnet, String cualidades) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nif = nif;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estudios = estudios;
        this.tipoestudios = tipoestudios;
        this.edad = edad;
        this.carnet = carnet;
        this.cualidades = cualidades;
    }


    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getTipoestudios() {
        return tipoestudios;
    }

    public void setTipoestudios(String tipoestudios) {
        this.tipoestudios = tipoestudios;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getCualidades() {
        return cualidades;
    }

    public void setCualidades(String cualidades) {
        this.cualidades = cualidades;
    }
    
    
    public static Boolean buscarEmail(String emailbuscado) {
        Boolean ret = false;
        ArrayList<Trabajo> todosCandidatos = new ArrayList<Trabajo>();
        TrabajoDAO t = new TrabajoDAO();
        todosCandidatos = t.todosCandidatos();
        for (int i = 0; i < todosCandidatos.size(); i++) {
            if (emailbuscado.equals(todosCandidatos.get(i).getEmail())) {
                ret = true;
            }
        }
        return ret;
    }

    public static Boolean buscarNIF(String nifbuscado) {
        Boolean ret = false;
        ArrayList<Trabajo> todosCandidatos = new ArrayList<Trabajo>();
        TrabajoDAO t = new TrabajoDAO();
        todosCandidatos = t.todosCandidatos();
        for (int i = 0; i < todosCandidatos.size(); i++) {
            if (nifbuscado.equals(todosCandidatos.get(i).getNif())) {
                ret = true;
            }
        }
        return ret;
    }
    
}
