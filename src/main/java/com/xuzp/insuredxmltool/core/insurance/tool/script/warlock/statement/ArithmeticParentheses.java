package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.statement;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;
import com.xuzp.insuredxmltool.core.insurance.tool.script.ScriptRuntimeException;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.Code;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.CodeImpl;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.Wrap;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Expression;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Syntax;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Words;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function.FunctionTry;

public class ArithmeticParentheses extends CodeImpl
{
	Code left, prt;
	
	public ArithmeticParentheses(Words ws, int i)
	{
		super(ws, i);

		int l = i;
		int r = Syntax.findRightBrace(ws, l + 1);
		
//		if (l != 0 || r != ws.size() - 1)
//			throw new SyntaxException("小括号两侧有无法处理的代码");
//
//		if (l + 1 == r)
//			throw new SyntaxException("小括号运算内部不能为空");

		left = Expression.expressionOf(ws.cut(0, l));
		prt = Expression.expressionOf(ws.cut(l + 1, r));
	}

	public Object run(Factors factors)
	{
		try
		{
			if (left != null)
			{
				Function val = (Function) left.run(factors);

				if (val instanceof FunctionTry)
				{
					Object v = null;
					try
					{
						v = ((ArithmeticComma) prt).left().run(factors);
					}
					catch (Exception e)
					{
						if (((ArithmeticComma) prt).right() != null)
							v = ((ArithmeticComma) prt).right().run(factors);
					}
					return v;
				}

				Object[] params = null;

				if (prt != null)
				{
					Object r = prt.run(factors);
					if (r instanceof Wrap)
						params = ((Wrap) r).toArray();
					else
						params = new Object[]{r};
				}

				return val.run(params, factors);
			}
			else
			{
				return prt.run(factors);
			}
		}
		catch (Exception e)
		{
			throw new ScriptRuntimeException(this, factors, e);
		}
	}

	public String toText(String space)
	{
		return (left == null ? "" : left.toText("")) + "(" + (prt == null ? "" : prt.toText("")) + ")";
	}
}
