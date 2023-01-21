public class UserRepository {
    User[] users;
    int count;

    public UserRepository(){
        users = new User[3];
        count = 0;
    }

    public void addUser(String username, String password) throws BadCredentialsException, TooManyUsersException {


        if(username.length() >3 || password.length() >3){
            throw new BadCredentialsException("Invalid input");
        }if(count >= 3){
            throw new TooManyUsersException("Too many users");
        }
            users[count] = new User(username, password);
            count++;

    }
}
