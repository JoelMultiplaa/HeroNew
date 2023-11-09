import domain_model.Controller;
import domain_model.Database;
import data_source.Filehandler;
import userinterface.HeroUI;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        Controller controller = new Controller(db);
        HeroUI heroUI = new HeroUI(controller);
        Filehandler filehandler = new Filehandler();

        heroUI.startProgram();
    }
}