import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyTipperExpertSystemDengue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("This is Fuzzy Tipper Expert System");
    // Load from 'FCL' file
    String fileName = "C:\\Users\\asus\\Desktop\\Java Fuzzy Dengue\\Dengue.fcl";
    FIS fis = FIS.load(fileName, true);
	if (fis == null) { // Error while loading?
		System.err.println("Can't load file: '" + fileName + "'");
		return;
	}

	// Show ruleset
	FunctionBlock functionBlock = fis.getFunctionBlock(null);
	JFuzzyChart.get().chart(functionBlock);

	// Set inputs
	functionBlock.setVariable("aches_pains", 2);
    functionBlock.setVariable("fever_days", 2);
    functionBlock.setVariable("haemorrhagic_manifestation", 2);
    functionBlock.setVariable("rash", 2);
	// Evaluate 
	functionBlock.evaluate();

	// Show output variable's chart
	Variable possibility_of_getting_dengue = functionBlock.getVariable("possibility_of_getting_dengue");
	JFuzzyChart.get().chart(possibility_of_getting_dengue, possibility_of_getting_dengue.getDefuzzifier(), true);
	Gpr.debug("less[fever_days]: " + functionBlock.getVariable("fever_days").getMembership("normal"));

	// Print ruleSet
	System.out.println(functionBlock);
	System.out.println("Possibility of getting dengue:" + functionBlock.getVariable("possibility_of_getting_dengue").getValue());

	
	
	}

}
