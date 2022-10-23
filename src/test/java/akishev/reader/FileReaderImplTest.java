package akishev.reader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderImplTest {
    private static final String EXISTENT_CAR_PARAMETER_PATTERN
            = "ELECTRIC NISSAN; LEAF; 5.2; 220; 350; 60; 4";
    private static final String PATH_OF_INPUT_FILE = "input.txt";
    private static FileReader fileReader;
    private static Path path;

    @BeforeAll
    static void beforeAll() {
        path = Path.of(PATH_OF_INPUT_FILE);
        fileReader = new FileReaderImpl();
    }

    @Test
    public void readFromFile_Ok() {
        /*List<String> expected = new ArrayList<>();
        expected.add(EXISTENT_CAR_PARAMETER_PATTERN);
        String filePath = new File("/input.txt").getAbsolutePath();
        List<String> readFromFile = fileReader.readFromFile();
        Assertions.assertNotNull(readFromFile);
        Assertions.assertEquals(expected, readFromFile);*/
    }

}