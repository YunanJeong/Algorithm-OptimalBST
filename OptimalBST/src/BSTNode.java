
public class BSTNode {
	
	private int mKey;
	private Data mData;
	private BSTNode mLeft;
	private BSTNode mRight;
	
	
	
	public BSTNode getLeft(){
		return mLeft;
	}
	public void setLeft(BSTNode left){
		mLeft = left; 
	}
	
	public BSTNode getRight(){
		return mRight;
	}
	public void setRight(BSTNode right){
		mRight = right; 
	}
	
	public int getKey(){
		return mKey;
	}
	public void setKey(int key){
		mKey = key; 
	}
	
	public Data getData(){
		return mData;
	}
	public void setData(Data data){
		mData = data; 
	}
}
