package filesComparator;

//ClientClass
public class AppRunner {
    public static void main(String[] args) {
        FilesComparator run = new Implementor();
        run.createFolderPath();
        run.compareTextFiles();
        run.generateResultFile();
    }
}
