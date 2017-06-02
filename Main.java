import java.util.List;

import automaton.DeterministicAutomaton;
import grammar.Rule;
import io.SingletonInput;


public class Main {

	public static void main(String[] args) throws Exception {
			
		List<String> input = SingletonInput.getInstance().getContentLines();
		
		List<Rule> rules = Rule.mount(input);
		
		
		DeterministicAutomaton automaton = new DeterministicAutomaton(rules);
	
		for(Rule rule : automaton.getRules()){
			rule.Print();
		}
		
	}
}
