
package entidades;


public class Individual extends entidades.Concierto{
    private Artista artista; /*relación "actuar" 1:N entre artista e individual, donde añadimos un objeto de la clase artista en la clase individual*/
    
    public Individual (){
        super();
    }
    
    public Individual(Artista artista){
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
