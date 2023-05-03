public class Main {
    public static void main(String[] args) {
        ScholarModel model = new ScholarModel();
        ScholarView view = new ScholarView();
        ScholarController controller = new ScholarController(model, view);
        controller.getAuthorData();
    }
}
