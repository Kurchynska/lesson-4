package abc;

public class ReverseString {

    public String revertString(String string){
        char[] arrText = string.toCharArray();
        String revString = "";
        for(int i = arrText.length-1; i >= 0; i--){
            revString+=arrText[i];
        }
        return revString;
    }
}
