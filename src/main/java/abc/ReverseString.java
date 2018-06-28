package abc;

public class ReverseString {
    private String text = "Some text for revert";

    public void reverString(String text){
        String[] arrText = text.split("");
        for(int i = arrText.length-1; i >= 0; i--){
            System.out.print(arrText[i]);
        }
        System.out.println();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
