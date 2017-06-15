import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TranslateManager {
	
	
	ArrayList<Data> dataTable = null;
	
	public TranslateManager( ArrayList<Data> dataTable){
		
		this.dataTable = dataTable;
	}
	
	public void TranslateBySearching(BSTNode root) {
	
		int key = 0;
		
		//read input file
		File file = new File("input.txt");
		BufferedReader br = null;
		String line = null;
		String[] engWords = null;
		ArrayList<String> korWords = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			while ((line = br.readLine()) != null) {
				engWords = line.split(" ");		
				for(int i = 0; i < engWords.length ; i++){
					
					
					for(Data temp : dataTable){
						if(engWords[i].equals(temp.getEngWord())){
							key = temp.getKey();
						}
					}
				
					//search one engword and get on korword
					korWords.add(translateEngToKor(root,key));
					
				}
				
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//writeFile
		writeFile(korWords);
	}
	
	public void writeFile(ArrayList<String> korWords) {
		
		File file = new File("output.txt");
		try {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
	
			
			for(String word : korWords){
				fileWriter.write(word + " ");
			}
	
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	//BST search traversal 
	public String translateEngToKor(BSTNode root, int key){
	
		
		if(root.getKey() == key){
			return root.getData().getKorWord();
		}
			
		else if(root.getKey() > key){
			if(root.getLeft() != null){
				return translateEngToKor(root.getLeft(), key);
			}
			else{
				return null;
			}
		}
		else if (root.getKey() < key){
			if(root.getRight() != null){
				return translateEngToKor(root.getRight(), key);
			}
			else{
				return null;
			}
		}
		
		return null;
	}

}
