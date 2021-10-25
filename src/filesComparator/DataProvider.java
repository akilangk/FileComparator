package filesComparator;

//AdapteeClass
class DataProvider {
    private String folderPath;
    private int numberOfLinesInFileOne;
    private int numberOfLinesInFileTwo;
    private String fileOneText;
    private String fileTwoText;
    private int wordsCount;

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public int getNumberOfLinesInFileOne() {
        return numberOfLinesInFileOne;
    }

    public void setNumberOfLinesInFileOne(int numberOfLinesInFileOne) {
        this.numberOfLinesInFileOne = numberOfLinesInFileOne;
    }

    public int getNumberOfLinesInFileTwo() {
        return numberOfLinesInFileTwo;
    }

    public void setNumberOfLinesInFileTwo(int numberOfLinesInFileTwo) {
        this.numberOfLinesInFileTwo = numberOfLinesInFileTwo;
    }

    public String getFileOneText() {
        return fileOneText;
    }

    public void setFileOneText(String fileOneText) {
        this.fileOneText = fileOneText;
    }

    public String getFileTwoText() {
        return fileTwoText;
    }

    public void setFileTwoText(String fileTwoText) {
        this.fileTwoText = fileTwoText;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }
}
