public class BST<T>{

	public Node<T> root;

	public BST(){
		this.root = null;
	}

	public class Node<T> {
		public Comparable data;
		public Node<T> left;
		public Node<T> right;

		public Node(Comparable item){
			this.data = item;
			this.left = null;
			this.right = null;
		}
	}

	public void insert(Comparable item){
		root = insert(root, item);
	}


	public Node insert(Node node, Comparable item){
		//Base Case
		if (node == null){
			return new Node(item);
		} else if(node.data.compareTo(item) > 0){
			node.left = insert(node.left, item);
		} else{
			node.right = insert(node.right, item);
		}
		return node;
	}

	public void print(){
		print(root);
	}

	public void print(Node node){
		if(node != null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}


	public boolean find(Comparable item){
		return find(item, root);
	}

	public boolean find(Comparable item, Node node){
		if(node == null){
			return false;
		}
		if (node.data == item){
			return true;
		} else if(node.data.compareTo(item) > 0){
			return find(item, node.left);
		} else {
			return find(item, node.right);
		} 
	}


	public void delete(Comparable item){
		root = delete(root, item);
	}

	public Node delete(Node node, Comparable item){
		if(node == null){
			return null;
		}
		if(node.data == item){
			if(node.left == null){
				return node.right;
			} else if(node.right == null){
				return node.left;
			} else if((node.right).left == null){
				node.data = (node.right).data;
				node.right = (node.right).right;
				return node; 
			} else{
				node.data = removeSmallest(node.right);
				return node;
			}
		} else if (node.data.compareTo(item) > 0){
			node.left = delete(node.left, item);
		} else {
			node.right = delete(node.right, item);
		}
		return node;
	}

	public Comparable removeSmallest(Node node){
		if(node.left.left == null){
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removeSmallest(node.left);
	}
}