import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SortLL {
    static class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    };

    static class FastReader {

        BufferedReader br;
        StringTokenizer root;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine(), " ");
                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
            return root.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static FastReader sc = new FastReader();

    private static int t;
    private static int[] n;
    private static Node[] head;

    private static void takeInput() {
        t = 1;
        n = new int[t];
        head = new Node[t];
        for (int i = 0; i < t; i++) {
            n[i] = sc.nextInt();
            Node temp = null;
            while (n[i]-- > 0) {
                Node newNode = new Node(sc.nextInt());
                if (temp == null) {
                    head[i] = newNode;
                    temp = newNode;
                } else {
                    temp.next = newNode;
                    temp = temp.next;
                }
            }
        }
    }

    private static void execute() {
        for (int i = 0; i < t; i++) {
            sortList(head[i]);
        }
    }

    private static void executeAndPrintOutput() {
        for (int i = 0; i < t; i++) {
            Node ans = sortList(head[i]);
            printList(ans);
        }
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node sortList(Node head) {
        // Base cases: an empty list or a list with only one
        if (head == null || head.next == null) {
            return head;
        }
        // Divide the list into two halves
        Node ascHead = null;
        Node ascTail = null;
        Node descHead = null;
        Node descTail = null;

        Node temp = head;

        // Initialize the ascending and descending halves
        ascHead = ascTail = temp;
        temp = temp.next;
        descHead = descTail = temp;
        temp = temp.next;

        // Split the list into ascending and descending halves
        while (temp != null) {
            ascTail.next = temp;
            ascTail = ascTail.next;
            temp = temp.next;

            if (temp != null) {
                descTail.next = temp;
                descTail = descTail.next;
                temp = temp.next;
            }
        }
