import java.io.*;

public class Computer implements Serializable{
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(String[] peripheral) {
        this.peripheral = peripheral;
    }

    public boolean getCanPlayGames() {
        return canPlayGames;
    }

    public void setCanPlayGames(boolean canPlayGames) {
        this.canPlayGames = canPlayGames;
    }

    private String brand;
    private String size;
    private String[] peripheral;
    private boolean canPlayGames;

    public Computer(String brand, String size, String[] peripheral, boolean canPlayGames){
        this.brand=brand;
        this.size=size;
        this.peripheral=peripheral;
        this.canPlayGames=canPlayGames;
    }
}
