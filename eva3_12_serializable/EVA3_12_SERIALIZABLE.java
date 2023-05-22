package com.mycompany.eva3_12_serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EVA3_12_SERIALIZABLE {

    public static void main(String[] args) {
        
        try {
            Persona p = new Persona("EDUARDO", "MUÑOZ", 18);
            guardarObjetos(p);
            try {
                Persona resu = leerObjetos();
                System.out.println("Nombre: " + resu.getNombre());
                System.out.println("Apellido" + resu.getApellido());
                System.out.println("Edad: " + resu.getEdad());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void guardarObjetos(Persona p) throws FileNotFoundException, IOException{
        FileOutputStream openArch = new FileOutputStream("C:\\ARCHIVOS");
        ObjectOutputStream ouStream = new ObjectOutputStream(openArch);
        ouStream.writeObject(p);
        ouStream.close();
    }
    
    public static Persona leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException{
        Persona p = null;
        FileInputStream openArch = new FileInputStream("C:\\Users\\invitado\\Documents\\NetBeansProjects");
        ObjectInputStream oiStream = new ObjectInputStream(openArch);
        //Casting: de object a persona
        p = (Persona)oiStream.readObject();
        return p;
    }

}

class Persona implements Serializable{

    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

}