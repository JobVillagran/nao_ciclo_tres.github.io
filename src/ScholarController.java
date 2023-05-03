import java.io.IOException;

public class ScholarController {
    private ScholarModel model;
    private ScholarView view;

    public ScholarController(ScholarModel model, ScholarView view) {
        this.model = model;
        this.view = view;
    }

    public void getAuthorData() {
        try {
            String authorId = view.getAuthorIdFromUser();
            String authorData = model.getAuthorData(authorId);
            view.displayAuthorData(authorData);
        } catch (IOException e) {
            view.displayError("Error while getting author data: " + e.getMessage());
        }
    }
}
