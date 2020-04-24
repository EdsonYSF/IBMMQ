import com.xuzp.insuredxmltool.core.insurance.plan.Commodity;
import com.xuzp.insuredxmltool.core.insurance.plan.InsuranceCustomer;
import com.xuzp.insuredxmltool.core.insurance.plan.Plan;
import com.xuzp.insuredxmltool.core.insurance.plan.filter.liability.Liability;
import com.xuzp.insuredxmltool.core.insurance.product.Company;
import com.xuzp.insuredxmltool.core.insurance.product.Insurance;
import com.xuzp.insuredxmltool.core.insurance.product.Purchase;
import com.xuzp.insuredxmltool.core.insurance.product.attachment.coverage.Coverage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author za-xuzhiping
 * @Date 2019/4/8
 * @Time 20:18
 */
public class CheckXML extends ProductSupport{

    public static void main(String[] arg) throws Exception {

        Company hq = load("cardif");

        System.out.println("--- 可选的产品列表 ---");
        List<Insurance> l = hq.getProductList();
        for (Insurance p : l)
            System.out.println("<" + p.getId() + "> " + (p.isMain() ? "<主>" : "<附>") + " " + p.getName());
        System.out.println();

        //新建一个建议书对象
        Proposal proposal = new Proposal();

        //投保人
        InsuranceCustomer applicant = new Customer("1970-2-13", InsuranceCustomer.GENDER_MALE);
        proposal.setApplicant(applicant);


        //被保险人
        InsuranceCustomer insurant = new Customer("1970-2-13", InsuranceCustomer.GENDER_FEMALE,"","0");


        //投保计划
        Plan plan = proposal.newPlan(insurant);
////      //被保险人
//        InsuranceCustomer insurant1 = new Customer("1992-01-03", InsuranceCustomer.GENDER_MALE,"","03");
//        plan.addInsurant(insurant1);
        //被保险人
//        InsuranceCustomer insurant2 = new Customer("1999-01-03", InsuranceCustomer.GENDER_MALE);
//        plan.addInsurant(insurant2);
//        plan.getInsurants();
        //System.out.println(plan.getFactors().get("INSURANTS"));

        //获取一个产品，添加到计划
        Commodity main;
        Commodity rider;
        Commodity rider2;




        /**
         * 金赚100台幣年金
         */
//        main = plan.newCommodity(hq.getProduct("JZ100_UA0018_TCCB"));
//        main.setPremium(1000000);
//        main.setInput("pay_freq", "flexable");
//        main.setInput("pay", "single");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.04);
//        main.setValue("reward_rate_2", 0.05);
//        main.setValue("reward_rate_3", -0.05);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("PAY_ANNUITY_AGE", 80);


        /**
         * 金赚100外幣年金
         */
//        main = plan.newCommodity(hq.getProduct("JZ100_XA0018_TCCB"));
//        main.setPremium(100);
//        main.setInput("pay_freq", "elastic");
//        main.setInput("pay", "single");
//        main.setInput("currency", "USD");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);



        /**
         * 金赚100 台币寿险
         */
//        main = plan.newCommodity(hq.getProduct("JZ100_UL0018_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "NTD");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("percentage", "101");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.00);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.5);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.4);
//        main.setValue("currency_rate", 0);
//        main.setValue("AMOUNT_RATE", 0);
//
//        main.setValue("AUTO_AMOUNT", "false");
//        rider=plan.newCommodity(main,hq.getProduct("UDD002_TCCB"));
//        rider.setAmount(50);



        /**
         * 金赚100外币寿险
         */
//        main = plan.newCommodity(hq.getProduct("JZ100_XL0018_TCCB"));
//        main.setPremium(50000001);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "JPY");
//        main.setInput("product_sort", "sort_2");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.00);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.4);
//        main.setValue("currency_rate", 0);
//        main.setValue("AUTO_AMOUNT", "true");
//        main.setValue("judge", "JYS");
//        main.setValue("AMOUNT_RATE", 1);


        /**
         * 尊爵台币年金
         */
//        main = plan.newCommodity(hq.getProduct("UA0032_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.5);
//        main.setValue("etf_rate", 0.5);
//        main.setValue("invest_rate", 50);
//        main.setValue("currency_rate", 0);
//        main.setValue("PAY_ANNUITY_AGE", 80);
//        main.setValue("ANNUITY_REWARD_WAY", "single");


        /**
         * 尊爵100外幣年金
         */
//        main = plan.newCommodity(hq.getProduct("XA0032_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "elastic");
//        main.setInput("pay", "single");
//        main.setInput("currency", "USD");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("PAY_ANNUITY_AGE", 80);
//        main.setValue("ANNUITY_REWARD_WAY", "single");

        /**
         * 尊爵100變額萬能壽險
         */
//        main = plan.newCommodity(hq.getProduct("UL0032_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "NTD");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.5);
//        main.setValue("etf_rate", 0);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("amount_rate", 111);

        /**
         * 尊爵100變額外币萬能壽險
         */
//        main = plan.newCommodity(hq.getProduct("XL0032_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "USD");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0);
//        main.setValue("etf_rate", 0);
//        main.setValue("invest_rate", 0);
//        main.setValue("currency_rate", 0);
//        main.setValue("amount_rate", 130);



        /**
         * 稳赚100台幣年金
         */
//        main = plan.newCommodity(hq.getProduct("WZ100_UA0007_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "flexable");
//        main.setInput("pay", "single");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("PAY_ANNUITY_AGE", 80);


        /**
         * 稳赚100外幣年金
         */
//        main = plan.newCommodity(hq.getProduct("XA0006_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "elastic");
//        main.setInput("pay", "single");
//        main.setInput("currency", "USD");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);



        /**
         * 稳赚100 台币寿险
         */
//        main = plan.newCommodity(hq.getProduct("WZ100_UL0014_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "NTD");
//        main.setInput("product_sort", "sort_2");
//        main.setInput("birthday_payment_age", "110");
//        main.setInput("percentage_two", "0");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.00);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.4);
//        main.setValue("currency_rate", 0);
//        main.setValue("amount_rate", 30);
//        main.setValue("AUTO_AMOUNT", "false");


        /**
         * 稳赚100外币寿险
         */
//        main = plan.newCommodity(hq.getProduct("WZ100_XL0006_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "elastic");
//        main.setInput("currency", "USD");
//        main.setInput("pay", "term_1");
//        main.setInput("product_sort", "sort_2");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.5);
//        main.setValue("etf_rate", 0);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("amount_rate", 30);
//        main.setValue("AUTO_AMOUNT", "false");


        /**
         * 满福100台幣年金
         */
//        main = plan.newCommodity(hq.getProduct("MF100_UA0046_JSIB"));
//        main.setPremium(300000000);
//        main.setInput("pay_freq", "flexable");
//        main.setInput("pay", "single");
//        main.setInput("birthday_payment_age", "80");
//        main.setInput("PAY_WAY", "remit");
//        main.setInput("ANNUITY_REWARD_WAY", "single");
//        main.setInput("ANNUITY_REWARD_PERIOD", "term_10");
//        main.setInput("ANNUITY_REWARD_FREQ", "monthly");
//        main.setInput("AMOUNT_RATE", "monthly");
//        main.setValue("reward_rate_1", 0.04);
//        main.setValue("reward_rate_2", 0.03);
//        main.setValue("reward_rate_3", -0.04);
//        main.setValue("etf_rate", 30);
//        main.setValue("currency_rate", 30);
//        main.setValue("PAY_ANNUITY_AGE", 80);
//        rider=plan.newCommodity(main,hq.getProduct("UDD002_JSIB"));
//        rider.setAmount(99);
//        rider2=plan.newCommodity(main,hq.getProduct("UPA002_JSIB"));
//        rider2.setAmount(110);

        /**
         * 满福100外幣年金
         */
//        main = plan.newCommodity(hq.getProduct("MF100_XA0046_JSIB"));
//        main.setPremium(10000000);
//        main.setInput("pay_freq", "elastic");
//        main.setInput("pay", "single");
//        main.setInput("currency", "USD");
//        main.setInput("birthday_payment_age", "80");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.3);
//        main.setValue("etf_rate", 0.3);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);

        /**
         * 满福100 台币寿险
         */
//        main = plan.newCommodity(hq.getProduct("MF100_UL0046_JSIB"));
//        main.setPremium(300001);
//        main.setInput("pay_freq", "flexable");
//        main.setInput("pay", "single");
//        main.setInput("currency", "NTD");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.01);
//        main.setValue("reward_rate_2", 0.00);
//        main.setValue("reward_rate_3", -0.01);
//        main.setValue("mf_rate", 100);
//        main.setValue("etf_rate", 0);
//        main.setValue("invest_rate", 0);
//        main.setValue("currency_rate", 0);
//        main.setValue("AMOUNT_RATE", 130);
//        main.setValue("judge", "JYS");
//        main.setValue("AUTO_AMOUNT", "false");
//        rider=plan.newCommodity(main,hq.getProduct("UDD002_JSIB"));
//        rider.setAmount(100);
//        rider2=plan.newCommodity(main,hq.getProduct("UPA002_JSIB"));
//        rider2.setAmount(100);

        /**
         * 满福100外币寿险
         */
//        main = plan.newCommodity(hq.getProduct("MF100_XL0046_JSIB"));
//        main.setPremium(2999999);
//        main.setInput("pay_freq", "flexable");
//        main.setInput("currency", "USD");
//        main.setInput("pay", "term_1");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.02);
//        main.setValue("reward_rate_2", 0.01);
//        main.setValue("reward_rate_3", -0.02);
//        main.setValue("AMOUNT_RATE", 130);
//        main.setValue("AUTO_AMOUNT", "true");
//        main.setValue("judge", "JYS");

        /**
         * 超級達人台幣壽險
         */
//        main = plan.newCommodity(hq.getProduct("UL0040_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "NTD");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.5);
//        main.setValue("etf_rate", 0);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("amount_rate", 130);



        /**
         * 超級達人外幣年金
         */
//        main = plan.newCommodity(hq.getProduct("XA0040_CHB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "USD");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.5);
//        main.setValue("etf_rate", 0);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("amount_rate", 130);


        /**
         * 超级达人外币寿险
         */
//        main = plan.newCommodity(hq.getProduct("XL0040_TCCB"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("currency", "USD");
//        main.setInput("product_sort", "sort_1");
//        main.setInput("birthday_payment_age", "110");
//        main.setValue("reward_rate_1", 0.06);
//        main.setValue("reward_rate_2", 0.02);
//        main.setValue("reward_rate_3", -0.06);
//        main.setValue("mf_rate", 0.5);
//        main.setValue("etf_rate", 0);
//        main.setValue("invest_rate", 0.5);
//        main.setValue("currency_rate", 0);
//        main.setValue("amount_rate", 130);



        /**
         * 幸福世貸平準型
         */
//        main = plan.newCommodity(hq.getProduct("XFSD_SITC_TCCB"));
//        main.setAmount(100);
//        main.setInput("pay_freq", "single");//交费方式
//        main.setInput("insure", "term_20");//保险期间
//        main.setInput("pay", "term_1");//繳費年期
//        main.setInput("pay_method", "cash");//现金还是融资
//        double[][] array = new double[3][];
//        array[0] = new double[]{1,12,1.8,1.8};
//        array[1] = new double[]{13,24,2.0,2.0};
//        array[2] = new double[]{25,36,2.3,2.3};
//        main.setValue("rate_info",array);
//        main.setValue("loan_amount", 100);//贷款金额
//        main.setValue("loan_term", 20);//贷款年期
//        main.setValue("LOAN_GRACE_PERIOD", 0);//贷款宽限期
//        main.setValue("judge", "JYS");//贷款宽限期

        /**
         * 幸福世貸递减型
         */
//        main = plan.newCommodity(hq.getProduct("XFSD_SITC_TCCB"));
//        main.setAmount(100);
//        main.setInput("product_sort", "A");
//        main.setInput("pay_freq", "single");//交费方式
//        main.setInput("insure", "term_4");//保险期间
//        main.setInput("pay", "term_1");//繳費年期
//        main.setInput("pay_method", "cash");//现金还是融资
//        double[][] array = new double[3][];
//        array[0] = new double[]{1,12,1.8,1.8};
//        array[1] = new double[]{13,24,2.0,2.0};
//        array[2] = new double[]{25,48,2.3,2.3};
//        main.setValue("rate_info",array);
//        main.setValue("loan_amount", 100);//贷款金额
//        main.setValue("loan_term", 4);//贷款年期
//        main.setValue("LOAN_GRACE_PERIOD", "");//贷款宽限期


        /**
         * 复兴
         */
//        main = plan.newCommodity(hq.getProduct("FXL000031"));
//        main.setInput("pay", "single");
//        main.setInput("insure", "big_term_1");
//        main.setInput("medicare", "no"); //有无社保
//        main.setInput("renewal", "yes"); //是否自动续保
//        main.setInput("hospital_duty", "9"); //一般住院、恶性肿瘤医疗责任
//        main.setInput("hospital_deductible", "20000"); //住院年免赔额
//        main.setInput("cancer_duty", "9"); //恶性肿瘤住院津贴责任
//        main.setInput("outpatient_duty", "9"); //门急诊医疗责任
//        main.setInput("deductible_type", "0"); //门急诊医疗责任
//        main.setInput("clinic_deductible_second", "500"); //门急诊医疗责任
//        main.setInput("juveniles", "9"); //未成年人检查与免疫医疗责任
//        main.setInput("compensation_ratio", "1"); //赔付比例

//         main = plan.newCommodity(hq.getProduct("FXL000033"));
//         main.setInput("pay_freq", "single");
//         main.setInput("pay", "single");
//         main.setInput("insure", "term_1"); //有无社保
//         main.setInput("plan_select", "0"); //是否自动续保


        /**
         * 复兴
         */
//        main = plan.newCommodity(hq.getProduct("FXL000023"));
//        main.setAmount(10000);
//        main.setInput("pay_freq", "single");
//        main.setInput("pay", "single");
//        main.setInput("insure", "to_105"); //有无社保
//        main.setInput("protection_plan", "7"); //是否自动续保

        /**
         * 复兴
         */
//         main = plan.newCommodity(hq.getProduct("FXL000035"));
//            main.setAmount(100000);
//         main.setInput("pay_freq", "year");
//         main.setInput("pay", "term_5");
//         main.setInput("insure", "to_80"); //有无社保
//         main.setInput("kxzr", "0");
        /**
         * 复兴
         */
//        main = plan.newCommodity(hq.getProduct("FXL000034"));
//        main.setAmount(10000);
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_5");
//        main.setInput("insure", "to_80");

        /**
         * 复兴
         */
//        main = plan.newCommodity(hq.getProduct("FXL000037"));
//        main.setAmount(10000);
//        main.setInput("pay_freq", "year");
//        main.setInput("insure", "to_80");
//        main.setInput("pay", "term_20");
//        main.setInput("second_insurance", "1");
//        main.setInput("rare_disease", "2");

        /**
         * 横琴
         */
//        main = plan.newCommodity(hq.getProduct("HQL00150"));
//        main.setAmount(100000);
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_18");
//        main.setInput("insure", "to_full");

        /**
         * 中意
         */
//        main = plan.newCommodity(hq.getProduct("ZY000037"));
//        main.setAmount(100000);
//        main.setInput("PAY_FREQ", "single");
//        main.setInput("pay", "term_20");
//        main.setInput("insure", "full_106");

        /**
         * 中意百万护驾两全保险
         */
//        main = plan.newCommodity(hq.getProduct("ZY000042"));
//        main.setAmount(250);
//        main.setInput("PAY_FREQ", "year");
//        main.setInput("pay", "term_10");
//        main.setInput("insure", "term_30");

        /**
         * 中意附加乐游天下意外医疗保险
         */
//        main = plan.newCommodity(hq.getProduct("ZY000046"));
//        main.setAmount(100000);



        /**
         * 安邦长青树重大疾病保险
         */
//        main = plan.newCommodity(hq.getProduct("DJ00001"));
//        main.setAmount(10000);
//        main.setInput("insure", "full_105");
//        main.setInput("pay", "single");

        /**
         * 安邦万年盈年金保险
         */
//        main = plan.newCommodity(hq.getProduct("DJ00002"));
//        main.setAmount(1000);
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_3");
//        main.setInput("insure", "full_106");

        /**
         * 安邦乐安一生重大疾病保险
         */
//        main = plan.newCommodity(hq.getProduct("DJ00003"));
//        main.setAmount(100000);
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_10");
//        main.setInput("insure", "full_106");




        /**
         * 安邦家业星终身寿险
         */
//        main = plan.newCommodity(hq.getProduct("DJ00004"));
//        main.setPremium(100000);
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_20");
//        main.setInput("insure", "full_106");

        /**
         * 安邦乐安一生重疾保障计划
         */
//        main = plan.newCommodity(hq.getProduct("DJ00005"));
//        main.setAmount(100000);
//        main.setInput("pay", "term_10");
//        main.setInput("insure", "full_106");

        /**
         * 安邦附加乐安一生两全保险
         */
//        main = plan.newCommodity(hq.getProduct("DJ00011"));
//        main.setAmount(500000);
//        main.setInput("insure", "to_80");
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_30");

//        main = plan.newCommodity(hq.getProduct("DJ00010"));
//        main.setAmount(500000);
//        main.setInput("insure", "full_106");
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_30");
//        rider=plan.newCommodity(main,hq.getProduct("DJ00011"));
//        rider.setAmount(500000);
//        rider.setInput("insure", "to_80");
//        rider.setInput("pay_freq", "year");
//        rider.setInput("pay", "term_30");




        /**
         *
         * I保
         */
//        main = plan.newCommodity(hq.getProduct("HQL00130"));
//        main.setAmount(100000);
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_20");
//        main.setInput("insure", "to_full");



        /**
         *
         * I保
         */
//        main = plan.newCommodity(hq.getProduct("HQL00130"));
//        main.setAmount(100000);
//        main.setInput("pay_freq", "year");
//        main.setInput("pay", "term_20");
//        main.setInput("insure", "to_full");


        /**
         * 汇丰
         */
        main = plan.newCommodity(hq.getProduct("HF000017"));
        main.setPremium(200000);
        main.setInput("pay_freq", "year");
        main.setInput("pay", "term_3");
        main.setInput("insure", "term_10");
        main.setInput("draw_age", "term_5");
        main.setInput("draw", "to_term_10");
        main.setInput("get_annuity_end", "10");


        Map<String, Object> map=new HashMap<>();
        map.put("1","1");
        map.put("2","");
        List<Map<String, Object>> s=new ArrayList<>();
        s.add(map);
        for(Map<String, Object> m:s){
            String p="0";
            if(m.containsKey("2")){
                 p=m.get("2").toString();
            }

            System.out.println(p);
        }




        if (checkRule(plan)) //检查投保规则
            print(plan);
    }

