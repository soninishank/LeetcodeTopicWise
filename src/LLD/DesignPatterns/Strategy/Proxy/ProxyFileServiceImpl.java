package LLD.DesignPatterns.Strategy.Proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyFileServiceImpl implements FileService {

    Map<String, File> cachingFiles = new HashMap<>();
    FileService fileService = new FileServiceImpl();

    @Override
    public File getFile(String name)
    {
        if (cachingFiles.containsKey(name)){
            return cachingFiles.get(name);
        }
        File file = fileService.getFile(name);
        if (file == null) {
            return null;
        }
        cachingFiles.putIfAbsent(file.getFileName(), file);
        return file;
    }
}
