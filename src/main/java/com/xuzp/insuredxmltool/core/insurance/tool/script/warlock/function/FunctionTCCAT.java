package com.xuzp.insuredxmltool.core.insurance.tool.script.warlock.function;

import com.xuzp.insuredxmltool.core.insurance.tool.formula.Factors;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Function;
import com.xuzp.insuredxmltool.core.insurance.tool.formula.Value;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 2019/12/20 0020 10:30
 * @auther YangShengFu
 */
public class FunctionTCCAT implements Function {
    @Override
    public Object run(Object[] v, Factors p) {
        if (v.length < 2) {
            throw new RuntimeException("PMT函数参数不完整");
        }
        String rate = String.valueOf(v[0]);
        int rate1 = Value.intOf(v[1]);
        return calculateTCCAT(rate, rate1);
    }

    public static void main(String[] args) {
//        String result = calculateTCCAT("108/09/09",1);

        for (int i = 1; i < 192; i++) {
            calculateTCCAT("Mon Feb 13 00:00:00 CST 2006", i);
        }
    }

    /**
     * @param dateOfBirth 出生日期
     * @param M1          月
     * @return
     */
    public static double calculateTCCAT(String dateOfBirth, int M1) {
        double ret;
        if (StringUtils.isNotEmpty(dateOfBirth)) {
            String[] aStrings = dateOfBirth.split(" ");
            // 5
            if (aStrings[1].equals("Jan")) {
                aStrings[1] = "01";
            }
            if (aStrings[1].equals("Feb")) {
                aStrings[1] = "02";
            }
            if (aStrings[1].equals("Mar")) {
                aStrings[1] = "03";
            }
            if (aStrings[1].equals("Apr")) {
                aStrings[1] = "04";
            }
            if (aStrings[1].equals("May")) {
                aStrings[1] = "05";
            }
            if (aStrings[1].equals("Jun")) {
                aStrings[1] = "06";
            }
            if (aStrings[1].equals("Jul")) {
                aStrings[1] = "07";
            }
            if (aStrings[1].equals("Aug")) {
                aStrings[1] = "08";
            }
            if (aStrings[1].equals("Sep")) {
                aStrings[1] = "09";
            }
            if (aStrings[1].equals("Oct")) {
                aStrings[1] = "10";
            }
            if (aStrings[1].equals("Nov")) {
                aStrings[1] = "11";
            }
            if (aStrings[1].equals("Dec")) {
                aStrings[1] = "12";
            }

            String dateOfBirthStr= aStrings[5] + "/" + aStrings[1] + "/" + aStrings[2] ;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            //出生年份
            String startYear = dateOfBirthStr.substring(0, dateOfBirthStr.indexOf("/"));
            //出生月份
            String endDate = dateOfBirthStr.substring(startYear.length() + 1, dateOfBirthStr.length());
            //15年后年份
            int year15 = Integer.valueOf(startYear) + 15;
            //北京当前日期
            Date now = new Date();
            String createData = dateFormat.format(now);
            int startBJYear = Integer.valueOf(createData.substring(0, createData.indexOf("/")));
            //台湾当前年份
//            int differ = year15 - (startBJYear - 1912 + 1);
            //15年后北京日期
            String endBJ15data = year15 + "/" + endDate;
            Date startBJDate = null;
            Date endBJDate = null;
            try {
                startBJDate = dateFormat.parse("1899/12/30");
                endBJDate = dateFormat.parse(endBJ15data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar rightNow0 = Calendar.getInstance();
            rightNow0.setTime(now);
            rightNow0.add(Calendar.DAY_OF_MONTH, -1);
            Date dt0 = rightNow0.getTime();
            Calendar rightNow1 = Calendar.getInstance();
            rightNow1.setTime(dt0);
            rightNow1.add(Calendar.MONTH, M1);
            Date dt1 = rightNow1.getTime();

            Calendar rightNow2 = Calendar.getInstance();
            rightNow2.setTime(dt0);
            rightNow2.add(Calendar.DAY_OF_MONTH, 1);
            Date dt2 = rightNow2.getTime();
            Calendar rightNow3 = Calendar.getInstance();
            rightNow3.setTime(dt2);
            rightNow3.add(Calendar.MONTH, M1 - 1);
            Date dt3 = rightNow3.getTime();

            //相差总天数
            Long a = (endBJDate.getTime() - startBJDate.getTime()) / (24 * 3600 * 1000);
            //加一月减一天总天数
            Long b = (dt1.getTime() - startBJDate.getTime()) / (24 * 3600 * 1000);
            //加一月加一天总天数
            Long c = (dt3.getTime() - startBJDate.getTime()) / (24 * 3600 * 1000);
            if (a > b) {
                ret = 0;
            } else {
                if (a < c) {
                    ret = 1;
                } else {
                    double p = b - a + 1;
                    double n = b - c + 1;
                    ret = p / n;
                }
            }

        } else {
            ret = 1;
        }
        return ret;

    }

}
