/**
 * 
 */
package com.drooldemo;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author bpawar
 *
 */
public class DroolsTest {

	public static void main(String[] args) {

		KieServices services = KieServices.Factory.get();
		KieContainer container = services.getKieClasspathContainer();
		KieSession session = container.newKieSession("ksession-rules");
		Message message = new Message();
		message.setMessage("Good Bye");
		message.setStatus(Message.GOODBYE);
		session.insert(message);
		session.fireAllRules();
	}

	public static class Message {

		public static final int HELLO = 0;
		public static final int GOODBYE = 1;

		private String message;

		private int status;

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public int getStatus() {
			return this.status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}

}
