package entidades;

//Clase Informe
import java.util.Scanner;

public class Informe {

    //Atributos de la clase Informe
    private long id;
    private String descripcion;

    //Constructores de la clase Informe
    public Informe() {
    }

    public Informe(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Informe(Informe i) {
        this.id = i.id;
        this.descripcion = i.descripcion;
    }

    //Getters de la clase Informe
    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //Setters de la clase Informe
    public void setId(long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Nueva Metodo
    public static Informe nuevoInforme() {

        Informe ret = new Informe();
        Scanner in = new Scanner(System.in);

        long idNuevo;
        String descripcionNuevo = null;
        boolean fallo = true;

        do {

            System.out.print("Introduzca el id del Informe");
            idNuevo = in.nextLong();
            ret.setId(idNuevo);
            if (idNuevo <= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo");
            }

        } while (idNuevo <= 0);

        do {

            System.out.println("Introduzca la descripcion del informe");
            String descripcion = in.nextLine();
            ret.setDescripcion(descripcion);

            for (int i = 0; i < descripcionNuevo.length(); i++) {
                if (Character.isDigit(descripcionNuevo.charAt(i))) {
                    fallo = true;
                    System.out.println(" La descripcion que ha introducido contiene numeros,inntroduzcala sin ellos");
                    break;
                } else {
                    fallo = false;
                }
            }

            if ((descripcionNuevo.equals("")) || (descripcionNuevo.equals(" "))) {
                System.out.println("No has introducido ninguna descripcion, es necesario introducir alguna");
            }

        } while ((descripcionNuevo.equals("")) || (descripcionNuevo.equals(" ")) || (fallo == true));

        System.out.println("Todo correcto");

        return ret;

    }

    //Metodo toString de la clase Informe
    @Override
    public String toString() {
        return "Informe{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }

}
