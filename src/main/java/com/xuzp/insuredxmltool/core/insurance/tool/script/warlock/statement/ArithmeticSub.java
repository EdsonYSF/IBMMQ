package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.statement;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.script.ScriptRuntimeException;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.Code;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.CodeImpl;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Expression;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Words;

public class ArithmeticSub extends CodeImpl
{
	Code lc, rc;
	
	public ArithmeticSub(Words ws, int i)
	{
		super(ws, i);

		if (i > 0)
			lc = Expression.expressionOf(ws.cut(0, i));
		else
			lc = null;
		
		rc = Expression.expressionOf(ws.cut(i + 1));
	}

	public Object run(Factors factors)
	{
		Object l = lc == null ? 0 : lc.run(factors);
		Object r = rc.run(factors);

		if (l instanceof Number && r instanceof Number)
		{
			if (isFloat(l) || isFloat(r))
				return ((Number) l).doubleValue() - ((Number) r).doubleValue();
			else if (isInt(l) && isInt(r))
				return ((Number) l).intValue() - ((Number) r).intValue();
			else
				return ((Number) l).longValue() - ((Number) r).longValue();
		}

		throw new ScriptRuntimeException(this, factors, "只可以对数字做减法运算：" + l + " - " + r);
	}

	public String toText(String space)
	{
		return lc == null ? "-" + rc.toText("") : (lc.toText("") + " - " + rc.toText(""));
	}
}
