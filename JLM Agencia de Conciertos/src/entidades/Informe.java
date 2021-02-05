package entidades;

//Clase Informe
import java.util.Scanner;

public class Informe {

    //Atributos de la clase Informe
    
    // Valores Validos!! Estan permitodos todos los int/long cuyo valor sea entre 0 e infinito
    // Valores Invalidos!! Queda prohibido el uso de caracteres especiales, numeros negativos, tipos `char, tipo double, tipo booblean, basicamento todo aquello que no sea un int/long primitivo´
    private long id;

    // Valores Validos!! Por el momento solo se aceptan cadena de caracteres/String, caracteres del tipo char y guiones bajos ("_")por si hubiera menciones a correos electronicos
    /* Valores Invalidos!! Quedan prohibidos el uso de primitivos, excepto el ´char´, ya que en el informe puede hacerse referencia a correos electronicos,
     y el guión bajo ("_") por el mismo motivo*/
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

    //Nuevo  Metodo Nuevo Informe
    public static Informe nuevoInforme() {

        Informe ret = new Informe();
        Scanner in = new Scanner(System.in);

        long idNuevo = -1;
        String descripcionNueva = null;
        boolean fallo = true;

        //Esta parte debera sera autodeclarada, ya que muy probablemente se desconozca el id del informe
        
        do {

            System.out.print("Introduzca el id del Informe");
            idNuevo = in.nextLong();
            ret.setId(idNuevo);
            if (idNuevo >= 0) {
                System.out.println("El id introducido no es valido,introduzcalo de nuevo");
            }

        } while (idNuevo <= 0);
            System.out.println ("El id corresponde a: " + idNuevo);
        
        //Aqui acaba la parte del  do-while del id
        
        
        do{
            System.out.println("Introduzca la descripcion del informe");
            String descripcion = in.nextLine();
            ret.setDescripcion(descripcion);
            
            for (int i = 0; i < descripcionNueva.length(); i++) {
                if (Character.isDigit(descripcionNueva.charAt(i))) {
                    fallo = true;
                    System.out.println(" La descripcion que ha introducido contiene numeros,inntroduzcala sin ellos");
                    break;
                } else {
                    fallo = false;
                }
            }
            if ((descripcionNueva.equals("")) || (descripcionNueva.equals(" "))) {
                System.out.println("No has introducido ninguna descripcion, es necesario introducir alguna");
            }
        } while ((descripcionNueva.equals("")) || (descripcionNueva.equals(" ")) || (fallo == true));

        System.out.println("Todo correcto");

        return ret;

    }
    
       //Aqui creo un metodo para ver el informe
    
       public static void verInformes() {
        System.out.println("Lista de Informes actuales:");
        for (int i = 0; i < Utilidades.INFORMES.length; i++) {
            Informe in = Utilidades.INFORMES[i];
            if (in.getId()> 0) {
                System.out.println(in.toString());
            }
        }
    }
    
    // Aqui creo un metodo para buscar el informe por el id
    
     public static Informe getInformeById(int id){
        for(int i=0; i< Utilidades.GIRAS.length; i++){
            if(Utilidades.INFORMES[i].getId()==id)
                return Utilidades.INFORMES[i];
        }
        return null;
    }
    
     
     /*DEJO ESTO AQUI PARA APRENDER COMO LO ESTAB HACIENDO, NO SE PUEDE PEDIR INFORMES,
     SE DEBE PEDIR EL NUMERO DE INFORMES COMO SE MUESTRA ARRIBA 
     
   public static Informe buscarById (long id) {
        Informe ret = new Informe();
        for (Informe i: Utilidades.INFORMES){
            if (i.getId().equals (id)){
                return i;
            }
        }
    }
    
    public static Informe buscarById (int id) {
        Informe ret = new Informe();
        for (int i =0; i < Utilidades.INFORMES; i++){
            if (Utilidades.INFORMES[i].getId()==id){
                return Utilidades.INFORMES [i];
            }
        } return null;
    }*/
    
   

    //Metodo toString de la clase Informe, en el cual se ha modificado para decorar su presencia, añadiendole saltos de carro y espacios.
    @Override
    public String toString() {
        return "Resumen del Informe: " + "\n"  + "el id es : " + id + "\n" + " La descripción del informe es: " + descripcion;
    }
    
   

}