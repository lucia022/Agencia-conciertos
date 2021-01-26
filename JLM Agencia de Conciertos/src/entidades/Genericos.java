/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */

public class Genericos<T> {

    public T obj;

    public Genericos() {
    }

    public Genericos(T o) {
        obj = o;
    }

    public T get() {
        return obj;
    }

    public void set(T t) {
        this.obj = t;
    }

    public void classType() {
        System.out.println("El tipo de clase es " + obj.getClass().getName());
    }

    public final ArrayList<T> convertir(T[] array) {
        ArrayList<T> ret = new ArrayList<T>();
        for (T t : array) {
            ret.add((T) t);
        }
        return ret;
    }

}
