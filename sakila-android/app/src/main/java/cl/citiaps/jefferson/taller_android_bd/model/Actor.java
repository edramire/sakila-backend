package cl.citiaps.jefferson.taller_android_bd.model;

/**
 * Created by esteban on 13-11-15.
 */
public class Actor {
    private int id;
    private String name;
    private String lastName;
    private String lastUpdate;

    public Actor(int id, String name, String lastName, String lastUpdate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString(){
        return name + " " + lastName;
    }
}
