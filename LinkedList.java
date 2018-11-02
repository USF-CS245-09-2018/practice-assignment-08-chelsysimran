public class LinkedList implements List
{
	private Node head;
	private int size;
	private int pos;

	public LinkedList()
	{
		size = 0;
		head = null;
	}

	private class Node
	{
		public Object obj;
		public Node next;
		
		public Node()
		{
			this.next = null;
			this.obj = 0;
		}
		
		public Node(Object dataValue)
		{
			next = null;
			this.obj = dataValue;
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
		if(pos < 0 || pos > size+1)
		{
			try 
            {
                throw new Exception("Invalid range");
            }
            catch (Exception e)
            {
                //do nothing
            }
		}

		Node node = new Node(obj);
		node.setNext(head);
		head = node;
		size++;

	}
	
	public void add(int pos, Object obj) throws Exception
	{
		if(pos < 0 || pos > size+1)
		{
			try 
            {
                throw new Exception("Invalid range");
            }
            catch (Exception e)
            {
                //do nothing
            }
		}
		
		Node node = new Node();
		node.obj = obj; 
		
		if(pos == 0)
		{
			node.next = head;
			head = node;
		}
		
		Node previous = find(pos-1); 
		node.next = previous.next;
		previous.next = node;
		size++;

	}
	
	public Object get(int pos) throws Exception
	{
		if(pos < 0 || pos > size+1)
		{
			try 
            {
                throw new Exception("Invalid range");
            }
            catch (Exception e)
            {
                //do nothing
            }
		}

		Node node = head;
		int count = 0;

		while (node != null)
		{
			if(count == pos)
			{
				return node.obj;
			}

			count++;
			node = node.next;
		}

		return 0;

	}

	private Node find (int pos)
	{
		Node node = head;
		for(int i = 0; i<pos; i++)
		{ //i<pos && node.next!= null 
			node = node.next;
		}
		return node;
	}
	
	public Object remove(int pos) throws Exception
	{
		if(pos < 0 || pos > size+1)
		{
			try 
            {
                throw new Exception("Invalid range");
            }
            catch (Exception e)
            {
                //do nothing
            }
		}
		
		if(pos == 0)
		{
			Node node = head;
			head = head.next;
			size--; 
			return node.obj;
		}

		Node previous = find(pos -1);
		Node curr = previous.next;
		previous.next = curr.next; 
		size--;
		return curr.obj;

	}
	
	public int size()
	{
		return size;

	}
}