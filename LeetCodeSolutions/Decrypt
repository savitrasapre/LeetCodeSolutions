public static String freqAlphabets(String s) {
        HashMap<String,Character> hmap = new HashMap<>();
        
   
        StringBuilder answer = new StringBuilder();
       
        for (int i = 1; i <= 9; i++) {  
            hmap.put(Integer.toString(i),(char)('a' + i - 1));
        }

        for (int i = 1; i <= 17; i++) {
            hmap.put(Integer.toString(i + 10 - 1) + "#",(char)('j' + i - 1));
        }

        char lookupChar;
        
        for (int i = s.length()-1;i >= 0; --i) {
            
            lookupChar = s.charAt(i);
        
            if(lookupChar == '#')
            {
                String valueToLookup = Character.toString(s.charAt(i-2)) + Character.toString(s.charAt(i-1)) + "#";
                answer = answer.append(hmap.get(valueToLookup));
                i-=2;
            }
            else
            {
                answer = answer.append(hmap.get(Character.toString(lookupChar)));
            }
        }

        return answer.reverse().toString();
    }
        
