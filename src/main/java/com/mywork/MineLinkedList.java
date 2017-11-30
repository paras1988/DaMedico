package com.mywork;

public class MineLinkedList {

	public static void main(final String[] args) {



		Node head = BuildOneTwoThree(); // build {1, 2, 3}

		System.out.println(head);
		final int count=CountTest(head);
		System.out.println("count "+count);
		GetNth(head, 2); // returns the value 3
		head=DeleteList(head); // deletes the three nodes and sets myList to NULL
		printList(head);

		head = BuildOneTwoThree();
		printList(head);

		head = Pop(head); // deletes "1" node,print and returns {2,3}
		printList(head);

		head=InsertNth(head, 2, 42); // build {2, 42, 3}
		printList(head);

		head=SortedInsert(head,7);
		printList(head);

		final Node head2 = BuildOneTwoThree(); // build {1, 2, 3}

		append(head,head2);
		System.out.print("Appending: ");
		printList(head);

		head=InsertSort(head);   //sorting
		System.out.print("sorting: ");
		printList(head);

		final Node front=null;
		final Node back=null;
		FrontBackSplit(head,front,back);
		printList(head);

		//which takes a list sorted in increasing order and deletes any duplicate nodes from the list.
		final Node head3 = BuildOneTwoThree(); // build {1, 2, 3}
		append(head,head3);
		SortedInsert(head,3);
		SortedInsert(head,3);
		SortedInsert(head,2);
		SortedInsert(head,1);
		head=InsertSort(head);   //sorting
		RemoveDuplicates(head);

		//MoveNode(&a, &b);
		// a == {1, 1, 2, 3}
		// b == {2, 3}
		final Node head4 = BuildOneTwoThree(); // build {1, 2, 3}
		final MyResult mr1=MoveNode(head,head4);
		System.out.print("MoveNode dest: ");
		printList(mr1.getFirst());
		System.out.print("MoveNode source: ");
		printList(mr1.getSecond());


		final Node head5=BuildList(1,4,3,5,6,6,4,5,4);
		System.out.print("BuildList fifth: ");
		printList(head5);


		Node headSplit1=null;
		Node headSplit2=null;
		final MyResult mr2=AlternatingSplit(head5,headSplit1,headSplit2);
		System.out.println("Splitted Strings are:");
		headSplit1=mr2.getFirst();
		headSplit2=mr2.getSecond();
		printList(headSplit1);
		printList(headSplit2);


		headSplit1=SortedInsert(headSplit1,7);
		System.out.print("split First String ");
		printList(headSplit1);
		final Node head6=ShuffleMerge(headSplit1,headSplit2);
		System.out.print("Shuffle Merge merging 2 sublists ");
		printList(head6);


		final Node head7=BuildList(1,3,56,76,78,99,345,467);
		final Node head8=BuildList(2,5,6,8);

		final Node head9=SortedMerge(head7,head8);
		System.out.print("Merging head7 and head8 sorted lists into one sorted list ");
		printList(head9);

		final Node head10=BuildList(4,78,34,2,5,56,34,6,8,1,46,9,5);
		final Node head11=MergeSort(head10);
		System.out.println("Merge sort of head10 ");
		printList(head11);
	}


	private static Node MergeSort(final Node head10) {
		//base case
		final Node head=head10;
		if(head.next==null){
			return head;
		}

		Node front=new Node();
		Node back=new Node();

		FrontBackSplit(head, front, back);
		front=front.next;
		back=back.next;

		final Node l=MergeSort(front);
		final Node r=MergeSort(back);

		return SortedMerge(l,r);

	}


	private static Node SortedMerge(Node head7, Node head8) {
		Node head=null;
		MyResult mr1=null;
		MyResult mr2=null;
		while(head7!=null || head8!=null){
			if(head7!=null && head8!=null){
				if(head7.data<head8.data){
					mr1=MoveNode(head,head7);
					head=mr1.getFirst();
					head7=mr1.getSecond();
				}
				else{
					mr2=MoveNode(head,head8);
					head=mr2.getFirst();
					head8=mr2.getSecond();
				}
			}
			else if(head8==null){
				mr1=MoveNode(head,head7);
				head=mr1.getFirst();
				head7=mr1.getSecond();
			}
			else{
				mr2=MoveNode(head,head8);
				head=mr2.getFirst();
				head8=mr2.getSecond();
			}
		}

		return head;
	}

