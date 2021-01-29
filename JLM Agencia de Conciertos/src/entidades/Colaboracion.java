
package entidades;

import java.util.ArrayList;


public class Colaboracion extends Concierto{
    
     private ArrayList<Artista> artistas = new ArrayList<Artista>(); /*relación "actuar" N:N entre artista y colaboración.*/
    public Colaboracion (){
        super();
    }
    
    public Colaboracion(ArrayList<Artista> artistas){
        this.artistas = artistas;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }
  }
