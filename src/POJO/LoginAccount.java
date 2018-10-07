package POJO;

public class LoginAccount {
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    public LoginAccount(String username, String name, String password){
        if(name == null){
            this.firstName = null;
            this.lastName = null;
        }else{
            String[] names = name.split(" ");
            this.firstName = names[0];
            this.lastName = names[1];
        }
        this.username = username;

        this.password = password;
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
