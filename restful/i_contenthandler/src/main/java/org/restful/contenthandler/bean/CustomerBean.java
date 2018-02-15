package org.restful.contenthandler.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author bpawar
 *
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 515465352216728160L;

	@XmlAttribute(name = "customer-id", required = false)
	// @XmlElement(name = "customer-id", required = false)
	private int id;

	@XmlElement(name = "full-name", required = false)
	private String fullName;

	//@XmlElement(name = "goods", required = false)
	private List<String> goods;

	@XmlElement(name = "address", required = false)
	private CustomerAddressBean address;

	public CustomerBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public CustomerAddressBean getAddress() {
		return address;
	}

	public void setAddress(CustomerAddressBean address) {
		this.address = address;
	}

	public List<String> getGoods() {
		return goods;
	}

	public void setGoods(List<String> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "CustomerBean [id=" + id + ", fullName=" + fullName + ", goods=" + goods + ", address=" + address + "]";
	}
	
	
}