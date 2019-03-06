import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	int size;
	String[] vertices;
	Node[] a;
	boolean[] TV;
	Queue<Object> q;
	
	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new Node[size];
		for(int i = 0; i<size; i++) {
			a[i] = new Node(i, null);
		}
	}
	
	private int index(String v) {
		for(int i=0; i<size; i++) {
			if(vertices[i].equals(v)){
				return i;
			}
		}
		return a.length;
	}
	
	public void add(String v, String w) {
		a[index(v)].next = new Node(index(w), a[index(v)].next);
		a[index(w)].next = new Node(index(v), a[index(w)].next);
	}
	
	public String toString() {
		if(size == 0) return "{}";
		System.out.print("{");
		for(int j=0; j<size; j++) {
			System.out.print(vertices[a[j].to]+":");
			Node p = a[j];
			while(p.next != null) {
				System.out.print(vertices[p.next.to]);
				p = p.next;
			}
			if(j<size-1)
				System.out.print(", ");
		}
		return "}";
		
	}
	
	public void findPath(String v, String w) {
		System.out.print("Path(2)-(" + v + "," + w + ") : ");
		if(index(v) == a.length || index(w) == a.length)
			System.out.print("Can't find it");
		int count = 0;
		Node p = a[index(v)];
		while(p.next != null) {
			p = p.next;
			if(p.to != index(w)) {
				Node q = a[p.to];
				while(q.next != null) {
					q = q.next;
					if(q.to == index(w) && q.to != index(v)) {
						System.out.print("{" + v + " -> " + vertices[p.to] + " -> " + w + "} ");
						count++;
					}
				}
			}
		}
		if(count == 0) {
			System.out.print("Can't find it");
		}
		System.out.println("");
	}
	
	/*public void Breadth_First_Search(String v) {
		TV = new boolean[size];
		String[] list = new String[size];
		TV[index(v)] = true;
		q = new LinkedList();
		q.add(v);
		int t =0;
		while(q.peek() != null) {
			Node p;
			list[t] = (String)q.poll();
			t++;
			for(p = a[index(list[t])].next; p.next != null; p=p.next) {
				if(TV[p.to] != true) {
					q.add(p);
					TV[p.to] = true;
				}
			}
			System.out.println(list);
		}
	}*/
	
	private class Node{
		int to;
		Node next;
		Node(int to, Node next){
			this.to = to;
			this.next = next;
		}
	}
}
