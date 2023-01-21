public abstract class Computer {
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getPeripherial() {
        return peripherial;
    }

    public void setPeripherial(String[] peripherial) {
        this.peripherial = peripherial;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isCanPlayGames() {
        return canPlayGames;
    }

    public void setCanPlayGames(boolean canPlayGames) {
        this.canPlayGames = canPlayGames;
    }

    private String size;
    private String[] peripherial;
    private String brand;
    private boolean canPlayGames;
}
