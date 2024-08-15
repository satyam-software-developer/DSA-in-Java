/*Problem statement
Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, which itself is a palindrome or not.

Note: The function should return either true or false. You don't have to print anything.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of the test case contains an integer value denoting 'n'.

The following contains 'n' number of words each separated by a single space.
Output Format :
The first and only line of output contains true if the conditions described in the task are met and false otherwise.
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
Sample Output 1 :
true
Explanation of Sample Input 1:
"abc" and "cba" forms a palindrome
Sample Input 2 :
2
abc def
Sample Output 2 :
false
Explanation of Sample Input 2:
Neither their exists a pair which forms a palindrome, nor any of the words is a palindrome in itself. Hence, the output is 'false.' */

/*
 * ----------The Approach We Have Taken To Implement This Problem ------------------
 * 
 * The approach we have taken to solve this problem is to store
 * the reverse of each of the words in the Trie. We then iterate
 * over the words and search that does the Trie contains the same 
 * word or not .
 * 
 * It may happen that some parts of the word or a substring exist
 * in the Trie. We check for the remaining part of the string to 
 * be a palindrome or not.
 * 
 * Vise versa of the above will also be true , that means, it may
 * happen that the word in the Trie may extend further over
 * different number of branches, hence we check all the branches
 * one by one to see if any of the branches make a palindrome.
 */

/*
 * ------Another Possible Solution Could Be------------
 There's another way of solving this problem.It goes like this. First and 
 the reverse of every word in the trie. Then for every word, search it in
 the trie. If you find it, then that means the word was a palindrome itself
 and you can return true. If you don't find it , you need the length of the 
 part that you did find. For example, you're searching for "abcdd" in the 
 trie, you didn't find a match for "abcdd" but you found the word "abc" in
 the trie. Finding "abc" in the trie means that the actual word was "cba"
 since we inserted the reverse of every word in the list.
 Now, you have the word "abcdd", you found the word "abc" in the trie. If you
 can find whether the part of "abcdd" that comes after "abc" , i.e. "dd" is a 
 palindrome, you can conclude that concatenating "abcdd" and "cba" will also
 give a palindrome. So you can return true. If the part isn't a palindrome,
 you move to check for the next word.
 If you traverse through all words without finding a pair of words that 
 combine to form a palindrome or a word that's a palindrome by itself, then 
 you can return false.
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class PalindromePair {
    private TrieNode root; // Root node of the Trie
    public int count; // Count of words in the Trie (not used in this code)

    // Constructor for SearchWord
    public PalindromePair() {
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

    // Method to search for a word in the Trie
    public boolean search(String word) {
        return search(root, word); // Call recursive search method
    }

    private void print(TrieNode root, String word) {
        if (root == null) {
            return;
        }
        if (root.isTerminating) {
            System.out.println(word);
        }
        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }

    public void print() {
        print(this.root, "");
    }

    /*-----------Palindrome Pair ............ */
    public boolean isPalindromePair(ArrayList<String> words) {
        for (String word : words) {
            this.add(reverseWord(word));
        }
        return isPalindromePair(this.root, words);
    }

    private static String reverseWord(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        return reverse;
    }

    private boolean isPalindromePair(TrieNode root, ArrayList<String> words) {
        if (words == null || words.size() == 0) {
            return false;
        }
        for (String word : words) {
            if (doesPairExistFor(root, word, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesPairExistFor(TrieNode root, String word, int startIndex) {
        // Since an empty string is always a palindrome , we return 'true'
        if (word == "") {
            return true;
        }

        if (startIndex == word.length()) {
            if (root.isTerminating) {
                /*
                 * when there exists an exact match of the word we are
                 * searching for in the Trie, irrespective of the trie
                 * extends further in the same path.
                 */
                return true;
            }
            /*
             * when trie extends further, there doesnt exist an exact
             * match of the string we are looking for.
             * However, it may happen that any of the branch
             * extending from root may form a palindrome.
             */
            return checkRemainingBranchesInTrie(root, "");
        }

        int charIndex = word.charAt(startIndex) - 'a';
        TrieNode correspondingChild = root.children[charIndex];

        if (correspondingChild == null) {
            /*
             * This means that , down the line in the characters that we are looking
             * for against the word in the trie , the charcater doesn't exist in the trie.
             * This character can be anywhere in the range [0 - (word length - 1)]
             */
            if (root.isTerminating) {
                return checkWordForPalindrome(word.substring(startIndex));
            }
            return false;
        }
        return doesPairExistFor(correspondingChild, word, (startIndex + 1));
    }

    private boolean checkRemainingBranchesInTrie(TrieNode root, String word) {
        /*
         * This function recursively explores all the branches from the root
         * while keeping a track of the characters in the 'word' and checks
         * each word whenever the treminating condition is true .
         * 
         * If the word is a palindrome , we return true and stops exploring the
         * other branches. If it is otherwise , we keep on checking the remaining
         * branches.
         * 
         * Once all the branches are explored, and we don't find any branch or
         * word that makes itself a palindrome we return false at last.
         * 
         */
        if (root.isTerminating) {
            if (checkWordForPalindrome(word)) {
                return true;
            }
        }
        for (TrieNode chilNode : root.children) {
            if (chilNode == null) {
                continue;
            }
            String fwd = word + chilNode.data;
            if (checkRemainingBranchesInTrie(chilNode, fwd)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkWordForPalindrome(String word) {
        int startIndex = 0;
        int endIndex = word.length() - 1;

        while (startIndex < endIndex) {
            if (word.charAt(startIndex) != word.charAt(endIndex)) {
                return false;

            }
            startIndex += 1;
            endIndex -= 1;
        }
        return true;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static ArrayList<String> takeInput() throws IOException {
        ArrayList<String> words = new ArrayList<>();

        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return words;
        }

        String[] listOfWords;
        listOfWords = br.readLine().split("\\s");

        for (int i = 0; i < n; ++i) {
            words.add(listOfWords[i]);
        }

        return words;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        PalindromePair root = new PalindromePair();

        ArrayList<String> words = takeInput();
        System.out.println(root.isPalindromePair(words));
    }

}