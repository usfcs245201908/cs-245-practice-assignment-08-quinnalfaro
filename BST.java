class BST{
	Node root;

	public boolean find(int item){
		return find(item, root);
	}

	public boolean find(int item, Node node){
		if(node == null){
			return false;
		}
		if (node.data == item){
			return true;
		} else if(node.data < item){
			return find(item, node.right);
		}
	}

	public void insert(int item){
		root = insert(root, item);
	}


	public Node insert(Node node,int item){
		//Base Case
		if (node == null){
			return new Node(item);
		} else if(node.data < item){
			node.right = insert(node.right, item);
		} else{
			node.left = insert(node.left, item);
		}
		return node;
	}

	public void print(){
		//left this right
		//in order traversal

	}

	public void delete(comparable thing){

	}
}