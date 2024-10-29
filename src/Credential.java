public class Credential {
    private String website;
    private String username;
    private String password;

    // constructor
    public Credential(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method for displaying credentials
    @Override
    public String toString() {
        return "Website: " + website +", Username: " + username + ", Password: " + password;
    }
}
