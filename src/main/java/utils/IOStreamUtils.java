package utils;
import java.util.Scanner;

public class IOStreamUtils {

    public String readString(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }
}
