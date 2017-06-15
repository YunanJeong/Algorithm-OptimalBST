import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class FrequencyManager {

	ArrayList<Data> dataTable;
	
	public FrequencyManager(ArrayList<Data> table){
		this.dataTable = table;
	}
	
	
	public void FrequencyGenerator() {
		
		//read input file
		File file = new File("input.txt");
		BufferedReader br = null;
		String line = null;

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		try {
			while ((line = br.readLine()) != null) {
				
				//set frequency
				frequencyCounter(line);
				
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//set probability
		probabilityGenerator();
	}
	
	
	public void initializeTable(){
		
		//create empty table.
		Data temp = null;
		for(int i = 0; i < 12 ; i++){
			temp = new Data();
			temp.setFrequency(0);
			temp.setProbability(0);
			dataTable.add(temp);
		}
		
		//set English Words
		dataTable.get(0).setEngWord("deltoid");
		dataTable.get(1).setEngWord("flu");
		dataTable.get(2).setEngWord("inactivated");
		dataTable.get(3).setEngWord("influenza");
		dataTable.get(4).setEngWord("injection");
		dataTable.get(5).setEngWord("intradermal");
		dataTable.get(6).setEngWord("intramuscular");
		dataTable.get(7).setEngWord("nasal");
		dataTable.get(8).setEngWord("shot");
		dataTable.get(9).setEngWord("spray");
		dataTable.get(10).setEngWord("vaccine");
		dataTable.get(11).setEngWord("virus");
		
		//set Korean Words
		dataTable.get(0).setKorWord("삼각근의");
		dataTable.get(1).setKorWord("독감");
		dataTable.get(2).setKorWord("비활성화의");
		dataTable.get(3).setKorWord("독감");
		dataTable.get(4).setKorWord("주사");
		dataTable.get(5).setKorWord("피내의");
		dataTable.get(6).setKorWord("근육내의");
		dataTable.get(7).setKorWord("비강의");
		dataTable.get(8).setKorWord("주사");
		dataTable.get(9).setKorWord("스프레이");
		dataTable.get(10).setKorWord("백신");
		dataTable.get(11).setKorWord("바이러스");
	
		//set Key
		dataTable.get(0).setKey(1);
		dataTable.get(1).setKey(2);
		dataTable.get(2).setKey(3);
		dataTable.get(3).setKey(4);
		dataTable.get(4).setKey(5);
		dataTable.get(5).setKey(6);
		dataTable.get(6).setKey(7);
		dataTable.get(7).setKey(8);
		dataTable.get(8).setKey(9);
		dataTable.get(9).setKey(10);
		dataTable.get(10).setKey(11);
		dataTable.get(11).setKey(12);
	
		
	}
	
	
	public void frequencyCounter(String line){
		int preFrequency = 0; //cumulative Frequency from first line to previous one
		int curFrequency = 0; //Frequency in this line
		
		//set Frequency in table
		for(Data temp : dataTable){
			preFrequency = temp.getFrequency();
			curFrequency = StringUtils.countMatches(line, temp.getEngWord()+" ");
			temp.setFrequency(preFrequency+curFrequency);
		}
	}
	
	public void probabilityGenerator(){
		
		int sumFrequency = 0;
		for(Data temp : dataTable){
			sumFrequency += temp.getFrequency(); 
		}
		for(Data temp : dataTable){
			temp.setProbability((float) temp.getFrequency() / sumFrequency);
		}
	}
	
}
