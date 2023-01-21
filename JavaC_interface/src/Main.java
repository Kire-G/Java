public class Main {
    public static void main(String[] args) {

        Payable[] payable = new Payable[3];

        payable[0] = new CreditAccount(10, 10, 2);
        payable[1] = new DebitAccount(15, 15);
        payable[2] = new CreditAccount(100, 10, 5);

        for(int i=0;i<3;i++){
            System.out.println(payable[i].pay());
        }

    }
}