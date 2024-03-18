package com.MyStore.Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass extends ExtentManager implements ITestListener{

	Action action = new Action();
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest=extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS, "Pass Testcase is : "+result.getName());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - Test Case Failed", ExtentColor.RED));
			String imgPath=action.screenshot(BaseClass.getDriver(), result.getName());
			extentTest.fail("Screenshot is attached",MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, "Skipped Testcase is : "+result.getName());
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	

}
