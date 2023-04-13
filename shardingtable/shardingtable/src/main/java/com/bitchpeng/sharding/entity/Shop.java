package com.bitchpeng.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;


@Data
@TableName("bit_shop")
@Accessors(chain = true)
public class Shop {

    @TableId(type = IdType.AUTO)
    private Long sid;
    private String shopName;
    private String userId;
    private Integer status;


//    public static void main(String[] args) {
//        int a = 1001;
//        String s = "";
//        for (int i = 2; i < a; i++) {
//            if (fun(a, i)) {
//                s = a + "是合数";
//                break;
//            }
//        }
//        if(StringUtils.isEmpty(s)){
//            s=a+"是质数";
//        }
//        log.info(s);
//
//    }
//
//
//    public static boolean fun(int a, int i) {
//        return a % i == 0;
//    }


}
