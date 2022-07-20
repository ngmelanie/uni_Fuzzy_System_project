package com.jsf.bootstrap;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

@ManagedBean(name = "system")
@SessionScoped
public class dengue_symptom {
	private float achesPains;
	private float feverDays;
	private float haemo;
	private float rash;
	private String fuzzyResult;
	private FunctionBlock functionBlock;
	
	public String createOutput() {
		functionBlock.setVariable("aches_pains", getAchesPains());
		functionBlock.setVariable("fever_days", getFeverDays());
		functionBlock.setVariable("haemorrhagic_manifestation", getHaemo());
		functionBlock.setVariable("rash", getRash());
		
		functionBlock.evaluate();
		
		// Show output variable's chart
		Variable possibility_of_getting_dengue = functionBlock.getVariable("possibility_of_getting_dengue");

		// Print ruleSet
		System.out.println("Possibility of getting dengue:"
				+ (functionBlock.getVariable("possibility_of_getting_dengue").getValue()*10));
		
		setFuzzyResult("" + (functionBlock.getVariable("possibility_of_getting_dengue").getValue()*10));
		
		return "output2";
	}
	
	public dengue_symptom() {
		System.out.println("This is Fuzzy Tipper Expert System");
		FacesContext ctx = FacesContext.getCurrentInstance();
		String mconstant = ctx.getExternalContext().getRealPath("/dengue.fcl");
		FIS fis = FIS.load(mconstant, true);
		if (fis == null) { // Error while loading?
			return;
		}	
		functionBlock = fis.getFunctionBlock(null);
	}

	public float getAchesPains() {
		return achesPains;
	}

	public void setAchesPains(float achesPains) {
		this.achesPains = achesPains;
	}

	public float getFeverDays() {
		return feverDays;
	}

	public void setFeverDays(float feverDays) {
		this.feverDays = feverDays;
	}

	public float getHaemo() {
		return haemo;
	}

	public void setHaemo(float haemo) {
		this.haemo = haemo;
	}

	public float getRash() {
		return rash;
	}

	public void setRash(float rash) {
		this.rash = rash;
	}

	public String getFuzzyResult() {
		return fuzzyResult;
	}

	public void setFuzzyResult(String fuzzyResult) {
		this.fuzzyResult = fuzzyResult;
	}
}