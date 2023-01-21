import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Computer computer = new Computer("br1", "10x35", new String[]{"mouse", "keyboard"}, true);
        serializeComputer(computer);
    }

    public static void serializeComputer(Computer computer) throws IOException {

        try(FileOutputStream fileOutput = new FileOutputStream("myfile.txt");
            ObjectOutputStream objectInput = new ObjectOutputStream(fileOutput)){
            objectInput.writeObject(computer);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Computer deserializeComputer(){
        Computer result = null;

        try(FileInputStream fileOutput = new FileInputStream("file1.txt");
            ObjectInputStream objectOut = new ObjectInputStream(fileOutput);) {
            result =(Computer)objectOut.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}