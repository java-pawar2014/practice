package com.springcore.strategy;

import com.springcore.strategy.bean.SuperInterface;
import com.springcore.strategy.beanimpl.SuperInterfaceConcreteImpl;
import com.springcore.strategy.service.provider.SuperServiceInterfaceImpl;

/**
 * Strategy design pattern:
 * 
 * <pre>
 * 1) Favor composition over inheritance <br/>
 * 	  i)  Do not inherit until and unless required all functionality of the target class.
 * 	  ii) Use composition if less code of the target class has to be reused.
 * 
 * 2) Design to interfaces, never design to concrete classes <br/>
 *    i)  To resolve the tightly coupling of concrete classes, design to interfaces.
 *    ii) Interfaces will give ability to have the flexibility in having multiple implementations.
 * 3) Code Should be open for extension, closed for modification <br/>
 *    i)  Do not allow to modify existing code, force to have new implementation.
 * </pre>
 * 
 * @author bpawar
 *
 */
public class App {
	public static void main(String[] args) {
		SuperInterface superInterface = null;
		SuperServiceInterfaceImpl serviceInterface = null;

		superInterface = new SuperInterfaceConcreteImpl();
		serviceInterface = new SuperServiceInterfaceImpl();
		serviceInterface.setSuperInterface(superInterface);
		serviceInterface.serviceMethod1();

	}
}
