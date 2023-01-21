public class VolleyBallMatch extends Event{
    private String first_team;
    private String second_team;

    public String getFirst_team() {
        return first_team;
    }

    public void setFirst_team(String first_team) {
        this.first_team = first_team;
    }

    public String getSecond_team() {
        return second_team;
    }

    public void setSecond_team(String second_team) {
        this.second_team = second_team;
    }

    public VolleyBallMatch(String place, String date, String startHour, int numberOfTickets, double priceOfTickets, String first_team, String second_team) {
        super(place, date, startHour, numberOfTickets, priceOfTickets);
        this.first_team = first_team;
        this.second_team = second_team;
    }

    @Override
    public boolean sellTicket(int num) throws NoMoreTicketsExceprion {
        if(this.numberOfTickets == 0 || num > this.numberOfTickets){
            throw new NoMoreTicketsExceprion("No more tickets");
        }
        else{
            this.numberOfTickets-=num;
            return true;
        }
    }
}
