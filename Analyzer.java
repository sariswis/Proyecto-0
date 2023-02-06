import java.util.HashMap;
import java.lang.String;
import java.util.ArrayList;

class Analyzer
{
    private static HashMap variables = new HashMap();
	private static HashMap functions = new HashMap();

    public static void addVariable(Token token)
	{
		String def = "";
        String image = token.image.toLowerCase();
        variables.put(image, def);
        System.out.println(image);
	}
    
    public static void addFunction(Token token)
	{
        String image = token.image.toLowerCase();
        ArrayList params = new ArrayList();
		functions.put(image, params);
        System.out.println(image);
	}

    public static String addParam(Token token, Token param)
	{
        String image = token.image.toLowerCase();
        String p = param.image.toLowerCase();
        try
        {
            ArrayList list = (ArrayList) functions.get(image);
            list.add(p);
            System.out.println(p);
            return "";
        }
        catch(Exception e)
		{
			return "Error: The function " + token.image + " is not defined\nLine: " + token.beginLine;
		}
	}

    public static void assignVariable(Token number, Token token)
	{
        String image = token.image.toLowerCase();
        String num = number.image.toLowerCase();
        variables.put(image, num);
        System.out.println(image);
	}

	public static String checkVariable(Token token)
	{
		try
		{
			int exists = (Integer) variables.get(token.image);
			return "";
		}
		catch(Exception e)
		{
			return "Error: The variable " + token.image + " is not defined\nLine: " + token.beginLine;
		}
	}

    public static String checkFunction(Token token)
	{
		try
		{
			int exists = (Integer) functions.get(token.image);
			return "";
		}
		catch(Exception e)
		{
			return "Error: The function " + token.image + " is not defined\nLine: " + token.beginLine;
		}
	}

 }
  
  
  
  
  
  
  