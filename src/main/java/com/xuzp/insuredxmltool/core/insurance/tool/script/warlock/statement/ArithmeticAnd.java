package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.statement;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Value;
import com.xuzp.insuredxmltool.core.insurance.tool.script.ScriptRuntimeException;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.Code;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.CodeImpl;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Expression;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Words;

public class ArithmeticAnd extends CodeImpl
{
	Code l, r;
	
	public ArithmeticAnd(Words ws, int i)
	{
		super(ws, i);

		l = Expression.expressionOf(ws.cut(0, i));
		r = Expression.expressionOf(ws.cut(i + 1));
	}

	public Object run(Factors factors)
	{
		try
		{
			return new Boolean(v(l, factors) && v(r, factors));
		}
		catch (Exception e)
		{
			throw new ScriptRuntimeException(this, factors, e);
		}
	}
	
	private boolean v(Code c, Factors factors)
	{
		return Value.booleanOf(c.run(factors));
	}

	public String toText(String space)
	{
		return l.toText("") + " AND " + r.toText("");
	}
}
