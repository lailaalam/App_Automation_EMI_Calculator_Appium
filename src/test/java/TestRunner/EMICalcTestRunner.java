package TestRunner;

import base.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.EMICalculatorScreen;
import utilities.DataSet;

import static java.lang.Thread.sleep;


public class EMICalcTestRunner extends Setup {
    @BeforeTest
    public void startEMICalculator()
    {
        EMICalculatorScreen emiCalculatorScreen = new EMICalculatorScreen(driver);
        emiCalculatorScreen.btnEMICalc.click();
    }
    @Test(dataProvider = "data-provider", dataProviderClass = DataSet.class,priority = 2)
    public void doCalculation(double amount, double interest, int year, double processingFee, double mEMI, double tInterest, int tFee, double pAmount) throws InterruptedException {
        EMICalculatorScreen emiCalculatorScreen = new EMICalculatorScreen(driver);
        emiCalculatorScreen.doCalculation(amount, interest, year, processingFee);
        String monthlyEMI=emiCalculatorScreen.getmEMI();
        String totalInterest=emiCalculatorScreen.gettInterest();
        String totalFee=emiCalculatorScreen.gettFee();
        String totalAmount=emiCalculatorScreen.getpAmount();
        System.out.println(monthlyEMI);
        System.out.println(totalInterest);
        System.out.println(totalFee);
        System.out.println(totalAmount);

        Assert.assertEquals(monthlyEMI,String.valueOf(mEMI));
        Assert.assertEquals(totalInterest,String.valueOf(tInterest));
        Assert.assertEquals(totalFee,String.valueOf(tFee));
        Assert.assertEquals(totalAmount,String.valueOf(pAmount));

        emiCalculatorScreen.btnReset.click();
    }
}
