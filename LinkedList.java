public class LinkedList implements List 
{
	private int size;
	private Node head;
	
	public LinkedList()
	{
		size = 0;
		head = null;
	}

	private class Node
	{
	
		public Object data;
		public Node next;
		
		public Node()
		{
			this.next = null;
			this.data = 0;
		}
		
		public Node(Object dataValue)
		{
			next = null;
			this.data = dataValue;
		}
		
		public Node getNext(Node next)
		{
			return this.next;
		}
		
		public void setNext(Node next)
		{
			next = next;
		}
		
		public void data(Object data)
		{
			data = data;
		}
	}
	
	public void add(Object obj) throws Exception
	{
		Node node = new Node(obj);
		node.setNext(head);
		head = node;
		++size;
	}

	public void add(int pos, Object obj) throws Exception
	{
		if(pos < 0 || pos > size)
		{
			throw new IllegalArgumentException("empty");
		}
		
		if(pos == 0)
		{
			Node node = new Node();
			node.data = obj;
			node.next = head;
			head = node;
			++size;
		}
		
		else
		{
			Node previous = getNode(pos-1);
			Node node = new Node();
			node.data = obj;
			node.next = previous.next;
			previous.next = node;
			++size;
		}
	}
	
	public Object get(int pos) throws Exception
	{
		if (pos >= size || pos < 0)
		{
			throw new IllegalArgumentException("empty");
		}

		Node curr = getNode(pos);
		return curr.data;
		
	}
	
	public Node getNode(int pos)
	{
		if(pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException("empty");
		}
		
		Node node = head;
		for(int i = 0; i < pos; i++)
		{
			node = node.getNext(node);
		}
		return node;
	}
	
	public Object remove(int pos) throws Exception
	{
		if(pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException("empty");
		}
		
		if(pos == 0)
		{
			Node curr = head;
			--size;
			return curr.data;
		}
		
		else
		{
			Node previous = getNode(pos-1);
			Node curr = previous.next;
			previous.next = curr.next;
			--size;
			return curr.data;
		}
	}

	public int size()
	{
		return size;
	}

}