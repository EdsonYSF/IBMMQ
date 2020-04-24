package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;

public class FunctionInteger implements Function
{
	public Object run(Object[] v, Factors factors)
	{
		Object x = v[0];

		if (x instanceof Integer)
			return x;
		if (x instanceof Number)
			return ((Number) x).intValue();
		if (x instanceof String)
			return Integer.parseInt((String)x);

		throw new RuntimeException("错误的int运算");
	}
}
