package com.lw.rbac.test;

import com.lw.rbac.util.StringUtil;

/**
 * @ClassName StringTest
 * @Description: TODO
 * @Author liwei
 * @Date 2019/5/25 9:07
 * @Version 1.0
 */
public class StringTest {

    public static void main(String[] args) {
        //
        System.out.println(StringUtil.getSalt());
        System.out.println(StringUtil.sha256Digest("1759840027",StringUtil.getSalt()));
    }
}
