package akishev.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("Path of file cannot be null!");
        }
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new java.io.FileReader(filePath))) {
            while (reader.ready()) {
                data.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);
        }
        return data;
    }
}
