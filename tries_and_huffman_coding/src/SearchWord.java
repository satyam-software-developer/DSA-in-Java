/*Problem statement
Implement the function Search for the Trie class.

For a Trie, write the function for searching a word. Return true if the word is found successfully, otherwise return false.

Note : main function is given for your reference which we are using internally to test the code and all characters are from in small case (a-z). */

/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * where N is the length of the word to be searched
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Node class for the Trie data structure
class TrieNode {
    char data; // Character data for the node
    boolean isTerminating; // Flag to check if this node is the end of a word
    TrieNode children[]; // Array to hold children nodes (26 for each letter of the alphabet)
    int childCount; // Number of children this node has

    // Constructor for TrieNode
    public TrieNode(char data) {
        this.data = data;
        isTerminating = false; // Initially, the node does not terminate a word
        children = new TrieNode[26]; // Array for 26 possible children (one for each letter)
        childCount = 0; // Initially, no children
    }
}

public class SearchWord {

    private TrieNode root; // Root node of the Trie
    public int count; // Count of words in the Trie (not used in this code)

    // Constructor for SearchWord
    public SearchWord() {
        root = new TrieNode('\0'); // Initialize root node with null character
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        return search(root, word); // Call recursive search method
    }

    // Recursive helper method to search for a word in the Trie
    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) { // Base case: if the word is empty
            return root.isTerminating; // Return true if the node terminates a word
        }
        int childIndex = word.charAt(0) - 'a'; // Calculate index for the child node
        TrieNode child = root.children[childIndex]; // Get the child node
        if (child == null) { // If no such child node exists
            return false; // Word not found
        }
        return search(child, word.substring(1)); // Recursively search in the child node
    }

    // Helper method to add a word to the Trie
    private void add(TrieNode root, String word) {
        if (word.length() == 0) { // Base case: if the word is empty
            root.isTerminating = true; // Mark the node as terminating a word
            return;
        }
        int childIndex = word.charAt(0) - 'a'; // Calculate index for the child node
        TrieNode child = root.children[childIndex]; // Get the child node
        if (child == null) { // If no such child node exists
            child = new TrieNode(word.charAt(0)); // Create a new child node
            root.children[childIndex] = child; // Add the child node to the array
            root.childCount++; // Increment child count
        }
        add(child, word.substring(1)); // Recursively add the rest of the word
    }

    // Public method to add a word to the Trie
    public void add(String word) {
        add(root, word); // Call the recursive add method
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for user input

    public static void main(String[] args) throws IOException {
        SearchWord t = new SearchWord(); // Create an instance of SearchWord
        String[] string = br.readLine().split("\\s"); // Read input and split by whitespace
        int choice = Integer.parseInt(string[0]); // Get the choice of operation (1 for add, 2 for search)
        String word = "Null"; // Default word value
        if (string.length != 1) {
            word = string[1]; // Update the word if provided
        }

        // Loop to process user choices
        while (choice != -1) {
            switch (choice) {
                case 1: // Insert a word into the Trie
                    t.add(word); // Add the word to the Trie
                    break;
                case 2: // Search for a word in the Trie
                    System.out.println(t.search(word)); // Print true if found, false otherwise
                    break;
                default:
                    return; // Exit the program for invalid choices
            }
            string = br.readLine().split("\\s"); // Read next input
            choice = Integer.parseInt(string[0]); // Get the new choice
            if (string.length != 1) {
                word = string[1]; // Update the word if provided
            }
        }
    }

}
