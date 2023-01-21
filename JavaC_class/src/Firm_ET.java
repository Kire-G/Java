class Firm_ET extends Company{

    private String owner;
    private double first_capital;
    private double actual_capital;

    public Firm_ET(String name, String date, String ID){
        super(name, date, ID);
    }
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    public double getFirst_capital(){
        return first_capital;
    }
    public void setFirst_capital(double first_capital){
        this.first_capital = first_capital;
    }
    public double getActual_capital(){
        return actual_capital;
    }
    public void setActual_capital(double actual_capital){
        this.actual_capital = actual_capital;
    }
    public double calculation(){
        return (actual_capital - first_capital);
    }

}