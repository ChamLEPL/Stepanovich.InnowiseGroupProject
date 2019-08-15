package services;

import entities.User;
import pointOfEntry.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Saver {
    private String fileName;

    public Saver(){
        fileName = "user.dat";
    }

    public void saveFile(boolean append){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, append))) {
            oos.writeObject(Main.users);
            System.out.println("File has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void loadFile(boolean append){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            if(append) {
                Main.users.addAll((List<User>) ois.readObject());
                System.out.println("File has been loaded");
            } else {
                Main.users = (ArrayList<User>)ois.readObject();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void clearFile(){
        try(PrintWriter writer = new PrintWriter(fileName)){
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
