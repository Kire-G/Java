import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TicketLoader implements Implementable{
    @Override
    public Object[] importDataFromFile() throws IOException, UnrecognisedRowException {

        Event[] events = null;
        String line;
        int current_element_index = 0;
        int number0frows=0;

        try(BufferedReader reader = new BufferedReader(new FileReader("dailytickets.txt"))){
            while(reader.readLine() != null){
                number0frows++;
            }
        }
        events = new Event[number0frows];
        try(BufferedReader reader = new BufferedReader(new FileReader("dailytickets.txt"))) {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("1")) {
                    String[] concertInf = line.split("\\*");
                    Concert concert = new Concert(concertInf[2], concertInf[3], concertInf[4], Integer.parseInt(concertInf[5]), Double.parseDouble(concertInf[6]), concertInf[1]);
                    events[current_element_index++] = concert;
                } else if (line.startsWith("2")) {
                    String[] match = line.split("\\*");
                    VolleyBallMatch volley = new VolleyBallMatch(match[3], match[4], match[5], Integer.parseInt(match[6]), Double.parseDouble(match[7]), match[1], match[2]);
                    events[current_element_index++] = volley;
                } else {
                    throw new UnrecognisedRowException("Unrecognised Row!");
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
        }catch (UnrecognisedRowException e){
            e.printStackTrace();
        }
        return events;
    }
}
