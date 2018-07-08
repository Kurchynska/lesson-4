package abc;

public class ReverseString {

    public String reverseString(String string){
        char[] arrText = string.toCharArray();
        String revertString = "";
        for(int i = arrText.length-1; i >= 0; i--){
            revertString+=arrText[i];
        }
        return revertString;
    }
}
