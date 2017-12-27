package dao;

import entity.Deposit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгений on 27.12.2017.
 */
public class DepositDaoMockTest {
    DepositDao depositDao=new DepositDaoMock();

    //parameters
    public List<Deposit> list=new ArrayList<Deposit>();
    public String paramPay1="Ежемесячно";
    public String paramPay2="В конце срока";
    public String paramPay3="Ежемесячно";
    public String paramCurr1="hryvna";
    public String paramCurr2="dollar";
    public String paramCurr3="euro";

    public int paramTerm1=3;
    public int paramTerm2=6;
    public int paramTerm3=9;
    public int paramTerm4=12;
    public int paramTerm5=24;

public DepositDaoMockTest(){
}

    @Test
    public void selectByParams1() throws Exception {
        List<Deposit> result=depositDao.selectByParams(paramCurr1,paramTerm1,null,null,null,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr1);
            Assert.assertEquals(d.getTerm(),paramTerm1);
        }
    }

    @Test
    public void selectByParams2() throws Exception {
        DepositDao depositDao=new DepositDaoMock();
        List<Deposit> result=depositDao.selectByParams(paramCurr2,paramTerm3,paramPay1,null,null,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr2);
            Assert.assertEquals(d.getTerm(),paramTerm3);
            Assert.assertEquals(d.getPayment(),paramPay1);
        }
    }

    @Test
    public void selectByParams3() throws Exception {
        DepositDao depositDao=new DepositDaoMock();
        List<Deposit> result=depositDao.selectByParams(paramCurr2,paramTerm2,null,null,null,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr2);
            Assert.assertEquals(d.getTerm(),paramTerm2);
        }
    }

    @Test
    public void selectByParams4() throws Exception {
        DepositDao depositDao=new DepositDaoMock();
        List<Deposit> result=depositDao.selectByParams(paramCurr2,paramTerm4,paramPay2,null,null,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr2);
            Assert.assertEquals(d.getTerm(),paramTerm4);
            Assert.assertEquals(d.getPayment(),paramPay2);
        }
    }

    @Test
    public void selectByParams5() throws Exception {
        DepositDao depositDao=new DepositDaoMock();
        List<Deposit> result=depositDao.selectByParams(paramCurr3,paramTerm4,null,null,null,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr3);
            Assert.assertEquals(d.getTerm(),paramTerm4);
        }
    }

    @Test
    public void selectByParams6() throws Exception {
        DepositDao depositDao=new DepositDaoMock();
        List<Deposit> result=depositDao.selectByParams(paramCurr1,paramTerm1,paramPay3,null,null,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr1);
            Assert.assertEquals(d.getTerm(),paramTerm1);
            Assert.assertEquals(d.getPayment(),paramPay3);
        }
    }

    @Test
    public void selectByParams7() throws Exception {
        DepositDao depositDao=new DepositDaoMock();
        List<Deposit> result=depositDao.selectByParams(paramCurr3,paramTerm5,null,null,null,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr3);
            Assert.assertEquals(d.getTerm(),paramTerm5);
        }
    }

    @Test
    public void selectByParams8() throws Exception {
        DepositDao depositDao=new DepositDaoMock();
        List<Deposit> result=depositDao.selectByParams(paramCurr3,paramTerm4,paramPay2,false,true,null);
        for (Deposit d:result) {
            Assert.assertEquals(d.getCurrency(),paramCurr3);
            Assert.assertEquals(d.getTerm(),paramTerm4);
            Assert.assertEquals(d.getPayment(),paramPay2);
            Assert.assertEquals(d.getEarlyClose(),true);
            Assert.assertEquals(d.getRefill(),false);
        }
    }


}