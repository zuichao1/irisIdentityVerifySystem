package com.sunjian.services.impl;

import com.sunjian.datas.Datas2;
import com.sunjian.pages.FirstPage;
import com.sunjian.pages.HmcjPage;
import com.sunjian.pages.IframePage;
import com.sunjian.services.Hmcj;
import com.sunjian.utils.MyLog;
import com.sunjian.utils.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;
import java.util.logging.Logger;

public class HmcjImpl extends HmcjPage implements Hmcj {

    private WebDriver driver;

    public HmcjImpl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    Datas2 data = new Datas2(System.getProperty("user.dir") + "/src/test/tools/xxx.csv");
    IframePage iframe = new IframePage(driver);

    public void intoHmcjIframe() throws Exception {//进入虹膜采集界面的iframe
        driver.switchTo().frame(driver.findElement(By.xpath(iframe.getHmcjIframe())));
        MyLog.log("进入虹膜采集界面");
        MyWait.threadWait(1);
    }

    public void intoKscjIframe() throws Exception {//进入开始采集界面的iframe
        driver.switchTo().frame(driver.findElement(By.xpath(iframe.getKscjIframe())));
        MyLog.log("进入开始采集界面");
        MyWait.threadWait(1);
    }

    public void backHomeIframe() {//返回主iframe
        driver.switchTo().defaultContent();
        MyLog.log("返回到主界面");
    }

    public void backParentIframe() {
        driver.switchTo().parentFrame();
        MyLog.log("返回到上一级界面");
    }

