public class Tablet extends Computer implements Presentable, Interactable, Movable{

    public Tablet(){
        super();
    }

    @Override
    public void interact() {
        System.out.println("Tablet can interact");
    }

    @Override
    public void move() {
        System.out.println("Tablet can be moved");
    }

    @Override
    public void present() {
        System.out.println("Tablet can present");
    }
}
