package com.sunjian.services;

public interface Hmsb {

    /**
     * 证件核验
     * @return 核验结果
     * @throws Exception
     */
    String zjhy()throws Exception;

    /**
     * 虹膜核验
     * @return 核验结果、核验时间
     * @throws Exception
     */
    String onlyHmsb()throws Exception;
}
