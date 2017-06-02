package globals;

import java.util.ArrayList;
import java.util.List;

public class GlobalInfo {
	
  private static GlobalInfo instance = null;
    
    private GlobalInfo(){}
        
    private List<String> letters = new ArrayList<String>();
    private List<String> finalStates = new ArrayList<String>();
    private String initialState = "";
    
    public static GlobalInfo getInstance(){
        
    	if(instance == null){
        	
			instance = new GlobalInfo();
        }
        
        return instance;
    }

	public List<String> getLetters() {
		return letters;
	}

	public void addLetter(String letter) {
		 
		if(instance.letters.size() == 0)
			instance.initialState = letter;
		
		if(instance.letters.contains(letter) == false)
			instance.letters.add(letter);
	}

	public List<String> getFinalStates() {
		return finalStates;
	}

	public void addFinalState(String finalStates) {
		if(instance.finalStates.contains(finalStates) == false)
			instance.finalStates.add(finalStates);
	}

	public String getInitialState() {
		return initialState;
	}
}
