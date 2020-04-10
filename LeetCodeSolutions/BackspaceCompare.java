	public static boolean backspaceCompare(String S, String T) {
        	return build(S).equals(build(T));
    	}

	public static String build(String input)
	{
		Stack<Character> charactersStack = new Stack<>();

		for (Character c : input.toCharArray()) {
			if(c != '#')
			{
				charactersStack.push(c);
			}
			else if(!charactersStack.empty())
			{
				charactersStack.pop();
			}
		}
		return String.valueOf(charactersStack);
	}
