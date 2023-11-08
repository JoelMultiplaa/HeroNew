import domainmodel.Controller;
import domainmodel.Database;
import ui.ui;
public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        Controller controller = new Controller(db);
        ui heroUI = new ui (controller);
        heroUI.startProgram();

    }
}