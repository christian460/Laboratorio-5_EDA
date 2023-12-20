package lab5;
public class Balanceo {

	public static void main(String[] args) {
		System.out.print("{[()]}"+" -> ");
		System.out.println(isBalanced("{[()]}")); 
		System.out.print("[(])"+" -> ");
		System.out.println(isBalanced("[(])"));
		System.out.print("[[(())]]"+" -> ");
		System.out.println(isBalanced("[[(())]]"));
		System.out.print("[[((])]]"+" -> ");
		System.out.println(isBalanced("[[((])]]"));

	}
	public static boolean isBalanced(String cad) {
        if (cad.length()%2!=0) {
            return false;
        } else {
            for (int i=0; i<cad.length()/2 ; i++) {
                char ini=cad.charAt(i);
                char fin=cad.charAt(cad.length()-i-1);
                if ((ini == '{' && fin == '}') ||
                    (ini == '[' && fin == ']') ||
                    (ini == '(' && fin == ')')) {
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
