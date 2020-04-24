package com.xuzp.insuredxmltool;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 2019/11/25 0025 20:16
 * @auther YangShengFu
 */
public class demo {

    public static void main(String[] arg) throws Exception {
        String ID6261Prem=null;

        List<String> list=new ArrayList<>();
        list.add("123");
        list.add("abc");
        for(int i=0;i<list.size();i++){
            ID6261Prem=list.get(i);
        }
        System.out.println(ID6261Prem);

//        for(ApplyDutyDTO duty2: product.getDutyList()){
//            if(StringUtils.isNotEmpty(duty.getAmnt()) && Double.parseDouble(duty.getAmnt()) != 0){
//                if("ID6261".equals(duty.getDutyCode())){
//                    ID6261Prem=duty2.getPrem();
//                }
//            }
//        }
    }
}
