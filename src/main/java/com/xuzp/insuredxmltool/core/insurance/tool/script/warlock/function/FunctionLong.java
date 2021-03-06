package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;

import java.util.Date;

public class FunctionLong implements Function
{
	public Object run(Object[] v, Factors factors)
	{
		Object x = v[0];

		if (x instanceof Long)
			return x;
		if (x instanceof Number)
			return ((Number) x).longValue();
		if (x instanceof Date)
			return ((Date) x).getTime();
		if (x instanceof String)
			return Long.parseLong((String)x);

		throw new RuntimeException("错误的long运算");
	}
}
