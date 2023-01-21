public class Desktop extends Computer implements Presentable, Computable{

    public Desktop(){
        super();
    }
    @Override
    public void present(){
        System.out.println("Computer can present");
    }

    @Override
    public void Computing() {
        System.out.println("Computer can be used for computing");
    }

}
