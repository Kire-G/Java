public class Concert extends Event{

    public Concert(String place, String date, String startHour, int numberOfTickets, double priceOfTickets, String star_name) {
        super(place, date, startHour, numberOfTickets, priceOfTickets);
        this.star_name = star_name;
    }

    private String star_name;

    public void setStar_name(String star_name){
        this.star_name=star_name;
    }
    public String getStar_name(){
        return star_name;
    }

    @Override
    public boolean sellTicket(int num) throws NoMoreTicketsExceprion {
        if(num>this.numberOfTickets || this.numberOfTickets == 0)
        {
            throw new NoMoreTicketsExceprion("No more tickets!");
        }
        else{
            this.numberOfTickets-=num;
            return true;
        }
    }
}
