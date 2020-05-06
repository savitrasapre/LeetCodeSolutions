import java.util.*;

class PowerSet
{
     public static Set<Set<Integer>> printAllSubsets(Set<Integer> inputSet)
    {   
        Set<Set<Integer>> result = new HashSet<Set<Integer>>();

        if(inputSet.size() == 0)
        {
            result.add(inputSet);
            return result;
        }

        //1, 2, 3
        1
        List<Integer> temp = new ArrayList<>(inputSet);
        Integer firstElementInCombination = temp.get(0);
        temp.remove(firstElementInCombination);

        Set<Integer> t = new HashSet<>(temp);
        //2, 3
        
        for(Set<Integer> i : printAllSubsets(t))
        {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(firstElementInCombination);
            newSet.addAll(i);

            result.add(newSet);
            result.add(i);
        }

        return result;

    }
   
    

    public static void main(String[] args)
    {
       Set<Integer> set = new HashSet<>();

       set.add(1);
       set.add(2);
       set.add(3);
       Set<Set<Integer>> result = printAllSubsets(set);

       System.out.println(result);
    }
}