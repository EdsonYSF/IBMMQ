package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.statement;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.script.Script;
import com.xuzp.insuredxmltool.core.insurance.tool.script.Stack;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.Code;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Syntax;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Words;

public class StatementThread implements Code
{
	Code pre, code;

	public StatementThread(Words ws)
	{
		int left = 1; //callback左括号的位置
		if (ws.getType(left) == Words.PRT)
		{
			int right = Syntax.findRightBrace(ws, left + 1);
			Words preWords = ws.cut(left + 1, right);
			pre = preWords.size() > 0 ? new Script(preWords) : null;
			left = right + 1;
		}

		if (ws.getType(left) != Words.BRACE)
			throw new RuntimeException("thread 代码体需要以大括号包裹");

		int right = Syntax.findRightBrace(ws, left + 1);
		code = new Script(ws.cut(left + 1, right));
	}

	public Object run(final Factors factors)
	{
		final Stack stack = new Stack(factors);
		Object r = pre == null ? null : pre.run(stack);

		Thread th = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				code.run(stack);
			}
		});
		th.start();

		return r;
	}

	public String toText(String space)
	{
		StringBuffer buf = new StringBuffer("THREAD (");
		buf.append(pre == null ? "" : pre.toText(""));
		buf.append(")\n");
		buf.append(space + "{\n");
		buf.append(code.toText(space + "    ") + "\n");
		buf.append(space + "}");

		return buf.toString();
	}
}
