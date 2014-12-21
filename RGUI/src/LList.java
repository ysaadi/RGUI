
public class LList {
	
	public static Node head;
	public static int count;
	public static Node end;
	LList(){
		head=null;
		end=null;
		count=0;
	}
	public void addNode(Node here){
		if(head==null){
			head=here;
			end=here;
		}
		else{
			end.Next=here;
			end=here;
		}
		count++;
	}
}
