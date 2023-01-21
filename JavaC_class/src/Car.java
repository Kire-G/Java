import java.util.Arrays;

public class Car {
    private String brand;
    private String model;
    private String colour;
    private int hp;
    private String engine;
    private String gear_box;
    private int year;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(){

    }

    public Car(String brand, String model){
        this.brand = brand;
        this.model=model;
    }


    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }

    public void setGear_box(String gear_box) {
        this.gear_box = gear_box;
    }

    public String getGear_box() {
        return gear_box;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }


    //2
    public Car[] clear(Car[] arr, char c, int n) {

        int j = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i].getBrand().charAt(0) == c){
                j++;
            }
        }
        Car[] ar = new Car[j];
        j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].getBrand().charAt(0) == c){
                ar[j] = arr[i];
                j++;
            }
        }


        return ar;
    }
    //3
    public Car[] sortingArr(Car[] arr, int n, String par) {
        Car temp = new Car();
        int m = n;
        if (par.equals("ascending")) {
            for (int i = 0; i < m - 1; i++) {
                int lowest = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j].getBrand().compareTo(arr[lowest].getBrand()) < 0) {
                        lowest = j;
                    }
                }

                temp = arr[i];
                arr[i] = arr[lowest];
                arr[lowest] = temp;
            }

        } else if (par.equals("descending")) {
            for (int i = 0; i < m - 1; i++) {
                int lowest = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j].getBrand().compareTo(arr[lowest].getBrand()) > 0) {
                        lowest = j;
                    }
                }

                temp = arr[i];
                arr[i] = arr[lowest];
                arr[lowest] = temp;
            }

        }
        return arr;
    }

    //4

    public Car[] clearArr(Car[] arr, int n){
        int ind = n;
        boolean[] al = new boolean[n];
        int j=0;
        for(int i=0;i<n;i++){
            for(j=i-1;j>=0;j--){
                if(arr[i].getBrand().equals(arr[j].getBrand())){
                    al[i] = true;
                    n--;
                }
            }
        }
        Car[] ar = new Car[ind];
        for(int i=0;i<n;i++){
            if(al[i] == false){
                ar[ind--] = arr[i];
            }

        }
        return ar;
    }

}
