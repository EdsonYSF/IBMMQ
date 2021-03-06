package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;

import java.util.Date;

public class FunctionFormat implements Function
{
	public Object run(Object[] v, Factors factors)
	{
		if (v.length == 1)
		{
			Object val = v[0];
			if (val == null)
				return "";
			else if (val instanceof Date)
				return val.toString();
			else
				return val.toString();
		}
		
		if (v.length > 1)
		{
			String style = (String)v[0];
			Object[] vals = new Object[v.length - 1];
			for (int i=0;i<vals.length;i++)
				vals[i] = v[i + 1];

			return String.format(style, vals);
		}
		
		throw new RuntimeException("错误的format运算");
	}
}
