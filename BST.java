class BSTNode<T extends Comparable<T>>{
	Comparable data;
    BSTNode left;
    BSTNode right;

    public BSTNode(Comparable data){
        this.data = data;
    }

    Comparable getData(){
    	return this.data;
    }
}

public class BST<T extends Comparable<T>>{
	BSTNode root;

	public Boolean find(Comparable value){
		return find(root,value);
	}

	private Boolean find(BSTNode node, Comparable value){
		if(node == null)
			return false;
		if(node.getData().compareTo(value) == 0)
			return true;
		else if(node.getData().compareTo(value) > 0)
			return find(node.left, value);
		else
			return find(node.right, value);
	}

	public void insert(Comparable value){
		root = insert(root, value);
	}

	private BSTNode insert(BSTNode node, Comparable value){
		if(node == null){
			BSTNode newNode = new BSTNode(value);
			return newNode;
		}else if(node.getData().compareTo(value) < 0){
			node.right = insert(node.right, value);
			return node;
		}else{
			node.left = insert(node.left,value);
			return node;
		}

	}

	public Comparable removeSmallest(BSTNode node){
		if(node.left.left == null){
			Comparable smallest = node.left.getData();
			node.left = node.left.right;
			return smallest;
		}else{
			return removeSmallest(node.left);
		}
	}

	public void delete(Comparable value){
		root = delete(root, value);
	}


	public BSTNode delete(BSTNode node, Comparable value){
		if(node == null)
			return null;
		if(node.getData().compareTo(value) == 0){
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			else{
				if(node.right.left == null){
					node.data = node.right.getData();
					node.right = node.right.right;
					return node;
				}else{
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		}else if(node.getData().compareTo(value) > 0){
			return delete(node.right, value);
		}else{
			return delete(node.left,value);
		}
	}

	public void print(){
		print(root);
	}

	private void print(BSTNode node){
		if(node != null){
			print(node.left);
			System.out.println(node.getData());
			print(node.right);
		}
	}

}