    public boolean kscjIsDisplay() {//判斷开始采集是否顯示
        if (kscj().isDisplayed() || kscj().isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    private void doSelectOneRyfl() throws Exception {//选择一个人员分类
//        MyWait.showTypeWait2(driver, 5, ryfl_button_str());
        MyWait.threadWait(2);
        ryfl_button().click();//点击人员分类的下拉按钮
        MyWait.threadWait(1);
        MyLog.log("选择一个人员分类");
        ryfl().click();
        MyLog.log("人员分类选择成功");
    }

    private void doSelectOneZjlx() throws Exception {//选择一个证件类型
//        MyWait.showTypeWait2(driver, 3, zjlx_button_str());
        MyWait.threadWait(1);
        zjlx_button().click();
        zjlx().click();
        MyLog.log("选择一个证件类型");
    }

    private void doInputZjh() {//输入证件号
        //zjh().sendKeys(data.getTestData("zjh", "v1"));
        zjh().clear();
        zjh().sendKeys(UUID.randomUUID().toString());
        MyLog.log("输入证件号");
    }

    private void doInputXm() {//输入姓名
        xm().sendKeys(data.getTestData("xm", "v1"));
        MyLog.log("输入姓名");
    }

    private void doSelectOneXb() throws Exception {//选择一个性别
        //MyWait.showTypeWait2(driver, 3, xb_button_str());
        MyWait.millisWait(100);
        xb_button().click();
        xb().click();
        MyLog.log("选择一个性别");
    }

    private void doSelectCsrq() {//选择一个出生日期
        csrq().click();
        csrq().sendKeys(data.getTestData("csrq", "v1"));
        MyLog.log("选择一个出生日期");
    }

    private void doSelectOneGj() throws Exception {//选择一个国籍
        MyWait.millisWait(100);
        gj_button().click();
        gj().click();
        MyLog.log("选择一个国籍");
    }

    private void doSelectOneMz() throws Exception {//选择一个民族
        MyWait.millisWait(100);
        mz_button().click();
        mz().click();
        MyLog.log("选择一个民族");
    }

    private void doInputHjdz() {//输入户籍地址
        hjdz().sendKeys(data.getTestData("hjdz", "v1"));
        MyLog.log("输入户籍地址");
    }

    private void doInputZjqfjg() {//输入证件签发机关
        zjqfjg().sendKeys(data.getTestData("zjqfjg", "v1"));
        MyLog.log("输入证件签发机关");
    }

    private void doInputYxqx() {//输入证件有效期
        yxqx().sendKeys(data.getTestData("zjyxq", "v1"));
        MyLog.log("输入证件有效期");
    }

    private void doInputXjzdz() {//输入现居住地址
        xjzdz().sendKeys(data.getTestData("xjzdz", "v1"));
        MyLog.log("输入现居住地址");
    }

    private void doInputSjhm() {//输入手机号码
        sjhm().sendKeys(data.getTestData("sjhm", "v1"));
        MyLog.log("输入手机号码");
    }

    private void doInputQtlxdh() {//输入其他联系电话
        qtlxdh().sendKeys(data.getTestData("qtlxdh", "v1"));
        MyLog.log("输入其他联系电话");
    }

    private void doInputBz() {//输入备注
        bz().sendKeys(data.getTestData("bz", "v1"));
        MyLog.log("输入备注信息");
    }

    private void doReadIdcard() {//读取身份证
        if (dedz().isDisplayed() || dedz().isEnabled())
            doUseJsClickEelment(dedz());
        else
            MyLog.log("读二代证按钮没有找到");
    }

    public boolean whetherOrNotReadIdcard() throws Exception {//判断是否读取身份证成功
        boolean flag = false;
        MyWait.threadWait(3);
        try {
            if (qd() != null && qd().isDisplayed()) {
                doClickQd();
                flag = false;
                MyLog.log("读取身份证信息失败了");
            } else {     //如果确定按钮元素没有出现
                flag = true;
                MyLog.log("读取身份证信息成功了");
            }
        } catch (NullPointerException e) {
            flag = true;
            MyLog.log("读取身份证信息成功了");
        }
        return flag;
    }

    private void doWfcjWay() throws Exception {//选择无法采集
        wfcj().click();
        MyWait.millisWait(100);
        wfcj_button().click();
        MyWait.millisWait(100);
        wfcj_select().click();
        MyLog.log("选择一个无法采集");
    }

    private void doSubmit() throws Exception {//提交
        MyWait.threadWait(3);
        if (tj().isDisplayed()) {
            doUseJsClickEelment(tj());
            MyLog.log("点击提交按钮");
        } else {
            MyLog.log("提交按钮没有发现");
        }

    }

    public void doClickQd() throws Exception {//采集成功后，点击确定
        MyWait.threadWait(5);
        //MyWait.showTypeWait2(driver, 5, qd_str());
        if (qd().isDisplayed() && qd().isEnabled()) {
            doUseJsClickEelment(qd());
            MyLog.log("点击确定按钮");
        } else {
            MyLog.log("提交后没有返回结果，找不到确定按钮");
        }
    }

    private void doInputRyxx() throws Exception {//输入人员信息
        doSelectOneRyfl();
        doInputXm();
        doSelectOneZjlx();
        doInputZjh();
        doSelectOneXb();
        doSelectCsrq();
        doSelectOneGj();
        doSelectOneMz();
        doInputHjdz();
        doInputZjqfjg();
        doInputYxqx();
        doInputXjzdz();
        doInputSjhm();
        doInputQtlxdh();
        doInputBz();
    }

    private void doDedzAfterUpdateRyxx() throws Exception {//读取身份证后，修改身份信息
        doReadIdcard();
        if (whetherOrNotReadIdcard() == true) {
            doSelectOneRyfl();
            doInputXm();
            doSelectOneZjlx();
            doInputZjh();
            doInputHjdz();
            doInputZjqfjg();
            doInputXjzdz();
            doInputSjhm();
            doInputQtlxdh();
            doInputBz();
        } else {//没有读取成功
            doSelectOneRyfl();
            doInputXm();
            doSelectOneZjlx();
            doInputZjh();
            doSelectOneXb();
            doSelectCsrq();
            doSelectOneGj();
            doSelectOneMz();
            doInputHjdz();
            doInputZjqfjg();
            doInputYxqx();
            doInputXjzdz();
            doInputSjhm();
            doInputQtlxdh();
            doInputBz();
        }
    }

    private void doClickDialogBoxKscjButton() {//点击对话框中的开始采集
        String js = "arguments[0].click();";
        ((JavascriptExecutor) driver).executeScript(js, kscj2());
    }

    private void doStartGather() throws Exception {//开始采集虹膜
        //点击开始采集
        kscj().click();
        MyWait.threadWait(2);
        intoKscjIframe();
        doClickDialogBoxKscjButton();
    }

    private void doStartGatherForZuoYan() throws Exception {//开始采集虹膜zuoyan
        //点击开始采集zuoyan
        kscj().click();
        MyWait.threadWait(2);
        intoKscjIframe();
        MyWait.threadWait(1);
        doUseJsClickEelment(yy());
        doClickDialogBoxKscjButton();
    }

    private void doStartGatherForYouYan() throws Exception {//开始采集虹膜右眼
        //点击开始采集右眼
        kscj().click();
        MyWait.threadWait(2);
        intoKscjIframe();
        MyWait.threadWait(1);
        doUseJsClickEelment(zy());
        doClickDialogBoxKscjButton();
    }

    @SuppressWarnings("unused")
    private String getTsyText() throws Exception {//获取提示语文本
        if (tsy().isDisplayed()) {
            return tsy().getText();
        } else {
            MyWait.threadWait(3);
            return tsy().getText();
        }
    }

    /**
     * 使用JS click
     *
     * @param element
     */
    public void doUseJsClickEelment(WebElement element) {
        String js = "arguments[0].click();";
        ((JavascriptExecutor) driver).executeScript(js, element);
    }

    /**
     * 进入虹膜采集界面中
     *
     * @param first
     * @throws Exception
     */
    public void doIntoHmcjPage2(FirstPage first) throws Exception {
        //点击 采集识别
        first.hmcj().click();
        MyWait.threadWait(1);
        intoHmcjIframe();
    }

    public void doIntoHmcjPage(FirstPage first) throws Exception {
        if (first.hmcj().isDisplayed() && first.hmcj().isEnabled()) {
            //点击 采集识别
            first.hmcj().click();
            MyWait.threadWait(1);
            intoHmcjIframe();
        } else {
            //点击 采集识别
            first.cjsb().click();
            first.hmcj().click();
            MyWait.threadWait(1);
            intoHmcjIframe();
        }
    }

    /**
     * 无法采集方式
     *
     * @throws Exception
     */
    @Override
    public void doWfcjWayGatherPerson() throws Exception {
        //输入人员信息
        doInputRyxx();
        //选择无法采集方式
        doWfcjWay();
        //点击提交按钮
        doSubmit();
        //点击确定
        doClickQd();
    }

    /**
     * 虹膜采集方式
     *
     * @throws Exception
     */
    @Override
    public void doHmcjWayGatherPerson(int schema) throws Exception {
        //输入人员信息
        doDedzAfterUpdateRyxx();
        //点击开始采集虹膜
        if (schema == 2) {
            doStartGather();//双眼
        } else if (schema == 1) {
            doStartGatherForZuoYan();//左眼
        } else {
            doStartGatherForYouYan();//右眼
        }
        //判断是否正确打开设备，进入采集状态
        MyWait.threadWait(10);
        //虹膜采集成功后，点击提交
        backHomeIframe();
        intoHmcjIframe();
        doSubmit();
        //点击确定
        doClickQd();
    }

}