package Coding.Amazon.LogicAndMaintainable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// File class as given in the problem
class File {
    String name;
    int size; // size in KB
    String type; // e.g., "xml", "txt"
    boolean isDirectory;
    File[] children;

    public File(String name, int size, String type, boolean isDirectory, File[] children) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.isDirectory = isDirectory;
        this.children = children;
    }
}

// FileFilter interface
interface FileFilter {
    boolean matches(File file);
}

// SizeFilter implementation
class SizeFilter implements FileFilter {
    private final int minSize;

    public SizeFilter(int minSize) {
        this.minSize = minSize;
    }

    @Override
    public boolean matches(File file) {
        return file.size > minSize;
    }
}

// TypeFilter implementation
class TypeFilter implements FileFilter {
    private final String fileType;

    public TypeFilter(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean matches(File file) {
        return file.type != null && file.type.equalsIgnoreCase(fileType);
    }
}

// FileFinder class
class FileFinder {
    public List<File> find(File directory, List<FileFilter> filters) {
        List<File> result = new ArrayList<>();
        if (!directory.isDirectory) {
            throw new IllegalArgumentException("Provided file is not a directory.");
        }
        findRecursive(directory, filters, result);
        return result;
    }

    private void findRecursive(File directory, List<FileFilter> filters, List<File> result) {
        for (File file : directory.children) {
            if (file.isDirectory) {
                findRecursive(file, filters, result);
            } else {
                if (matchesAllFilters(file, filters)) {
                    result.add(file);
                }
            }
        }
    }

    private boolean matchesAllFilters(File file, List<FileFilter> filters) {
        for (FileFilter filter : filters) {
            if (!filter.matches(file)) {
                return false;
            }
        }
        return true;
    }
}

// Test implementation
public class LinuxFindCommandSimulator {
    public static void main(String[] args) {
        // Sample file structure
        File file1 = new File("file1.txt", 6000, "txt", false, null);
        File file2 = new File("file2.xml", 2000, "xml", false, null);
        File file3 = new File("file3.xml", 7000, "xml", false, null);
        File subDir = new File("subDir", 0, null, true, new File[]{file3});
        File root = new File("root", 0, null, true, new File[]{file1, file2, subDir});

        // Filters: find files >5MB and of type "xml"
        FileFilter sizeFilter = new SizeFilter(5000); // > 5MB (5000 KB)
        FileFilter typeFilter = new TypeFilter("xml");

        // Finder instance
        FileFinder fileFinder = new FileFinder();
        List<File> result = fileFinder.find(root, Arrays.asList(sizeFilter, typeFilter));

        // Print results
        System.out.println("Matching files:");
        for (File file : result) {
            System.out.println(file.name);
        }
    }
}

