import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Spellchecker {
	private BinarySearchTree<String> wordTree;

    public Spellchecker() {
        wordTree = new BinarySearchTree<>();
        scanWordsList();
    }

    private void scanWordsList() {
        try {
            File file = new File("wordList.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String word = removePunctAndDowncase(line.trim());
                if (!word.isEmpty()) {
                    wordTree.add(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading wordList.txt: " + e.getMessage());
            System.exit(1);
        }
    }
    
	private String removePunctAndDowncase(String input) {
	    String punctuation = ".,?!-\";:()%$#@";
	    String output = input.replaceAll("[" + punctuation + "]", "");
	    output = output.replaceAll("’", "'");
	    return output.toLowerCase();
	}
	
	public boolean isWordInDict(String word) {
        String cleanWord = removePunctAndDowncase(word);
        return wordTree.search(cleanWord) != null;
    }
}
