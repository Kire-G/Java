public abstract class Event {
    private String place;
    private String date;
    private String startHour;
    protected int numberOfTickets;
    private double priceOfTickets;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getPriceOfTickets() {
        return priceOfTickets;
    }

    public void setPriceOfTickets(double priceOfTickets) {
        this.priceOfTickets = priceOfTickets;
    }

    public Event(String place, String date, String startHour, int numberOfTickets, double priceOfTickets) {
        this.place = place;
        this.date = date;
        this.startHour = startHour;
        this.numberOfTickets = numberOfTickets;
        this.priceOfTickets = priceOfTickets;
    }

    public abstract boolean sellTicket(int num) throws NoMoreTicketsExceprion;
}
