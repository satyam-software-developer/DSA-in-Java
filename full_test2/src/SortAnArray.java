
/* Problem statement
Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:

The first line contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array. 
Output Format:

Print the soted array seperated by a space.
Example:
Input:
6
1 2 2 2 3 3
Output:
2 2 2 3 3 1 */
import java.util.*;

public class SortAnArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }

        // Create a map to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        // Assign elements and their count in the list and map
        for (int current : array) {
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
        }

        // Implement Comparator to sort the values by frequency and then by value
        class SortComparator implements Comparator<Integer> {
            private final Map<Integer, Integer> freqMap;

            // Assign the specified map
            SortComparator(Map<Integer, Integer> tFreqMap) {
                this.freqMap = tFreqMap;
            }

            // Compare the values
            @Override
            public int compare(Integer k1, Integer k2) {
                // Compare value by frequency
                int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

                // Compare value if frequency is equal
                int valueCompare = k1.compareTo(k2);

                // If frequency is equal, then just compare by value, otherwise
                // compare by the frequency.
                if (freqCompare == 0) {
                    return valueCompare;
                } else {
                    return freqCompare;
                }
            }
        }

        // Create a comparator using the map
        SortComparator comp = new SortComparator(map);

        // Sort the list using the comparator
        Collections.sort(outputArray, comp);

        // Final Output
        for (Integer i : outputArray) {
            System.out.print(i + " ");
        }
    }
}
