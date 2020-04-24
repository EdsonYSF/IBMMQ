package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.statement;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.script.ScriptRuntimeException;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.Code;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.CodeImpl;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Expression;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Words;

public class ArithmeticDivide extends CodeImpl {
    Code lc, rc;

    public ArithmeticDivide(Words ws, int i) {
        super(ws, i);

        lc = Expression.expressionOf(ws.cut(0, i));
        rc = Expression.expressionOf(ws.cut(i + 1));
    }

    public Object run(Factors factors) {
        Object l = lc.run(factors);
        Object r = rc.run(factors);

        if (l instanceof Number && r instanceof Number) {
            double lv = ((Number) l).doubleValue();
            double rv = ((Number) r).doubleValue();
            return lv / rv;
        }

//		return Double.valueOf(((Number)l).doubleValue() / ((Number)r).doubleValue());

        throw new ScriptRuntimeException(this, factors, "只可以对数字做除法运算: " + toText(""));
    }

    public String toText(String space) {
        return lc.toText("") + " / " + rc.toText("");
    }
}
