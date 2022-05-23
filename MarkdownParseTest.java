import static org.junit.Assert.*;
import java.nio.file.Path;
import org.junit.*;
import java.nio.file.Files;
import java.util.*;
import java.io.IOException;



public class MarkdownParseTest {
    ArrayList<String> expectedlinks; //ArrayList utilized by tests 1, 2, 3, and 4

    @Before
    public void setup() {
        //Populate array with desired output
        expectedlinks = new ArrayList<>();
        expectedlinks.add("https://something.com");
        expectedlinks.add("some-thing.html");
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    /*
    / Test markdown file w/ two links present
    */
    @Test
    public void testMarkdownParseFile1() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ two links and an image present
    */
    @Test
    public void testMarkdownParseFile2() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file2.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ two links, an image present, and no title
    */
    @Test
    public void testMarkdownParseFile3() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file3.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ two links and an image present, with extra space at the end
    */
    @Test
    public void testMarkdownParseFile4() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file4.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            for (int i = 0; i < parsedLinks.size(); ++i) {
                assertEquals(expectedlinks.get(i), parsedLinks.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ no links present
    */
    @Test
    public void testMarkdownParseFile5() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file5.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ no links present, but empty brackets are present
    */
    @Test
    public void testMarkdownParseFile6() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file6.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ no links present, but lines that look like links
    */
    @Test
    public void testMarkdownParseFile7() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file7.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    /*
    / Test markdown file w/ only ")[" present, not a link
    */
    @Test
    public void testMarkdownParseFile8() {
        Path filePath = Path.of("C:/Users/drake/OneDrive/Documents/GitHub/markdown-parser-fork/test-file8.md");

        try {
            String fileContents = Files.readString(filePath);
            ArrayList<String> parsedLinks = MarkdownParse.getLinks(fileContents);

            assertEquals(0, parsedLinks.size());
        } catch (Exception e) {
            System.out.println("Error: file not found!");
        }

    }

    @Test
    public void testMarkdownParseSnippet1() throws IOException {
        Path whichTest = Path.of("snippet1.md");
        String contents = Files.readString(whichTest);
        ArrayList<String> inputResult = MarkdownParse.getLinks(contents);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), inputResult);
    }

    @Test
    public void testMarkdownParseSnippet2() throws IOException{
        Path whichTest = Path.of("snippet2.md");
        String contents = Files.readString(whichTest);
        ArrayList<String> inputResult = MarkdownParse.getLinks(contents);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), inputResult);

    }
    @Test
    public void testMarkdownSnippet3() throws IOException{
        Path whichTest = Path.of("snippet3.md");
        String contents = Files.readString(whichTest);
        ArrayList<String> inputResult = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://www.twitter.com", "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "https://cse.ucsd.edu/"), inputResult);

    }

}