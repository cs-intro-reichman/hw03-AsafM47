import javax.print.DocFlavor.STRING;

/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String newString = "";
        for(int i = 0; i < s.length(); i++){
           if(newString.length() > 0){
                if(s.charAt(i) != ' ')
                {
                    if(newString.indexOf(s.charAt(i))== -1){
                        newString += s.charAt(i);
                    }
                }
                else{
                    newString += s.charAt(i);
                }
            }
           else{
                newString += s.charAt(i);
           }
        }
        return newString;
    }
}
