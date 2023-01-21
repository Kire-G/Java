public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("a", "a");
        Car.Engine engine1 = car1.new Engine(180, Fueltype.DIESEL);

        System.out.println(engine1);
        System.out.println(engine1.getFueltype());
    }
}