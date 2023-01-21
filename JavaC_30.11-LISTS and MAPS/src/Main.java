import javax.xml.namespace.QName;
import java.awt.*;
import java.io.*;
import java.security.Key;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

// generics
class Example implements Serializable {
    public String name;
    public int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Example(String name, int number){
        this.name=name;
        this.number=number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Example example = (Example) o;
        return number == example.number && Objects.equals(name, example.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString(){
        return "Example {" + name+", "+number+"}";
    }

}

public class Main {
    public static void main(String[] args) {
//        List <Integer> arr = new ArrayList<>();
//        arr.add(10);
//        arr.add(25);
//        arr.add(145);
//        int size = arr.size();
//        System.out.println("size = " + size);
//
////        System.out.println(arr.get(1));
//
//        for(int i: arr){
//            System.out.println(i);
//        }
//        arr.remove(2);
//        System.out.println("New size = " + arr.size());
//
        List<Example> ex1 = new ArrayList<>();
        ex1.add(new Example("Zdravko", 20));
        ex1.add(new Example("Ivan", 25));
        ex1.add(new Example("Miro", 37));
        System.out.println("Size  = " + ex1.size());
        for(Example i : ex1){
            System.out.println(i.name + " " + i.number);
        }
        ex1.remove(1);
        System.out.println("New size = " + ex1.size());
        for(Example i : ex1){
            System.out.println(i.name + " " + i.number);
        }

        System.out.println();

        ex1.add(new Example("Angel", 37));
        ex1.add(new Example("Ben", 37));

        //List <Example> sorted = ex1.stream().sorted((p1, p2) -> p1.name.compareTo(p2.name)).collect(Collectors.toList());

        List <Example> sorted = ex1.stream().sorted(Comparator.comparing(Example::getName)).collect(Collectors.toList());
        for(Example i : sorted){
            System.out.println(i.name + " " + i.number);
        }


        System.out.println();
        System.out.println();

        //MAP MAP MAP MAP MAP

//        Map <String, String> map = new HashMap<>();
//        //          key      value(use key to get the value)
//        map.put("dog", "Куче");
//        System.out.println(map.get("dog"));



        Map<String, Example> my_example= new HashMap<>();
        Example e1 = new Example("Kiril", 200);
        Example e2 = new Example("Ivan", 75);
        Example e3 = new Example("Ivana", 35);
        my_example.put("First person", e1);
        my_example.put("Second person", e2 );
        my_example.put("Third person", e3);
        Example getting = my_example.get("First person");
        System.out.println(getting.name + " " + getting.number);
        System.out.println();
        System.out.println();

        Map<Example, String > new_map = new HashMap<>();
        Example n = new Example("Yxz", 20);
        new_map.put(n, "Kiril");
        Example n1 = new Example("Ani", 10);
        new_map.put(n1, "Alex");
        String get = new_map.get(new Example("Angel", 20));

        int i=1;
        for(Map.Entry<String, Example> e : my_example.entrySet()){
            //System.out.println("Key {" + e.getKey().getName() +", "+ e.getKey().getNumber() + "} \nValue{"+ e.getValue() + "}");
            System.out.println(i +"Key{"+ e.getKey() + "} - Value{" +e.getValue().getName()+", "+e.getValue().getNumber()+"}");
            i++;
        }

        System.out.println();
        System.out.println("SORTED BY VALUE");
        new_map.entrySet().stream().sorted(Map.Entry.<Example, String>comparingByValue()).forEach(System.out::println);
//        Map<Example, String> result = new_map.entrySet().stream().sorted(Comparator.comparing(Map.Entry.comparingByValue())).collect(Collectors.toList());


        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.bin"))){
            out.writeObject(new_map);

        }catch(IOException e){e.printStackTrace();}

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.bin"))){
            Map<Example, String> read = (Map<Example, String>) in.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e ){
            throw new RuntimeException(e);
        }

    }
}