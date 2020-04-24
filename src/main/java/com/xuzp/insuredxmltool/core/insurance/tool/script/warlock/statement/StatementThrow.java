package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.statement;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Value;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.Code;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Expression;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Words;

public class StatementThrow implements Code
{
	Code r;
	
	public StatementThrow(Words ws)
	{
		r = Expression.expressionOf(ws.cut(1));
	}

	public Object run(Factors factors)
	{
		throw new RuntimeException(Value.stringOf(r, factors));
//		return Interrupt.interruptOf(Interrupt.THROW, r.run(factors));
	}

	public String toText(String space)
	{
		return "THROW " + r.toText("");
	}
}
