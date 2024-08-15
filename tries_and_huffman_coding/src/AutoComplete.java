
/* Problem statement
Given n number of words and an incomplete word w. You need to auto-complete that word w.

That means, find and print all the possible words which can be formed using the incomplete word w.

Note : Order of words does not matter.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains an integer, that denotes the value of n.
The following line contains n space separated words.
The following line contains the word w, that has to be auto-completed.
Output Format :
Print all possible words in separate lines.
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 1 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom" */

/*
 * Time complexity: O(N * M)
 * Space complexity: O(N * M)
 * 
 * where N is the number of  words in the Trie and M is the average word length
 */

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

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

public class AutoComplete {
    private TrieNode root; // Root node of the Trie

    // Constructor for AutoComplete
    public AutoComplete() {
        root = new TrieNode('\0'); // Initialize root node with null character
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

    // Method to find the Trie node corresponding to the given word prefix
    private TrieNode findRoot(TrieNode root, String word) {
        if (word.length() == 0) {
            return root;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return null;
        }
        return findRoot(child, word.substring(1));
    }

    // Method to auto-complete the given word
    public void autoComplete(ArrayList<String> input, String word) {
        for (String w : input) {
            add(w);
        }
        TrieNode node = findRoot(root, word);
        if (node == null || node.childCount == 0) {
            return;
        }
        allRootToLeafPaths(node, "", word);
    }

    // Helper method to find all root to leaf paths from the given node
    private void allRootToLeafPaths(TrieNode node, String output, String word) {
        if (node.childCount == 0) {
            if (output.length() > 0) {
                System.out.println(word + output);
            }
            return;
        }
        if (node.isTerminating) {
            System.out.println(word + output);
        }
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                String ans = output + node.children[i].data;
                allRootToLeafPaths(node.children[i], ans, word);
            }
        }
    }

    // Main method to take input and execute the auto-complete functionality
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AutoComplete t = new AutoComplete();
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> input = new ArrayList<String>();
        String[] words = sc.nextLine().split("\\s");
        for (int i = 0; i < n; i++) {
            input.add(words[i]);
        }
        String pattern = sc.nextLine();
        t.autoComplete(input, pattern);
    }
}
