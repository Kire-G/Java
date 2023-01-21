public class Laptop extends Computer implements Presentable, Movable, Interactable, Computable{

    public Laptop(){
        super();
    }
    @Override
    public void interact() {
        System.out.println("Laptop can interact");
    }

    @Override
    public void move() {
        System.out.println("Laptop can be moved");
    }

    @Override
    public void present() {
        System.out.println("laptop can present");
    }

    @Override
    public void Computing() {
        System.out.println("Laptop can be used for computing");
    }
}
