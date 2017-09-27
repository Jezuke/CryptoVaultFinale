import java.util.*;
//CREDITS: TO spfy https://www.reddit.com/user/spfy
public class ZigZag
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many rows you would like: ");
        int rowsEn = sc.nextInt();
        
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter your message: ");
        String inputEnMes = sc1.nextLine();
        System.out.println(ZigZagEn(rowsEn, inputEnMes));
        
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the key row number: ");
        int rowsDe = sc2.nextInt();
        
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter your encrypted message: ");
        String inputDeMes = sc3.nextLine();
        System.out.println(ZigZagDe(rowsDe, inputDeMes));
        
    }
    
    private static String[] generateEmptyStrings(int num)
    {
        String[] strings = new String[num];
        for(int i = 0; i<num; i++)
        {
            strings[i] = "";
        }
        return strings;
    }
    
     private static String[] splitIntoLines(int numLines, String message, boolean encrypted)
    {
        String[] result = generateEmptyStrings(numLines);
        int lineCount = 0;
        int direction = -1;
        for (char c : message.toCharArray())
        {
            String letter = String.valueOf(c);
            /* if the message is already encrypted, use '?' as placeholder */
            result[lineCount] += encrypted ? "?" : letter;
            direction *= lineCount == 0 || lineCount == numLines - 1 ? -1 : 1;
            lineCount += direction;
        }
        return result;
    }
    
    public static String ZigZagEn(int key, String inputMes){
        
         String[] lines = splitIntoLines(key, inputMes, false);
        String result = "";
        for (String line : lines)
        {
            result += line;
        }
        return result;
        
    }
    
    public static String ZigZagDe(int key, String inputMes){
        
        String[] lines = splitIntoLines(key, inputMes, true);

        /* replace ?s with the actual letter */
        int charCount = 0;
        for (int i = 0; i < key; ++i)
        {
            while (lines[i].contains("?"))
            {
                String letter = String.valueOf(inputMes.charAt(charCount));
                lines[i] = lines[i].replaceFirst("\\?", letter);
                charCount++;
            }
        }

        /* condense zig-zag array into normal string */
        String result = "";
        int lineCount = 0;
        int direction = -1;
        for (int i = 0; i < inputMes.length(); ++i)
        {
            /* Add first letter to result by removing it from the line */
            String letter = String.valueOf(lines[lineCount].charAt(0));
            lines[lineCount] = lines[lineCount].substring(1);
            result += letter;
            direction *= lineCount == 0 || lineCount == key - 1 ? -1 : 1;
            lineCount += direction;
        }
        return result;
        
    }
    
}
