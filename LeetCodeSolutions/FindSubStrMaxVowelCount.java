
class FindSubStrMaxVowelCount
{

    //given a string and k is length of substring that has to be returned. Find substring that has max number of vowels.
    public static String findSubstring(String s, int k) {
            
            List<Character> vowels = new ArrayList<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
  
            Map<String,Integer> map = new HashMap<>();
            
            for(int i=0;i<s.length();++i)
            {
                if(k+i <= s.length()){
                    String answer = s.substring(i,k+i);
                    int currentVowelCount = 0;
                    for (int j = 0; j < answer.length(); j++) {
                        if(vowels.contains(answer.charAt(j)))
                        {
                            currentVowelCount++;
                        }
                    }
                    if(currentVowelCount != 0)
                    {
                        map.put(answer, currentVowelCount);
                    }
                    else
                    {
                        i = k + i - 1;
                    }
                }
            }
            if(map.size() == 0)
                return "Not found!";

            int highestVowelCount = Collections.max(map.values());

            for(java.util.Map.Entry<String,Integer> e : map.entrySet())
            {
                if(e.getValue() == highestVowelCount)
                {
                    return e.getKey();
                }
            }

            return "";  //should never come here.
    
        }
}