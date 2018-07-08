package abc;
import java.util.Arrays;

public class ArrayUnitTasksResults {
    public static void main(String[] args){
        ReverseString stringManager = new ReverseString(); //Task 1: Revert string
        String string = "Some text for revert";
        String revertString = stringManager.reverseString(string);
        System.out.println("Task 1: Revert string:\n" + string + "\nResult:\n" + revertString);

        ArrayManager arraySort = new ArrayManager();      //Task 2: Sort array ASC
        int[] numbers = {55,38,525,3,22};
        System.out.println("\nTask 2: Sort array ASC \n" + Arrays.toString(numbers));
        arraySort.arrBubbleSort(numbers);
        System.out.println( "Result:\n" + Arrays.toString(numbers));
    }
}
