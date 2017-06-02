package automaton;
import grammar.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeterministicAutomaton {

	private List<Rule> m_rules = new ArrayList<Rule>();
	
	public  DeterministicAutomaton(List<Rule> rules){
				
		List<Rule> newRules = new ArrayList<Rule>();
		
		this.m_rules.addAll(rules);
		
		for(Rule rule : rules){
			
			if(rule.hasIndeterminism() == false)
				continue;
			
			for(String key : rule.getProductions().keySet()){
				
				List<String> productions = new ArrayList<String>(rule.getProductions().get(key));
				
				if(rule.getProductions().get(key).size() <= 1)
					continue;
				
				
				Rule newRule = createState(productions, key);
				
				newRules.add(newRule);
			}
		}
		
		this.m_rules.addAll(newRules);
	}
	
	
	private Rule createState(List<String> productions, String key){
		
		Rule rule = new Rule();
				
		rule.setRule("{" + String.join(",", productions) + "}");
		
		
				
		return rule;			
	}
	
	public List<Rule> getRules(){
		return this.m_rules;
	}
}
