package com.sunjian.services;

public interface Login {

    /**
     * 登录成功
     * @param url
     * @param username
     * @param password
     * @return 成功：true  失败：false
     * @throws Exception
     */
    boolean doLogin(String url,String username,String password) throws Exception;

    /**
     * 登录失败--输入用户名或密码为空时的判断
     * @param url
     * @param username
     * @param password
     * @return 返回提示语
     * @throws Exception
     */
    String doLoginFailedForEmpty(String url, String username, String password) throws Exception ;

    /**
     * 登录失败--输入错误的用户名或密码时的判断
     * @param url
     * @param username
     * @param password
     * @return 返回提示语
     * @throws Exception
     */
    String doLoginFailed(String url, String username, String password) throws Exception ;
}
