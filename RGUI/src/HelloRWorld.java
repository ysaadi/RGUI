import org.rosuda.JRI.Rengine;
import org.rosuda.JRI.REXP;
public class HelloRWorld {

	public static void main(String[] args){
		Rengine re = new Rengine (new String [] {"--vanilla"}, false, null);

		// Check if the session is working.
		if (!re.waitForR()) {
		    return;
		}

		re.assign("x", new double[] {1.5, 2.5, 3.5});
		REXP result = re.eval("(sum(x))");
		System.out.println(result.asDouble());
		re.end();
	}
}
