public static int getMin(int arr[], int N) {
        int[] dp = new int[N];

        // Every student should get at least one chocolate
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // Traverse from left to right
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        // Traverse from right to left
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }

        // Sum up the total number of chocolates
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += dp[i];
        }

        return sum;
    }