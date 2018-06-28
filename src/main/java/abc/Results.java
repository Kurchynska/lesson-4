package abc;

public class Results {
    public static void main(String[] args){
        ReverseString reverseString = new ReverseString(); //Task 1: Revert string
        String text = reverseString.getText();
        ArraySort arraySort = new ArraySort();             //Task 2: Sort array ASC
        int[] numbers = arraySort.getNumbers();

        System.out.println("Task 1: Revert string:");
        System.out.println(text);
        System.out.println("Result:");
        reverseString.reverString(text);
        System.out.println("======================");
        System.out.println("Task 2: Sort array ASC");
        arraySort.printArray(numbers);
        System.out.println("Result:");
        arraySort.arrBubble(numbers);
    }
}
