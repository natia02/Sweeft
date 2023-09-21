import java.util.HashSet;

public class Main {

    public static int singleNumber1(int[] nums){
        int n = 0;
        for(int i : nums){
            n = n ^ i;
        }

        return n;
    }

    public static int singleNumber2(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            if(!set.add(i)){
                set.remove(i);
            }
        }

        return set.iterator().next();
    }

    public static int minSplit(int amount) {
        int[] coins = {50, 20, 10, 5, 1};
        int count = 0;

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                count++;
            }
        }

        return count;
    }

    public static int notContains(int[] array){
        int min = array[0];
        HashSet<Integer> set = new HashSet<>();

        for (int i : array){
            set.add(i);
            if(i < min){
                min = i;
            }
        }

        if(min - 1 > 0){
            return min - 1;
        }else{
            int n = min +1;
            while (set.contains(n) || n <= 0){
                n++;
            }
            min = n;
        }
        return min;
    }

    public static String binarySum(String a, String b){
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            if (sum == 0 || sum == 1) {
                result.append(sum);
                carry = 0;
            }
            else if (sum == 2) {
                result.append("0");
                carry = 1;
            }
            else {
                result.append("1");
                carry = 1;
            }
            i--;
            j--;
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    public static int countVariants(int stearsCount){
        if(stearsCount == 0 || stearsCount == 1){
            return 1;
        }

        return countVariants(stearsCount - 1) + countVariants(stearsCount - 2);
    }

    public static void main(String[] args) {
        // Test singleNumber1
        int[] nums = {4, 1, 2, 1, 2, 4, 5};
        int result1 = singleNumber1(nums);
        int result2 = singleNumber2(nums);
        System.out.println("Single Number (Method 1): " + result1);
        System.out.println("Single Number (Method 2): " + result2);

        // Test minSplit
        int amount = 73;
        int splitCount = minSplit(amount);
        System.out.println("Minimum Split Count for " + amount + " cents: " + splitCount);

        // Test notContains
        int[] array = {1, 3, 6, 4, 1, 2};
        int missingNumber = notContains(array);
        System.out.println("Smallest positive integer not in the array: " + missingNumber);

        // Test binarySum
        String binary1 = "1101";
        String binary2 = "1011";
        String sum = binarySum(binary1, binary2);
        System.out.println("Binary Sum: " + sum);

        // Test countVariants
        int stairsCount = 4;
        int variants = countVariants(stairsCount);
        System.out.println("Number of Variants for " + stairsCount + " stairs: " + variants);

        //Test for MyStructure
        MyStructure<Integer> myIntStructure = new MyStructure<>();

        // Add some elements
        myIntStructure.add(1);
        myIntStructure.add(2);
        myIntStructure.add(3);

        // Check if elements are present
        System.out.println("Contains 2: " + myIntStructure.contains(2));
        System.out.println("Contains 4: " + myIntStructure.contains(4));

        // Remove an element
        myIntStructure.delete(2);

        // Check if the removed element is no longer present
        System.out.println("Contains 2 after removal: " + myIntStructure.contains(2));
    }

}