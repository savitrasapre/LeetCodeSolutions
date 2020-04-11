import java.util.*;

class KMP_Algorithm {
	
	
	static void KMP_search(String pat,String text)
	{
		int[] lps = new int[pat.length()];

		computeLPS(pat,lps);

		int i=0;
		int j=0;

		while(i < text.length())
		{
			if(pat.charAt(j) == text.charAt(i))
			{
				i++;
				j++;
			}

			if(j == pat.length())
			{
				System.out.println("Found at :" + (i-j));
				j = lps[j-1];
			}
			else if(i < text.length() && pat.charAt(j) != text.charAt(i))
			{
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
		}

	}

	static void computeLPS(String pattern,int[] lps)
	{	
		int i = 1;
		int len = 0;
		lps[0] = 0;


		while(i < pattern.length())
		{
			if(pattern.charAt(i) == pattern.charAt(len))
			{
				len++;
				System.out.println("value of len" + len);
				lps[i] = len;
				i++;
			}
			else
			{
				if(len != 0)
				{
					len = lps[len - 1];
				}
				else
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}
}
