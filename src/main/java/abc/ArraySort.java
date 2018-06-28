package abc;

public class ArraySort {
    private int[] numbers = {55,38,525,3,22};

    public void printArray(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }

    public void arrBubble(int[] numbers){
        int a;
        for(int j = 0; j < numbers.length-1; j++){
            for(int i = 0; i < numbers.length-1; i++){
                if(numbers[i]>numbers[i+1]){
                    a = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = a;
                }
            }
        }
        printArray(numbers);
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
