package abc;

public class ArrayManager {

    public void arrBubbleSort(int[] numbers){
        int a;
        boolean flag;
        for(int j = 1; j < numbers.length; j++){
            flag = true;
            for(int i = 0; i < numbers.length-1; i++){
                if(numbers[i]>numbers[i+1]){
                    a = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = a;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
