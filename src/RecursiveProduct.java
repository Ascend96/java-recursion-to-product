public class RecursiveProduct {

    // technique to support a default index value of 0 since java does not support defaults
    // for parameters
    public static int findProduct(int[] numbers) {
        return findProduct(numbers, 0);
    }


    // to find the product of a list of numbers, we multiply all of them together
    private static int findProduct(int[] numbers, int index) {
        // base case
        // if the length of the array is reached, return 1 so that the product is not affected
        if (index == numbers.length) {
            return 1;
        }

        // recursive case
        // the index functions as our progress towards the base case to prevent infinite recursion
        // when the index reaches the end of the array, we return 1 to prevent the product from being affected
        return numbers[index] * findProduct(numbers, index + 1);
    }
}
