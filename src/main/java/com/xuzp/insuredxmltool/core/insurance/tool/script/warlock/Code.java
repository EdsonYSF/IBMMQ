package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Formula;

public interface Code extends Formula
{
	public Object run(Factors factors);
	
	public String toText(String space);

	//public void printCode();
}
