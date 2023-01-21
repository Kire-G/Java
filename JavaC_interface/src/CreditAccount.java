public class CreditAccount  extends BankAccount{

    private int months;
    public CreditAccount(double amount, double interest, int months){
        super(amount, interest);
        this.months=months;
    }

    @Override
    public double pay() {
        int sum = 0;
        for(int i=0;i<this.months;i++){
            sum += this.getAmount() * this.getInterest() + this.getAmount();
        }
        return sum;
    }
}
