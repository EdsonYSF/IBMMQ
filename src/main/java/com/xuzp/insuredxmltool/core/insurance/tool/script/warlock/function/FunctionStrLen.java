package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;

public class FunctionStrLen implements Function
{
	public Object run(Object[] v, Factors factors)
	{
		if (v.length == 1)
		{
			return v[0].toString().length();
		}
		
		throw new RuntimeException("错误的str_len运算");
	}
}
