import java.util.HashMap;
import java.lang.String;
import java.util.ArrayList;

class Analyzer
{
    private static HashMap<String, String> variables = new HashMap<String, String>();
	private static HashMap functions = new HashMap();
	private static ArrayList<String> params = new ArrayList<String>();

    public static void addVariable(Token token)
	{
		String def = "";
        String image = token.image.toLowerCase();
        variables.put(image, def);
        System.out.println("New variable: " + image);
	}

	public static void assignVariable(Token number, Token token)
	{
        String num = number.image.toLowerCase();
        String image = token.image.toLowerCase();
        variables.put(image, num);
        System.out.println("Assignment: " + image);
	}

    public static void addFunction(Token token, int count)
	{
        String image = token.image.toLowerCase();
		functions.put(image, count);
        System.out.println("New function: " + image);
	}

	public static void addParam(Token token)
	{
        String image = token.image.toLowerCase();
        params.add(image);
        System.out.println("New param: " + image);
	}
    
	public static String checkVariable(Token token)
	{
		String message = "";
		boolean p_exists = params.contains(token.image);
		if (!p_exists){
			boolean v_exists = variables.containsKey(token.image);
			if (v_exists){
				String value = (String) variables.get(token.image);
				if (value == ""){
					message = "Warning: The variable " + token.image + " has no value\nLine: " + token.beginLine;
				}
			} else {
				message = "Error: The variable " + token.image + " is not defined\nLine: " + token.beginLine;
			}
		}
		return message;
	}

    public static String checkFunction(Token token, int count)
	{
		String message = "";
		boolean exists = functions.containsKey(token.image);
		if (exists){
			int value = (Integer) functions.get(token.image);
			if (value != count){
				message = "Error: The function must have " + value + " params, not" + count + "\nLine: " + token.beginLine;
			}
		} else {
			message = "Error: The function " + token.image + " is not defined\nLine: " + token.beginLine;
		}
		return message;
	}
 }
  
  
  
  
  
  
  