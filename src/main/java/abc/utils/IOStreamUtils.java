package abc.utils;
import java.util.Scanner;

public class IOStreamUtils {

    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }
}
