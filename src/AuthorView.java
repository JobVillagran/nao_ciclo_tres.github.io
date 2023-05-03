import javax.swing.JOptionPane;

public class AuthorView {
    public void showAuthor(Author author) {
        String message = "Name: " + author.getName() + "\n" +
                "Affiliation: " + author.getAffiliation() + "\n" +
                "Email: " + author.getEmail() + "\n" +
                "Citations: " + author.getCitations();
        JOptionPane.showMessageDialog(null, message);
    }
}
