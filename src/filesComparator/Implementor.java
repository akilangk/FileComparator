package filesComparator;

import org.json.JSONObject;

import java.io.*;

//AdapterClass
class Implementor extends DataProvider implements FilesComparator {

    public void createFolderPath() {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        setFolderPath(userDirectory + pathSeparator + "src" + pathSeparator + "filesComparator" + pathSeparator + "files" + pathSeparator);
    }

    public void compareTextFiles() {
        String fileOnePath = getFolderPath() + "file1.txt";
        String fileTwoPath = getFolderPath() + "file2.txt";
        StringBuilder fileOne = new StringBuilder();
        StringBuilder fileTwo = new StringBuilder();
        String lineOfFileOne;
        String lineOfFileTwo;
        int numberOfLinesInFileOne = 0, numberOfLinesInFileTwo = 0;
        int wordsCount = 0;
        try {
            Reader pathOfFileOne = new FileReader(fileOnePath);
            Reader pathOfFileTwo = new FileReader(fileTwoPath);
            BufferedReader fileOneReaderObject = new BufferedReader(pathOfFileOne);
            BufferedReader fileTwoReaderObject = new BufferedReader(pathOfFileTwo);
            while ((lineOfFileOne = fileOneReaderObject.readLine()) != null) {
                String[] wordsInFileOne = lineOfFileOne.split(" ");
                wordsCount += wordsInFileOne.length;
                fileOne.append(lineOfFileOne);
                numberOfLinesInFileOne++;
            }
            while ((lineOfFileTwo = fileTwoReaderObject.readLine()) != null) {
                fileTwo.append(lineOfFileTwo);
                numberOfLinesInFileTwo++;
            }
            fileOneReaderObject.close();
            pathOfFileOne.close();
            fileTwoReaderObject.close();
            pathOfFileTwo.close();
            String fileOneText = fileOne.toString();
            String fileTwoText = fileTwo.toString();
            setNumberOfLinesInFileOne(numberOfLinesInFileOne);
            setNumberOfLinesInFileTwo(numberOfLinesInFileTwo);
            setFileOneText(fileOneText);
            setFileTwoText(fileTwoText);
            setWordsCount(wordsCount);

        } catch (FileNotFoundException exception) {
            System.out.println("Check the file in the given path...");
        } catch (IOException exception) {
            System.out.println("Check the file path");
        } catch (NullPointerException exception) {
            System.out.println();
        }
    }

    public void generateResultFile() {
        try {
            if (getNumberOfLinesInFileOne() == getNumberOfLinesInFileTwo()) {
                if (getFileOneText().equals(getFileTwoText())) {
                    String resultFilePath = getFolderPath() + "result.json";
                    Writer pathOfResultFile = new FileWriter(resultFilePath);
                    BufferedWriter resultFileWriterObject = new BufferedWriter(pathOfResultFile);
                    JSONObject writeToResultFile = new JSONObject();
                    System.out.println("File1 and File2 are same.");
                    System.out.println("\nGenerating result file in JSON..");
                    String result = "Number of words in the file:";
                    writeToResultFile.put(result, getWordsCount());
                    resultFileWriterObject.write(writeToResultFile.toString());
                    resultFileWriterObject.close();
                    System.out.println("\nFile Generated Successfully.");
                } else {
                    System.out.println("File1 and File2 are different.");
                }
            } else {
                System.out.println("File1 and File2 are different.");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
