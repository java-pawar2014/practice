package org.springboot.webapp.web.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@XmlType
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 2702748902445479896L;

	@ApiModelProperty(notes = "The database generated product ID")
	@XmlElement(name = "id", required = false)
	// @JsonIgnore(value = true)
	private Integer id;

	@XmlElement(name = "version")
	@ApiModelProperty(notes = "The auto-generated version of the product")
	private Integer version;

	@XmlElement(name = "product-id")
	@ApiModelProperty(notes = "The application-specific product ID")
	// @JsonIgnore(value = true)
	private String productId;

	@XmlElement(name = "description")
	@ApiModelProperty(notes = "The product description")
	private String description;

	@XmlElement(name = "image-url")
	@ApiModelProperty(notes = "The image URL of the product")
	private String imageUrl;

	@XmlElement(name = "price")
	@ApiModelProperty(notes = "The price of the product", required = true)
	private BigDecimal price;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", version=" + version + ", productId=" + productId + ", description="
				+ description + ", imageUrl=" + imageUrl + ", price=" + price + "]";
	}
}