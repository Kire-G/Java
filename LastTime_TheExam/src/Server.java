import java.util.*;
import java.io.*;
import java.net.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
public class Server {

    public static final Pattern EMAIL = Pattern.compile("[a-z]+@tu-sofia.bg");
    public static final Pattern EGN = Pattern.compile("\\d{10}");
    public static final Pattern FACULTY_NUMBER = Pattern.compile("\\d{9}");
    private final Object userLock = new Object();

    List<User> users = new ArrayList<>();
    public static void main(String[] args){
        Server server = new Server();
        server.start();
    }
    public void start(){
        try{
            System.out.println("Listening");
            ServerSocket server = new ServerSocket(3500);
            while(true){
                Socket client = server.accept();

                Thread clientThread = new Thread(() ->{
                    System.out.println("Client accepted.");
                    Scanner sc = null;
                    PrintStream out = null;
                    try{
                        sc = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                        logIn(sc, out);

                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    finally{
                        if(sc != null)sc.close();
                        if(out != null)sc.close();
                    }
                });
                clientThread.start();

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public User check(String username, String password){
        synchronized (userLock){
            for(User user : users){
                if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                    return user;

                }
            }
            return null;
        }
    }
    public void logIn(Scanner sc, PrintStream out){
        out.println("Enter username");
            String name = sc.nextLine();

            out.println("Enter password");
            String password = sc.nextLine();
            User user1 = check(name, password);
            if(user1 == null){
                System.out.println("User not found");
            }

            switch(user1.getUserType()){
            case ADMIN:{
                log_Admin(sc, out);
            }
            case TEACHER:{
                log_Teacher(sc, out);
            }
            case STUDENT:{
                log_Student(sc, out);
            }
        }

    }
    public void log_Teacher(Scanner sc, PrintStream out){
        out.println("Logged in as teacher");

        out.println("Enter faculty number:");
        String fac_num = sc.nextLine();

        out.println("Enter subject:");
        String sub = sc.nextLine();

        out.println("Enter grade:");
        String gr = sc.nextLine();

        out.println("Enter semester:");
        String sem = sc.nextLine();
        Grade grade = new Grade(sub, Integer.parseInt(sem), Integer.parseInt(gr));

        synchronized (userLock){
            for(User user : users){
                if(user.getUserType().equals(UserType.STUDENT) && user.getUsername().equals(fac_num)){
                    Student student = (Student) user;
                    student.getGrades().add(grade);
                    out.println(student.grades);
                    out.println("Done");
                }
               }
        }
    }
    public void log_Admin(Scanner sc, PrintStream out){
        out.println("Logged in as admin");
        out.println("Enter user type:");
        UserType acc = UserType.valueOf(sc.nextLine());

        switch(acc){
            case ADMIN:{
                out.println("Enter username:");
                String name = sc.nextLine();

                out.println("Enter password:");
                String password = sc.nextLine();

                Admin admin = new Admin(name, password);
                synchronized (userLock){
                    users.add(admin);
                }
                writeToFile();

            }
            case STUDENT:{
                try{
                    out.println("Enter faculty number:");
                    String fn = sc.nextLine();
                    if(!FACULTY_NUMBER.matcher(fn).matches()){
                        throw new CredentialsException("Invalid Faculty number!");
                    }
                    out.println("Enter egn:");
                    String egn = sc.nextLine();
                    if(!EGN.matcher(egn).matches()){
                        throw new CredentialsException("Invalid EGN!");
                    }
                    Student student = new Student(fn, egn);
                    synchronized(userLock){
                        users.add(student);
                    }
                    writeToFile();
                    out.println("User saved - " + student);

                }catch(CredentialsException e){
                    e.printStackTrace();
                }


            }
            case TEACHER:{
                try{
                    out.println("Enter email:");
                    String mail = sc.nextLine();
                    if(!EMAIL.matcher(mail).matches()){
                        throw new CredentialsException("Invalid email!");
                    }
                    out.println("Enter password");
                    String password = sc.nextLine();
                    if(password.length() < 5){
                        throw new CredentialsException("Invalid password!");
                    }
                    Teacher teacher = new Teacher(mail, password);
                    synchronized (userLock){
                        users.add(teacher);
                    }
                    writeToFile();
                    out.println("User saved - " + teacher);

                }catch(CredentialsException e){
                    e.printStackTrace();
                }

            }
        }
    }
    public void log_Student(Scanner sc, PrintStream out){
        out.println("Logged in as Student");
        out.println("Enter faculty number:");
        String fn = sc.nextLine();
        synchronized (userLock){
            for(User user : users){
                if(user.getUserType().equals(UserType.STUDENT) && user.getUsername().equals(fn)){
                    Student student = (Student) user;
                    List<Grade> grades = student.getGrades().stream().sorted(Comparator.comparingInt(Grade::getSemester)
                            .thenComparing(Grade::getSubject)).collect(Collectors.toList());
                    out.println(grades);
                }
            }
        }

    }

    public void writeToFile(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.bin"))){
            out.writeObject(users);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void readFromFile(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.bin"))){
            List<User> read = (List<User>) in.readObject();
            users.addAll(read);

        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

}
