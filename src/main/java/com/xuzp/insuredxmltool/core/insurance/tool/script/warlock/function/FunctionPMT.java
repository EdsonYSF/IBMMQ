package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;


import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.FormulaUtil;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Value;
import com.xuzp.insuredxmltool.core.insurance.tool.script.Script;
import com.xuzp.insuredxmltool.core.insurance.tool.script.Stack;

public class FunctionPMT implements Function {

    public static void main(String[] args) {
        double result = calculatePMT(0.018, 240, 1000000);
        System.out.println(result);

        Script.addFunction("pmt", new FunctionPMT());
        String script = "pmt(0.018, 240, 1000000)";
        Object v = FormulaUtil.formulaOf(script).run(new Stack());
        System.out.println(v);
    }


    /**
     * 计算月供
     *
     * @param rate 年利率 年利率除以12就是月利率
     * @param nper 贷款期数，单位月 该项贷款的付款总数。
     * @param pv   贷款金额,现值，或一系列未来付款的当前值的累积和，也称为本金。
     * @return
     */
    public static double calculatePMT(double rate, double nper, double pv) {
        double v = (1 + (rate / 12));
        double t = (-(nper / 12) * 12);
        double result = (pv * (rate / 12)) / (1 - Math.pow(v, t));
        return result;
    }

    @Override
    public Object run(Object[] v, Factors p) {
        if (v.length < 3) {
            throw new RuntimeException("PMT函数参数不完整");
        }
        double rate = Value.doubleOf(v[0]);
        double nper = Value.doubleOf(v[1]);
        double pv = Value.doubleOf(v[2]);
        return calculatePMT(rate, nper, pv);
    }
}
