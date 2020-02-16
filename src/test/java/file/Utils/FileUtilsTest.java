package file.Utils;

import file.utils.FileTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {
    private final int NUMBER_OF_FILE_LINES = 3;
    private final String pathtoFile = this.getClass().getResource("/fileUtils/text.txt").getPath();
    private final String firstLine = "W czasie suszy szosa sucha";

    @Test
    protected void testIfNumberOfLineAreEquals() {

        String fileContent = FileTool.getFileContent(pathtoFile);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(NUMBER_OF_FILE_LINES, split.length);
    }

    @Test
    protected void howDoesSplitWorks() {
        String textToSplit = "1, 2, 3, 4, 5";
        String[] split = textToSplit.split(",");
        for (String s : split) {
            System.out.printf(s + "  ");
        }

    }

    @Test
    protected void testIfNumberOfLineAreEquals1() {

        String fileContent = FileTool.getFileContent(pathtoFile);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(firstLine, split[0]);
    }

}