	private static Node ShuffleMerge(Node headSplit1, Node headSplit2) {
		Node head=null;
		while(!(headSplit1==null && headSplit2==null)){
			if(headSplit1!=null){

				final MyResult mr1=MoveNode(head,headSplit1);
				head=mr1.getFirst();
				headSplit1=mr1.getSecond();
			}
			if(headSplit2!=null){
				final MyResult mr2=MoveNode(head,headSplit2);
				head=mr2.getFirst();
				headSplit2=mr2.getSecond();
			}
		}
		return head;
	}

	private static MyResult AlternatingSplit(Node head5,Node headSplit1,Node headSplit2) {
		while(head5!=null){
			final MyResult mr1=MoveNode(headSplit1,head5);
			headSplit1=mr1.getFirst();
			head5=mr1.getSecond();

			final MyResult mr2=MoveNode(headSplit2,head5);
			headSplit2=mr2.getFirst();
			head5=mr2.getSecond();
		}

		return new MyResult(headSplit1, headSplit2, head5);
	}

	private static Node BuildList(final int... args) {
		Node head=null;
		int i=0;
		for(final int data:args){
			head=InsertNth(head, i, data);
			i++;
		}
		return head;
	}

	private static MyResult MoveNode(Node head, Node head4) {
		if(head4==null){
			return new MyResult(head,null);
		}
		final Node temp=head;
		head=head4;
		head4=head4.next;
		head.next=temp;

		return new MyResult(head, head4);
	}

	private static void RemoveDuplicates(final Node head) {
		System.out.print("Before removing Duplicates: ");
		printList(head);

		Node current=head;
		Node previous=head;

		if(head.next!=null){
			current=head.next;
		}
		while(current!=null){
			if(current.data!=previous.data){
				previous.next=current;
				previous=current;
			}
			current=current.next;
		}
		if(previous.next!=null){
			previous.next=null;
		}

		System.out.print("After removing Duplicates: ");
		printList(head);

	}

	private static void FrontBackSplit(final Node head, final Node front, final Node back) {
		Node fastPtr=head;
		Node slowPtr=head;

		while(!(fastPtr==null || fastPtr.next==null || fastPtr.next.next==null)){
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
		}
		final Node endPtr=slowPtr;
		slowPtr=slowPtr.next;
		endPtr.next=null;

		/*System.out.print("Front List: ");
		printList(head);

		System.out.print("Back List: ");
		printList(slowPtr);*/

		if(front!=null) {
			front.next=head;
		}
		if(back!=null) {
			back.next=slowPtr;
		}
	}

	private static Node append(final Node head, Node head2) {
		Node current=head;
		while(current.next!=null){
			current=current.next;
		}
		current.next=head2;
		head2=null;
		return head;
	}

	private static Node InsertSort(final Node head) {
		Node sortedListHead=null;
		Node current=head;
		while(current!=null){
			sortedListHead=SortedInsert(sortedListHead,current.data);
			current=current.next;
		}
		return sortedListHead;
	}
	private static Node SortedInsert(Node head, final int i) {
		Node current=head;
		int count=0;
		while(current!=null){
			if(current.data>i){
				break;
			}
			current=current.next;
			count++;
		}
		head=InsertNth(head, count, i);
		return head;
	}


	private static Node InsertNth(Node head, final int i, final int j) {
		if(i==0){
			final Node newNode=new Node(j);
			newNode.next=head;
			head=newNode;
		}
		else{
			Node current=head;
			int count=0;
			while(current!=null){
				if(count==i-1){
					final Node newNode=new Node(j);
					newNode.next=current.next;
					current.next=newNode;
					break;
				}
				current=current.next;
				count++;
			}
		}
		return head;
	}


	private static Node Pop(Node head) {
		final Node poppedNode=head;
		head=head.next;
		poppedNode.next=null;

		System.out.println("Element popped "+poppedNode.data);
		return head;
	}


	public static void printList(final Node head){
		Node current=head;
		System.out.print("Printing list ");
		while(current!=null){
			System.out.print(current.data+",");
			current=current.next;
		}
		System.out.println("");
	}

	private static Node DeleteList(Node head){
		if(head!=null){
			head=null;
		}
		return head;
	}

	private static void GetNth(Node head, final int i) {
		int count=0;
		while(head!=null){
			if(count==i){
				System.out.println(head.data);
			}
			count++;
			head=head.next;
		}
	}


	private static Node BuildOneTwoThree() {
		final Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=null;
		return head;
	}

	static int CountTest(final Node head) {
		final int count = Count(head, 2); // returns 1 since there's 1 '2' in the list
		return count;
	}


	private static int Count(Node head, final int i) {
		int count=0;
		while(head.next!=null){
			System.out.println(head.data);
			if(head.data==i){
				System.out.println("inside");
				count=count+1;
			}
			head=head.next;
		}
		return count;

	}

}