class Company {

    private String name;
    private String date;
    private String ID;

    public Company(String name, String date, String ID){
        this.name=name;
        this.date=date;
        setID(ID);
    }



    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        if(ID.length() <= 10)
        {
            this.ID = ID;
        }
        else
            System.out.println("Length more than 10!");
    }
}