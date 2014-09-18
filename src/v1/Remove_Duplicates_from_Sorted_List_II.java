package v1;
import util.ListNode;
import static util.Print.print;

/**
 * 2014-9-3
 * @author Alvin
 * 
 */

//class ListNode{
//	int val;
//	ListNode next;
//	ListNode (int x){val = x ; next = null;}
//}
public class Remove_Duplicates_from_Sorted_List_II{
	public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode step = newHead;
        boolean isDelete = false;
        if(head == null || head.next == null)
        	return head;
        while(step.next != null && step.next.next != null){
//        	print(step);
        	if(step.next.val == step.next.next.val){
        		isDelete = true;
        		step.next.next = step.next.next.next;// delete next.next the second duplicates val;
        	}else{
        		if(isDelete){
        			step.next = step.next.next;//delete next;
        			isDelete = false;
        		}
        		else
        			step = step.next;
        	}
        }
        if(isDelete)
        	step.next = step.next.next;
        return newHead.next;

    }
//	public static void print(ListNode root){
//		ListNode step = root;
//		while(step != null){
//			System.out.print(  +step.val);
//			step = step.next;
//		}
//		System.out.println();
//	}
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(1);
		//new Print().print(node4);
		root.next = node1;
		node1.next = node2;
		//node2.next = node3;
		print(new Remove_Duplicates_from_Sorted_List_II().deleteDuplicates(root));
		
	}
}