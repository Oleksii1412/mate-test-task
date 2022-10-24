package akishev.reader;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class FileReaderImplTest {
    private static final String EXISTENT_CAR_PARAMETER_PATTERN
            = "ELECTRIC NISSAN; LEAF; 5.2; 220; 350; 60; 4";
    private static final String VALID_PATH_OF_INPUT_FILE = "src/test/resources/input.txt";
    private static final String INVALID_PATH_OF_INPUT_FILE = "test/resources/input.txt";
    private static FileReader fileReader;

    @BeforeAll
    static void beforeAll() {
        fileReader = new FileReaderImpl();
    }

    @Test
    public void readFromFile_ValidPath_Ok() {
        List<String> expected = new ArrayList<>();
        expected.add(EXISTENT_CAR_PARAMETER_PATTERN);
        List<String> actual = fileReader.readFromFile(VALID_PATH_OF_INPUT_FILE);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void readFromFile_NullPath_NotOk() {
        assertThrows(RuntimeException.class,
                () -> fileReader.readFromFile(null),
                "RuntimeException to be thrown, but nothing was thrown");
    }

    @Test
    public void readFromFile_InvalidPath_NotOk() {
        assertThrows(RuntimeException.class,
                () -> fileReader.readFromFile(INVALID_PATH_OF_INPUT_FILE),
                "RuntimeException to be thrown, but nothing was thrown");
    }
}
