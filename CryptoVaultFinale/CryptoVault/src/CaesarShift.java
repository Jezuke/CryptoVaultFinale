import java.util.*;
import java.util.Collections;
import java.util.ArrayList; 
//

public class CaesarShift{
    
    public static String caesarCiphEn(String msg, char keyEn){
    char [] caesar = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    List<Character> caesarDup = new ArrayList<Character>();
    List<Character> msgHolder = new ArrayList<Character>();
    for(int i = 0; i<caesar.length; i++)
    {
        caesarDup.add(caesar[i]);

    }//CREATES AN ARRAYLIST FOR SHIFTING THE CIPHER
    
    int shift = 0;
    for( int j = 0; j < caesar.length; j++)
        {
            
            if(keyEn==(caesar[j]))
            {
                shift = j;
            }
        }//SHIFTER METHOD USING KEY
        
    for(int m = 0; m<msg.length(); m++)
    {
        msgHolder.add(msg.charAt(m));
    }//CREATES THE STRING ARRAYLIST
        
    Collections.rotate(caesarDup, -shift); //ROTATES CIPHER ACCORDING TO KEY
    for(int l = 0; l<msgHolder.size(); l++)
    {

        for(int k = 0; k<caesar.length; k++)
        {
            if(msgHolder.get(l) == caesar[k])
            {
                
            msgHolder.set( l,caesarDup.get(k));
            break;
            
            
        }
        }
    }//ENCRYPTS THE MESSAGE
    
    StringBuffer enToString = new StringBuffer();
    for(char msgH : msgHolder){
        enToString.append(msgH);
    } //ARRAY to STRING
   
    Collections.rotate(caesarDup, shift);
    return(""+enToString);
    }
    
    public static String caesarCiphDe(String enmsg, char keyDe){
    char [] caesar = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    List<Character> caesarDup = new ArrayList<Character>();
    List<Character> msgHolderDe = new ArrayList<Character>();
    for(int i = 0; i<caesar.length; i++)
    {
        caesarDup.add(caesar[i]);

    }//CREATES AN ARRAYLIST FOR SHIFTING THE CIPHER
    
    int shiftDe = 0;
    for( int j = 0; j < caesar.length; j++)
        {
            
            if(keyDe==(caesar[j]))
            {
                shiftDe = j;
            }
        }//SHIFTER METHOD FOR KEY IN REVERSE
        
        for(int m = 0; m<enmsg.length(); m++)
    {
        msgHolderDe.add(enmsg.charAt(m));
    }//CREATES THE STRING ARRAYLIST
    
     Collections.rotate(caesarDup, -shiftDe);
    
    for(int l = 0; l<msgHolderDe.size(); l++)
    {

        for(int k = 0; k<caesarDup.size(); k++)
        {
            if(msgHolderDe.get(l) == caesarDup.get(k))
            {
                
            msgHolderDe.set( l,caesar[k]);
            break;
            
            
        }
        }
    }//DECRYPTS THE MESSAGE
    
    StringBuffer deToString = new StringBuffer();
    for(char msgH : msgHolderDe){
        deToString.append(msgH);
    } //ARRAY to STRING
    
    Collections.rotate(caesarDup, shiftDe);
    return("" + deToString);

    }
}