package com.sunjian.services;

import java.rmi.server.ExportException;

public interface Hmcj {

    /**
     * 无法采集方式
     * @throws Exception
     */
    void doWfcjWayGatherPerson() throws Exception;

    /**
     * 虹膜采集方式
     * @param schema 2 双眼 1 右眼 0 左眼
     * @throws Exception
     */
    void doHmcjWayGatherPerson(int schema) throws Exception;
}