    /**
     * 输出结果
     *
     * @param plan
     */
    public static void print(Plan plan) {
        StringBuilder builder = new StringBuilder();
        builder.append("--- 输出结果 ---\n");

        for (int i = 0; i < plan.size(); i++) {
            Commodity c = plan.getCommodity(i);

            builder.append("产品：" + c.getProduct().getName());

            //保额/档次/份数
            int mode = c.getProduct().getInputMode();
            if (mode == Purchase.AMOUNT)
                builder.append("，保额/档次/份数：" + c.getAmount() + "元");
            else if (mode == Purchase.RANK)
                builder.append("，保额/档次/份数：" + c.getRank().getDesc());
            else if (mode == Purchase.QUANTITY)
                builder.append("，保额/档次/份数：" + c.getQuantity() + "份");

            if (c.getInput("pay_freq") != null) {
                builder.append("，交费频次：" + c.getInput("pay_freq").getDesc());
            }

            if (c.getInsure() != null)
                builder.append("，保险期间：" + c.getInsure().getDesc());
            if (c.getPay() != null)
                builder.append("，交费年期：" + c.getPay().getDesc());

            //保费
            builder.append("，保费：" + c.getPremium() + "元" + "\n");
        }

        System.out.println(builder.toString());

        builder.append("<br/>");
        for (int i = 0; i < plan.size(); i++) {
            Commodity c = plan.getCommodity(i);

            //打印该产品的利益表
            System.out.println("--- " + c.getProduct().getName() + "的利益表 ---" + "\n");
            builder.append("--- " + c.getProduct().getName() + "的利益表 ---" + "<br/>");
            builder.append(printDocument(c.format("benefit_table")) + "\n");

            //打印该产品的保险责任
            System.out.println("--- " + c.getProduct().getName() + "的保险责任 ---" + "\n");
            builder.append("--- " + c.getProduct().getName() + "的保险责任 ---" + "<br/>");
            builder.append(printCoverage((Coverage) c.format("coverage")) + "\n");

            //打印该产品的保险利益
            System.out.println("--- " + c.getProduct().getName() + "的保险利益 ---" + "\n");
            builder.append("--- " + c.getProduct().getName() + "的保险利益 ---" + "<br/>");
            builder.append(printLiability((Liability) c.format("liability")) + "\n");
        }

        outHtmlFile(builder, "D:/test.html");
    }

    static void outHtmlFile(StringBuilder builder, String path) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            outputStream.write(builder.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
