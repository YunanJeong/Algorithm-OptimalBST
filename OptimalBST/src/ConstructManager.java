import java.util.ArrayList;

public class ConstructManager {
	
	ArrayList<Data> dataTable;
	float[][] mainTable;
	int[][] rootTable;
	
	public ConstructManager(ArrayList<Data> dataTable, float[][] mainTable, int[][] rootTable){
		this.dataTable = dataTable;
		this.mainTable = mainTable;
		this.rootTable = rootTable;
	}
	
	public BSTNode ConstructOptimalBinaryTree(){
		
		//fill the mainTable and the rootTable by recursive function.
		calculateMainRootTableValue(1, 2, 2);
		
		//create Tree by recursive function.
		return createTree(1, 12);
		
		
	}
	
	
	
	public void initializeMainTable(){
		int i;
		int j;
		
		//initialize mainTable 
		for(i = 0 ; i < mainTable.length ; i++){
			for(j = 0 ; j < mainTable[0].length; j++){
				mainTable[i][j] = 0;
			}
		}
		for(i = 1 ; i < mainTable.length ; i++){
			mainTable[i][i] = dataTable.get(i-1).getProbability();
		}
		
		//initialize rootTable
		for(i = 0 ; i < rootTable.length ; i++){
			for(j = 0 ; j < rootTable[0].length; j++){
				rootTable[i][j] = 0;
			}
		}
		for(i = 1 ; i < rootTable.length ; i++){
			rootTable[i][i] = i;
		}
		
	}
	
	public void initializeRootTable(){
		int i;
		int j;
		
		//initialize rootTable
		for(i = 0 ; i < rootTable.length ; i++){
			for(j = 0 ; j < rootTable[0].length; j++){
				rootTable[i][j] = 0;
			}
		}
		for(i = 1 ; i < rootTable.length ; i++){
			rootTable[i][i] = i;
		}
		
	}
	

	
	
	public void calculateMainRootTableValue(int i , int j, int startColumn){
		
		int k; 
		
		//finds value of Sigma p
		float p = 0;
		for(k = i; k <= j; k++){
			p += mainTable[k][k];
		}
		
		
		//finds the case time is minimal 
		float minValue = 0;
		float tempValue = 0;
		
		for(k = i ; k < j ; k++){
			tempValue = mainTable[i][k-1] + mainTable[k+1][j] +  p;
			if(minValue == 0){
				minValue = tempValue;
			}
			if(minValue >= tempValue){
				minValue = tempValue;
				rootTable[i][j] = k;
			}
		}
		mainTable[i][j] = minValue;
		
		i++;
		j++;
		
		if(j == mainTable.length){
			startColumn++;
			i=1;
			j=startColumn;
			
			if(startColumn == mainTable[0].length){
				return;
			}
		}
		
		calculateMainRootTableValue(i, j, startColumn);
		
	}
	
	
	
	public BSTNode createTree(int i, int j){
		
		BSTNode root = new BSTNode();
		int key = rootTable[i][j];
		
		if(i == j){
			root.setKey(key);
			root.setData(dataTable.get(key-1));
			root.setLeft(null);
			root.setRight(null);
		}
		else if (i > j){
			return null;
		}
		else{
			root.setKey(key);
			root.setData(dataTable.get(key-1));
			root.setLeft( createTree(i, key-1) );
			root.setRight( createTree(key+1, j) );
		}
		
		return root;
	}
	
}
