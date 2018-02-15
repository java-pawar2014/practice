package org.restful.jsonbinder.test;

import org.restful.jsonbinder.bean.ProductBean;
import org.restful.jsonbinder.bind.JsonDataMarshaller;

/**
 * @author bpawar
 *
 */
public class JsonBinderTest {

	public static void main(String[] args) {
		JsonDataMarshaller dataMarshaller = null;
		ProductBean product = null;

		dataMarshaller = new JsonDataMarshaller();
		String jsonData = "{\"productName\":\"Mobile\", \"description\":\"Simple mobile handset\", \"weight\":\"125.5\", \"price\":{\"minPrice\":\"562.5\", \"maxPrice\":\"658.5\"}}";
		try {
			product = (ProductBean) dataMarshaller.marshalData(jsonData, ProductBean.class);

			System.out.println(product);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
