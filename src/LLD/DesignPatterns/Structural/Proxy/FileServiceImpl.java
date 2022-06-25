package LLD.DesignPatterns.Structural.Proxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileServiceImpl implements FileService {
    @Override
    public File getFile(String name) {
        System.out.println("Loading file from disk " + name);
        try {
            String filePath = "/Users/nishank soni/IdeaProjects/Leetcode/src/LLD/DesignPatterns/Strategy/Proxy/proxy.md";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String content = reader.readLine();
            reader.close();
            File file = new File();
            file.setContent(content);
            file.setFileName(name);
            file.setFilePath(file.getFilePath());
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
