//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v3.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.10.18 um 08:21:40 AM CEST 
//


package com.ite.itea.ecommerce.usecase.soapmodel;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für products complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="products"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element name="product" type="{http://soprasteria.com/css/itea-soap-service}product"/&gt;
 *           &lt;element name="chair" type="{http://soprasteria.com/css/itea-soap-service}chair"/&gt;
 *           &lt;element name="table" type="{http://soprasteria.com/css/itea-soap-service}table"/&gt;
 *           &lt;element name="closet" type="{http://soprasteria.com/css/itea-soap-service}closet"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "products", propOrder = {
    "productOrChairOrTable"
})
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-10-18T08:21:39+02:00")
public class Products {

    @XmlElements({
        @XmlElement(name = "product"),
        @XmlElement(name = "chair", type = Chair.class),
        @XmlElement(name = "table", type = Table.class),
        @XmlElement(name = "closet", type = Closet.class)
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-10-18T08:21:39+02:00")
    protected List<Product> productOrChairOrTable;

    /**
     * Gets the value of the productOrChairOrTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the productOrChairOrTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductOrChairOrTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Product }
     * {@link Chair }
     * {@link Table }
     * {@link Closet }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-10-18T08:21:39+02:00")
    public List<Product> getProductOrChairOrTable() {
        if (productOrChairOrTable == null) {
            productOrChairOrTable = new ArrayList<Product>();
        }
        return this.productOrChairOrTable;
    }

}
