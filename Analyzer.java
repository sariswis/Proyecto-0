import java.util.HashMap;
import java.lang.String;
import java.util.ArrayList;

class Analyzer
{
    private static HashMap<String, String> variables = new HashMap<String, String>();
	private static HashMap<String, Integer> functions = new HashMap<String, Integer>();
	private static ArrayList<String> params = new ArrayList<String>();

    public static void addVariable(Token token){
		String def = "";
        String image = token.image.toLowerCase();
        variables.put(image, def);
	}

    public static void addFunction(Token token, int count){
		Integer c = count;
        String image = token.image.toLowerCase();
		functions.put(image, c);
	}

	public static void addParam(Token token){
        String image = token.image.toLowerCase();
        params.add(image);
	}

	public static void assignVariable(Token number, Token token){
        String num = number.image.toLowerCase();
        String image = token.image.toLowerCase();
		if (variables.containsKey(image)){
			variables.put(image, num);
		} else {
			throw new Error("Couldn't assign " + number.image + " to undefined variable " + token.image + "\nLine: " + token.beginLine + " Column: " + token.beginColumn);
		}
	}
    
	public static void checkVariable(Token token){
		if (!params.contains(token.image)){
			if (variables.containsKey(token.image)){
				String value = (String) variables.get(token.image);
				if (value == ""){
					throw new Error("The variable " + token.image + " has no value\nLine: " + token.beginLine + " Column: " + token.beginColumn);
				}
			} else {
				throw new Error("The variable " + token.image + " is not defined\nLine: " + token.beginLine + " Column: " + token.beginColumn);
			}
		}
	}

    public static void checkFunction(Token token, int count){
		if (functions.containsKey(token.image)){
			int value = (Integer) functions.get(token.image);
			if (value != count){
				throw new Error("The function must have " + value + " params, not " + count + "\nLine: " + token.beginLine + " Column: " + token.beginColumn);
			}
		} else {
			throw new Error("The function " + token.image + " is not defined\nLine: " + token.beginLine + " Column: " + token.beginColumn);
		}
	}

	public static void printInfo(){
		System.out.println("\nPARSER SUMMARY");
		System.out.println("Variables: " + variables);
		System.out.println("Functions: " + functions);
		System.out.println("Params: " + params);
	}
 }
  
  
  
  
  
  
  