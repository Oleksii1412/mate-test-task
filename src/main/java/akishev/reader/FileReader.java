package akishev.reader;

import java.util.List;

public interface FileReader {
    List<String> readFromFile(String filename);
}
