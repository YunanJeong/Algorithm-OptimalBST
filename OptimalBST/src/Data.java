
public class Data {
	private String mEngWord;
	private int mFrequency;
	private float mProbability;
	private String mKorWord;
	private int mKey;
	
	public String getEngWord(){
		return mEngWord;
	}
	public void setEngWord(String engWord){
		mEngWord = engWord;
	}
	public String getKorWord(){
		return mKorWord;
	}
	public void setKorWord(String korWord){
		mKorWord = korWord;
	}
	public int getFrequency(){
		return mFrequency;
	}
	public void setFrequency(int frequency){
		mFrequency = frequency;
	}
	public float getProbability(){
		return mProbability;
	}
	public void setProbability(float probability){
		mProbability = probability;
	}
	
	public void printElements(){
		System.out.println(mEngWord+"   "+mFrequency+"   "+mProbability+"   "+mKorWord);
	}
	
	public int getKey(){
		return mKey;
	}
	public void setKey(int key){
		mKey = key; 
	}
	
	
}
