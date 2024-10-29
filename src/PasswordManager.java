import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private final List<Credential> credentials;

    // character sets for strong password generation
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    // constructor
    public PasswordManager(){
        this.credentials = new ArrayList<>();
    }

    // add new credentials
    public void addCredentials(Credential credential) {
        credentials.add(credential);
        System.out.println("Credential added successfully!");
    }

    // display all credentials
    public void displayCredentials() {
        if(credentials.isEmpty()){
            System.out.println("No credentials found.");
        } else {
            for (Credential credential: credentials) {
                System.out.println(credential);
            }
        }
    }

    // generate a strong password

    int PASSWORD_LENGTH = 16;

    public String generateStrongPassword(){
        String charSet = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        // ensure at least one character from each set is included;
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // fill the rest of the password with random characters from the full set
        for(int i = 4; i < PASSWORD_LENGTH; i++){
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        // shuffle the password to ensure randomness
        return shuffleString(password.toString());
    }

    // helper function for shuffling password string
    public String shuffleString(String input){
        List<Character> characters = new ArrayList<>();
        for(char c: input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(!characters.isEmpty()){
            int randIndex = (int) (Math.random() * characters.size());
            output.append(characters.remove(randIndex));
        }
        return output.toString();
    }
}
