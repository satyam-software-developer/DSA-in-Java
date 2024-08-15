/* Problem statement
Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains an integer, that denotes the value of n.
The following line contains n space-separated words.
The following line contains a string, that denotes the value of the pattern p.
Output Format :
The first and only line of output contains true if the pattern is present and false otherwise.
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
de
Sample Output 1 :
true
Sample Input 2 :
4
abc def ghi hg
hi
Sample Output 2 :
true
Sample Input 3 :
4
abc def ghi hg
hif
Sample Output 3 :
false */
/*
 * Time complexity: O(N * M)
 * Space complexity: O(N * M)
 * 
 * where N is the number of words in the Trie and M is the average word length
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Class representing a node in the Trie
class TrieNode {
    char data; // Character stored in the node
    boolean isTerminating; // Flag indicating if this node marks the end of a word
    TrieNode children[]; // Array to store child nodes for each letter a-z
    int childCount; // Number of children this node has

    // Constructor to initialize a TrieNode with a given character
    public TrieNode(char data) {
        this.data = data; // Assign the character to the node
        isTerminating = false; // Initially, the node does not mark the end of a word
        children = new TrieNode[26]; // Each node can have 26 children (for each letter a-z)
        childCount = 0; // Initially, there are no children
    }
}

// Main class to handle pattern matching using Trie
public class PatternMatching {
    private TrieNode root; // Root node of the Trie
    public int count; // Count of words in the Trie (not used in this code)

    // Constructor for PatternMatching
    public PatternMatching() {
        root = new TrieNode('\0'); // Initialize root node with null character
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        return search(root, word); // Call recursive search method
    }

    // Recursive helper method to search for a word in the Trie
    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) { // Base case: if the word is empty
            return true; // Return true if the node terminates a word
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

    // Method to check if a pattern matches any substring of words in the list
    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Add all suffixes of each word to the Trie
        for (int i = 0; i < vect.size(); i++) {
            String word = vect.get(i);
            for (int j = 0; j < word.length(); j++) {
                add(word.substring(j)); // Add each suffix of the word to the Trie
            }
        }
        return search(pattern); // Search for the pattern in the Trie
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Reader for input

    public static void main(String[] args) throws IOException {
        PatternMatching t = new PatternMatching(); // Create an instance of PatternMatching
        int n = Integer.parseInt(br.readLine().trim()); // Read the number of words
        ArrayList<String> input = new ArrayList<String>(); // List to store the input words
        String[] words = br.readLine().split("\\s"); // Split the input line into words
        for (int i = 0; i < n; i++) {
            input.add(words[i]); // Add each word to the list
        }
        String pattern = br.readLine(); // Read the pattern to be matched
        System.out.println(t.patternMatching(input, pattern)); // Print the result of pattern matching
    }
}
