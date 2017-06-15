import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;



/*
 * Algorithm Project
 * Translator using Optimal Binary Search Tree
 * Written By Yunhwan Jeong(201420984)
 * 2017-06-15
 *
 */


public class Main {

	public static void main(String[] args) {
		ArrayList<Data> dataTable = new ArrayList<Data>();
		float[][] mainTable= null;
		int[][] rootTable = null;
		BSTNode optimalBSTTree = null;
		
		FrequencyManager frequencyManager = new FrequencyManager(dataTable);
		
		//initialize frequency table
		frequencyManager.initializeTable();
		
		//read file and set frequency and probability in table 
		frequencyManager.FrequencyGenerator();
		
		
		
		
		//initialize mainTable and rootTable
		mainTable = new float[dataTable.size()+1][dataTable.size()+1];
		rootTable = new int[dataTable.size()+1][dataTable.size()+1];
		
		ConstructManager constructManager = new ConstructManager(dataTable, mainTable, rootTable);
		constructManager.initializeMainTable();
		constructManager.initializeMainTable();
		
		//construct Optimal Binary Search Tree  by mainTable
		optimalBSTTree = constructManager.ConstructOptimalBinaryTree();
		
		
		
		//Optimal BST Traversal
		TranslateManager translateManager = new TranslateManager(dataTable);
		translateManager.TranslateBySearching(optimalBSTTree);
		
		
		
		
		//Console print for Unit TEST
		//print dataTable
		for(Data data : dataTable){
			data.printElements();
		}
		//print mainTable
		for(int i = 0 ; i < mainTable.length ; i++){
			for(int j = 0 ; j < mainTable[0].length; j++){
				System.out.print(mainTable[i][j]+"         ");
			}
			System.out.println("");
		}
		//print rootTable
		for(int i = 0 ; i < rootTable.length ; i++){
			for(int j = 0 ; j < rootTable[0].length; j++){
				System.out.print(rootTable[i][j]+"         ");
			}
			System.out.println("");
		}
		
		
	}
	
}
