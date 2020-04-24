package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Value;

public class FunctionSleep implements Function
{
	public Object run(Object[] v, Factors factors)
	{
		try
		{
			Thread.sleep(Value.intOf(v[0]));
		}
		catch (InterruptedException e)
		{
		}

		return null;
	}
}
