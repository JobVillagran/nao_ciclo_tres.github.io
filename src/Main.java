import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String userId = "your-user-id-here";
        AuthorController authorController = new AuthorController();
        try {
            Author author = authorController.getAuthor(userId);
            AuthorView authorView = new AuthorView();
            authorView.showAuthor(author);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
