import ControlPack.Controller;
import DataPack.Database;
import DataPack.Filehandler;
import HeroInfo.Hero;
import UiPack.HeroUI;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        Controller controller = new Controller(db);
        HeroUI heroUI = new HeroUI(controller);
        Filehandler filehandler = new Filehandler();

        heroUI.startProgram();
    }
}