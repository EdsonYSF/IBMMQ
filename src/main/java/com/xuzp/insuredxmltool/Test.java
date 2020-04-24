package com.xuzp.insuredxmltool;

public class Test {
//    保单帐户价值：
//    ('Month_P_6%' ! $G$12 : $G$1343 = $B6 ) * ( 'Month_P_6%' ! $H$12 : $H$1343 = 12 ) * ( 'Month_P_6%' ! $AZ$12 : $AZ$1343 )

//    AZ12(月底AV（部分解约后）)=IF(Product <> "超級達人",MAX( 0, AU12 - AW12 ),IF( AND ( G12 = 1, AU12 >= $N$12 * 40 %, AU12 - AW12 < $N$12 * 40 % ),
//                                            MAX(0,AU12 - AW12 -IF(
//                                                    IF(F12 >= 12,0,SUM( INDEX ( $Q$13 : $Q$23, F12 ) : $Q$23 )) - AW12 < 0, 0,
//                                                                (
//                                                                IF ( F12 >= 12,0,SUM( INDEX ( $Q$13 : $Q$23, F12 ) : $Q$23 )) - AW12
//                                                                 ) * BW12
//                                                                )
//                                                 ),MAX( 0, AU12 - AW12 )
//                                                   )
//                                   )

}
