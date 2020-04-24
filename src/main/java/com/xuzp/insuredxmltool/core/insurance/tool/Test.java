package com.xuzp.insuredxmltool.core.insurance.tool;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Formula;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.FormulaUtil;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Value;
import com.xuzp.insuredxmltool.core.insurance.tool.script.Script;
import com.xuzp.insuredxmltool.core.insurance.tool.script.ScriptRuntimeException;
import com.xuzp.insuredxmltool.core.insurance.tool.script.Stack;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Text;
import com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.analyse.Words;

import java.net.HttpURLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void print(Object v) {
        System.out.println(v.getClass() + ": " + v);
    }

    public static String getCurrentThailandDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Bangkok"));
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] s) {

        String script = "int(2.9)";
        Formula formula = FormulaUtil.formulaOf(script);
        Object result = formula.run(new Stack());

        System.out.println(result);

//        System.out.println(1.0/12);
//
//        int start = 1000000;
//        double total = start;
//
//        for (int i = 0; i < 8; i++) {
//            total = total * 1.22 + 300000;
//            System.out.println("年份：" + (2019 + i) + "，目标金额：" + total);
//        }

//        System.out.println(total);

//        String str = "var s = 'aaa';//hhhh\n" +
//                "var a = 10.0;\n" +
//                "a++;\n" +
//                "/**\n" +
//                "测试注解*/\n" +
//                "var c = 'bbb';\n" +
//                "var x = 10;\n" +
//                "for(i = 0; i < 10; i++) {\n" +
//                "x++;\n" +
//                "}\n" +
//                "\n" +
//                "if(x > 0) {\n" +
//                "c = 'true'\n" +
//                "} else {\n" +
//                "c = 'false'\n" +
//                "}\n" +
//                "return a;";

//        System.out.println(Math.pow(10000,1.0/12));
//
//        String str = "return pow(10000,1/12.0)";
//
//        System.out.println(Text.cutComment(str));
//
//        Words words = Words.wordsOf(Text.cutComment(str));
//        System.out.println(words);
//
//        Script script = new Script(words, true);
//        System.out.println(script.run(new Factors() {
//            @Override
//            public Object get(String name) {
//                return null;
//            }
//        }));

//
//        String text = "a+b";
//        Script scr = Script.scriptOf(text);
//
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        System.out.println(getCurrentThailandDate());
//
//        try {
//            Date date = simpleDateFormat.parse("2018-08-14 17:24:55");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(789.93 + 9276.26 + 963.53);
//        Map map = new HashMap();
//        map.put("x", new Integer(65));
//        map.put("y", new Integer(61));
//
//        Stack stack = new Stack(new TestParam(map));
//
//        print(Script.scriptOf("x+y").run(stack));
//        print(Script.scriptOf("x*y").run(stack));
//        print(Script.scriptOf("x%y").run(stack));
//        print(Script.scriptOf("x/y").run(stack));
//        print(Script.scriptOf("x+=y").run(stack));
//        print(Script.scriptOf("x-y").run(stack));
//
//        String str = "return main();\n";
//
//        Formula script = Script.scriptOf(str);
//
//        long t1 = System.currentTimeMillis();
//
//        try {
//            System.out.println(script + " = " + script.run(stack));
//        } catch (ScriptRuntimeException e) {
//            e.printStackTrace();
//            System.out.println(e.getStackMap());
//        }
////
////		for (int i = 0; i < 1000000L; i++)
////			script.run(stack);
//
////		double x;
////
////		for (int i = 0; i < 100000000L; i++)
////		x = 12321321f / 2131231212f / 112321321f;
//
////		BigDecimal x1 = new BigDecimal(12321321f);
////		BigDecimal x2 = new BigDecimal(2131231212f);
////		BigDecimal x3 = new BigDecimal(112321321f);
////
////		for (int i = 0; i < 1000000L; i++)
////			x1.divide(x2, 10, RoundingMode.HALF_UP).divide(x3, 10, RoundingMode.HALF_UP);
//
//        System.out.println(System.currentTimeMillis() - t1 + "ms");
    }

//	public static void main2(String[] s)
//	{
////		File file = new File("D:/sd/workspace/base/lex-formula/src/lerrain/tool/formula/aries/FormulaCompiler.java");
//		File file = new File("D:/s/test.txt");
//		
//		Words ws = Words.wordsOf(Text.read(file));
//		
//		List text = Syntax.split(ws);
//		
////		for (int i=0;i<text.size();i++)
////			System.out.println(text.get(i));
//		
//		System.out.println(new Script(ws).toText(""));
//	}

    static class TestParam implements Factors {
        Map map;

        public TestParam(Map map) {
            this.map = map;
        }

        public Object get(String name) {
            return map.get(name);
        }

    }
}
