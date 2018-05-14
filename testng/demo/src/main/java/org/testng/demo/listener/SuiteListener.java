
package org.testng.demo.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

	public void onStart(ISuite suite) {

		System.out.println("Invoked onStart(ISuite) for suite " + suite.getName());
	}

	public void onFinish(ISuite suite) {

		System.out.println("Invoked onFinish(ISuite) for suite " + suite.getName());

	}

}
