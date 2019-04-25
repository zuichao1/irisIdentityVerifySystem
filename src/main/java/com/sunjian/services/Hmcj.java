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
     * @throws Exception
     */
    void doHmcjWayGatherPerson() throws Exception;
}
