
/*Problem statement
You are given the Trie class with following functions -

1. insertWord

2. removeWord

Now, you need to create one more function (named "countWords" ) which returns the number of words currently present in Trie in O(1) time complexity.

Note : You can change the already given functions in the Trie class, if required.. */

/*
 * Time complexity: O(N * M)
 * Space complexity: O(N * M)
 * 
 * where N is the number of words in the Trie and M is the average word length
 */
import java.io.IOException;
import java.util.Scanner;

// Class representing a node in the Trie
class TrieNode {
    char data; // Character stored in the node
    boolean isTerminating; // Flag indicating if this node marks the end of a word
    TrieNode children[]; // Array to store child nodes for each letter a-z
    int childCount; // Number of children this node has

    // Constructor to initialize a TrieNode with a given character
    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26]; // Each node can have 26 children (for each letter a-z)
        childCount = 0;
    }
}

// Class to manage the Trie and count words
public class CountWordsInTrie {

    private TrieNode root; // Root node of the Trie
    private int numWords; // Counter to keep track of the number of words in the Trie

    // Constructor to initialize the Trie with a root node
    public CountWordsInTrie() {
        root = new TrieNode('\0'); // Root node with an empty character
        numWords = 0;
    }

    // Method to remove a word from the Trie
    public void remove(String word) {
        if (remove(root, word)) {
            numWords--; // Decrement the word count if the word was successfully removed
        }
    }

    // Helper method to remove a word from the Trie starting from a given node
    private boolean remove(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminating) {
                root.isTerminating = false; // Unmark the terminating flag
                return true;
            } else {
                return false;
            }
        }
        int childIndex = word.charAt(0) - 'a'; // Calculate index of the child node
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false; // Word not found
        }
        boolean ans = remove(child, word.substring(1));
        
        // We can remove child node only if it is non-terminating and its number of children are 0
        if (!child.isTerminating && child.childCount == 0) {
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
        return ans;
    }

    // Helper method to add a word to the Trie starting from a given node
    private boolean add(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminating) {
                return false; // Word already exists
            } else {
                root.isTerminating = true; // Mark the terminating flag
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'a'; // Calculate index of the child node
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        return add(child, word.substring(1));
    }

    // Public method to add a word to the Trie
    public void add(String word) {
        if (add(root, word)) {
            numWords++; // Increment the word count if the word was successfully added
        }
    }

    // Method to get the number of words in the Trie
    public int countWords() {
        return numWords;
    }

    // Static scanner for input
    static Scanner sc = new Scanner(System.in);

    // Main method to run the program
    public static void main(String[] args) throws IOException {
        CountWordsInTrie t = new CountWordsInTrie(); // Create an instance of the Trie
        String[] string = sc.nextLine().split("\\s"); // Read and split input line

        int choice = Integer.parseInt(string[0]); // First element is the choice
        String word = "Null"; // Default word
        if (string.length != 1) {
            word = string[1]; // Second element is the word
        }

        // Loop to process input commands
        while (choice != -1) {
            switch (choice) {
                case 1: // Insert
                    t.add(word);
                    break;
                case 2: // Remove
                    t.remove(word);
                    break;
                case 3: // Count words
                    System.out.println(t.countWords());
                    break;
                default: // Exit on invalid choice
                    return;
            }

            string = sc.nextLine().split("\\s"); // Read and split next input line
            choice = Integer.parseInt(string[0]); // Update choice
            if (string.length != 1) {
                word = string[1]; // Update word
            }
        }
    }
}
