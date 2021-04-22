package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadFile {
    public Properties properties;
    public Properties readFile(String path) throws FileNotFoundException {
        properties = new Properties();
        File  file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        return  properties;
    }
}
