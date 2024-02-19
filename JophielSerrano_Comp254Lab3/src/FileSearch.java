import java.io.File;

public class FileSearch {

    public static void find(String path, String filename) {
        File file = new File(path);

        // Check if the given path is a file with the desired filename
        if (file.isFile() && file.getName().equals(filename)) {
            System.out.println("Found: " + file.getAbsolutePath());
        }

        // Check if the given path is a directory
        else if (file.isDirectory()) {
            // Iterate over all entries in the directory
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    // Recursively call the find function for each entry
                    find(entry.getAbsolutePath(), filename);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage: Replace "your_path" and "your_filename" with actual values
        find("C:/TestSearch", "FoundMe.txt");
    }
}