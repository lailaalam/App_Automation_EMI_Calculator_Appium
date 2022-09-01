package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMICalculatorScreen {
    @FindBy(id="com.continuum.emi.calculator:id/btnStart")
    public AndroidElement btnEMICalc;
    @FindBy(id= "com.continuum.emi.calculator:id/etLoanAmount")
    AndroidElement txtAmount;
    @FindBy(id="com.continuum.emi.calculator:id/etInterest")
    AndroidElement txtInterest;
    @FindBy(id="com.continuum.emi.calculator:id/etYears")
    AndroidElement txtYear ;
    @FindBy(id="com.continuum.emi.calculator:id/etMonths")
    AndroidElement txtMonth ;
    @FindBy(id="com.continuum.emi.calculator:id/etEMI")
    AndroidElement txtEMI;
    @FindBy(id="com.continuum.emi.calculator:id/etFee")
    AndroidElement txtProcessingFee;
    @FindBy(id="com.continuum.emi.calculator:id/btnCalculate")
    AndroidElement btnCalculation;
    @FindBy(id="com.continuum.emi.calculator:id/btnReset")
    public AndroidElement btnReset;

    @FindBy(id="com.continuum.emi.calculator:id/monthly_emi_result")
    AndroidElement lblMonthlyEMI;
    @FindBy(id="com.continuum.emi.calculator:id/total_interest_result")
    AndroidElement lblTotalInterest;
    @FindBy(id="com.continuum.emi.calculator:id/processing_fee_result")
    AndroidElement lblProcessingFee;
    @FindBy(id="com.continuum.emi.calculator:id/total_payment_result")
    AndroidElement lblTotalPayment;

    public String mEMI;
    public String tInterest;
    public String tFee;
    public String pAmount;

    public String getmEMI() {
        return mEMI;
    }

    public void setmEMI(String mEMI) {
        this.mEMI = mEMI;
    }

    public String gettInterest() {
        return tInterest;
    }

    public void settInterest(String tInterest) {
        this.tInterest = tInterest;
    }

    public String gettFee() {
        return tFee;
    }

    public void settFee(String tFee) {
        this.tFee = tFee;
    }

    public String getpAmount() {
        return pAmount;
    }

    public void setpAmount(String pAmount) {
        this.pAmount = pAmount;
    }



    public EMICalculatorScreen(AndroidDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }



    public void doCalculation(double amount,double interest,int year,double processingFee)
    {

       txtAmount.sendKeys(""+amount+"");
       txtInterest.sendKeys(""+interest+"");
       txtYear.sendKeys(""+year+"");
       txtProcessingFee.sendKeys(""+processingFee+"");
       btnCalculation.click();
       setmEMI(lblMonthlyEMI.getText().replace(",",""));
       settInterest(lblTotalInterest.getText().replace(",",""));
       settFee(lblProcessingFee.getText().replace(",",""));
       setpAmount(lblTotalPayment.getText().replace(",",""));

    }

}
