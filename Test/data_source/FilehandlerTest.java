import data_source.Filehandler;
import domain_model.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class FilehandlerTest {
    @Test
    void loadFromCsvFile() {
        //ARRANGE
        Filehandler fileHandler = new Filehandler();
        //ACT
        ArrayList<Hero> actualResult = fileHandler.loadFromCsvFile();
        //ASSERT
        int expectedNumberOfHeroes = 5;
        Assertions.assertEquals(expectedNumberOfHeroes, actualResult.size());
        //Note, doesn't compare actual file content, only number of objects in file.
    }
}

