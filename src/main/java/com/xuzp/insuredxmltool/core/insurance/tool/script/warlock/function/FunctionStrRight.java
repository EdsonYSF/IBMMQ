package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Value;

public class FunctionStrRight implements Function
{
	public Object run(Object[] v, Factors factors)
	{
		if (v.length == 2)
		{
			String str = v[0].toString();
			int s = Value.intOf(v[1]);

			int len = str.length();
			if (len <= s)
				return str;
			else
				return str.substring(len - s, len);
		}
		
		throw new RuntimeException("错误的str_right运算");
	}
}
