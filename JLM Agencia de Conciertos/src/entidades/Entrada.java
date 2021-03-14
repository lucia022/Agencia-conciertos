package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//Clase y Atributos de la clase Entrada
public class Entrada {

    //VALORES VALIDOS: Long mayores que 0.
    //VALORES INVALIDOS: Todo lo que no sea long y que el long sea menor igual que 0.
    private long id;
    //VALORES VÁLIDOS: solo se aceptan los valores con formato 0.00, correspondiendo al precio de las entradas en euros.
    //VALORES INVÁLIDOS: aquellos valores que no sean introducidos con el fomato 0.00, y el valor del precio de las entradas no sea en euros.
    private double precio;

    private boolean VIP = false;
    private boolean disponible = true;

    public Entrada() {
    }

    public Entrada(long id, double precio, boolean VIP) {
        this.id = id;
        this.precio = precio;
        this.VIP = VIP;
    }

    public Entrada(long id, double precio, boolean VIP, boolean disponible) {
        this.id = id;
        this.precio = precio;
        this.VIP = VIP;
        this.disponible = disponible;
    }

    public Entrada(Entrada e) {
        this.id = e.id;
        this.precio = e.precio;
        this.VIP = e.VIP;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /*Método toString de la clase Entrada*/
    @Override
    public String toString() {
        String devuelto;
        if (VIP) {
            devuelto = "ID de la entrada:" + id + " Precio de la entrada:" + precio + "€ ENTRADA VIP";
        } else {
            devuelto = "ID de la entrada:" + id + " Precio de la entrada:" + precio + "€  ENTRADA NO VIP";
        }
        return devuelto;
    }

    public static ArrayList<Entrada> convertir(Entrada[] array) {
        ArrayList<Entrada> ret = new ArrayList<Entrada>();
        for (Entrada t : array) {
            ret.add((Entrada) t);
        }
        return ret;
    }

    public static ArrayList<Entrada> arrayde(ArrayList<Entrada> lista, int[] ids) {
        ArrayList<Entrada> ret = new ArrayList<Entrada>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getId() es propio de Entrada
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Entrada) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static Entrada nuevoEntrada() {
        Entrada ret = new Entrada();
        Scanner in = new Scanner(System.in);

        long identrada;
        do {
            System.out.println("Introduzca el id de la entrada:");
            identrada = in.nextLong();
            ret.setId(identrada);
            if (identrada <= 0) {
                System.out.println("El id introducido no es válido, introduzcalo de nuevo:");
            }
        } while (identrada <= 0);

        /*ret.setId(Utilidades.numEntradas + 1);*/
        double precio;
        System.out.println("Introduzca el precio de la entrada:");
        precio = in.nextDouble();
        ret.setPrecio(precio);

        boolean VIP;
        System.out.println("Introduzca la entrada:");
        VIP = in.nextBoolean();
        ret.setVIP(VIP);
        if (VIP == false) {
            System.out.println("La entrada no es VIP");
        } else {
            System.out.println("La entrada es VIP");
        }

        return ret;

    }

    /**
     * Metodo para copiar todos los objetos de utilidades en un arraylist para
     * poder manipularlo
     *
     * @return Un array con todas las entradas de nuestra base de datos
     */
    public static ArrayList<Entrada> cargarEntradas() {
        ArrayList<Entrada> entradas = new ArrayList<Entrada>();//Creamos un array vacio llamado usaurios
        for (int i = 0; i < Utilidades.ENTRADAS.length; i++) { //Recorremos el array encontrado en la clase utilidades
            entradas.add(Utilidades.ENTRADAS[i]);//Y vamos añadiendo cada entrada a nuestro nuevo array vacio
        }
        return entradas;//Devuelve el array que declaramos al principio de la funcion
    }
    
    
     public String data() {
        return this.id + "|" + this.precio + "|" + this.VIP + "|" + this.disponible;
    }

    public void guardarEntradaTexto() {

        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter("EntradaenTexto.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(this.data());
            bw.newLine();
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                }
            }
        }

    }

    public static void guardarListaEntradasTexto(ArrayList<Entrada> entradas) {

        BufferedWriter bw = null;
        File f = new File("EntradasenTexto.txt");
        try {
            FileWriter fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            for (Entrada e : entradas) {
                bw.write(e.data());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Error");
            }

        }

    }

    public static ArrayList<Entrada> importarEntradasTexto(String ruta) {

        ArrayList<Entrada> entradas = new ArrayList<Entrada>();
        Entrada nuevo = new Entrada();
        String texto;
        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\|");
                    nuevo.setId(Long.valueOf(array[0]));
                    nuevo.setPrecio(Double.valueOf(array[1]));
                    nuevo.setVIP(Boolean.valueOf(array[2]));
                    nuevo.setDisponible(Boolean.valueOf(array[3]));

                    entradas.add(nuevo);
                }
                br.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return entradas;

    }

    public static Entrada obtenerEntradaPorID(long id) {
        Entrada nuevo = new Entrada();
        String texto;
        File f = new File("EntradasenTexto.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\|");
                    if (Long.valueOf(array[0]) == id) {
                        nuevo.setId(Long.valueOf(array[0]));
                        nuevo.setPrecio(Double.valueOf(array[1]));
                        nuevo.setVIP(Boolean.valueOf(array[2]));
                        nuevo.setDisponible(Boolean.valueOf(array[3]));

                        return nuevo;
                    }
                }
                br.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
        return nuevo;
    }

    public void guardarEntradaBinario() {

        ObjectOutputStream objetoSalida = null;
        try {
            String nombreFichero = "EntradaenBinario.dat";
            FileOutputStream ficheroSalida = new FileOutputStream(nombreFichero);
            objetoSalida = new ObjectOutputStream(ficheroSalida);
            objetoSalida.writeObject(this);

        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                objetoSalida.close();
            } catch (IOException ex) {
                Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void guardarListaEntradasBinario(ArrayList<Entrada> entradas) {

        ObjectOutputStream out = null;
        try {
            OutputStream os = new FileOutputStream("EntradasenBinario.txt");
            out = new ObjectOutputStream(os);
            out.writeObject(entradas);
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println("No se ha podido cerrar el Stream");
            }
        }

    }

    public static ArrayList<Entrada> importarEntradasBinario(String ruta) {

        ArrayList<Entrada> ret = new ArrayList<Entrada>();
        try {
            InputStream is = new FileInputStream(ruta);
            ObjectInput oi = new ObjectInputStream(is);
            ArrayList<Entrada> entradas = (ArrayList<Entrada>) oi.readObject();
            for (Entrada e : entradas) {
                System.out.println("Se ha importado con exito el usuario: ");
                System.out.println(e.data());
                ret.add(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ret;

    }

}
