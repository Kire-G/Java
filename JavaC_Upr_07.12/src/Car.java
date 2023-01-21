public class Car {
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    private String brand;
    private String model;

    public class Engine{
        public Engine(int power, Fueltype fueltype) {
            this.power = power;
            this.fueltype = fueltype;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "power=" + power +
                    ", fueltype=" + fueltype +
                    '}';
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public Fueltype getFueltype() {
            return fueltype;
        }

        public void setFueltype(Fueltype fueltype) {
            this.fueltype = fueltype;
        }

        private  int power;
        private Fueltype fueltype;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Car(String brand, String model){
        this.brand=brand;
        this.model=model;
    }
}
