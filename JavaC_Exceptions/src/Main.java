public class Main {
    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        try{
            repo.addUser("Kijg", "45");
            repo.addUser("vi", "45");
            repo.addUser("mi", "45");
            repo.addUser("Ki", "45");
        }catch(BadCredentialsException e){
            e.printStackTrace();
        }catch (TooManyUsersException e){
            System.out.println(e);
        }finally {
            System.out.println("END");
        }

    }
}