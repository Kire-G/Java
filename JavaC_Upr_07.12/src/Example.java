import java.util.Objects;

public class Example {
    static int counter=0;
    static final Object o = new Object();
//    @FunctionalInterface
//    interface Printable{
//        String print(String s);
//    }
    public static void main(String[] args)throws InterruptedException{
//        Printable p = (string)->
//        {
//            System.out.println(string);
//            return string;
//        };

        //Нишкиии


//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                counter++;
//            }
//        };

        Runnable r = () ->{
            for(int i=0;i<1000;i++){
                synchronized (o){
                    counter++;
                }
            }

    };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);


}
}
