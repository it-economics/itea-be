//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v3.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.10.17 um 01:49:35 PM CEST 
//


package com.ite.itea.ecommerce.usecase.soapmodel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;


/**
 * <p>Java-Klasse für chair complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="chair"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://soprasteria.com/css/itea-soap-service}product"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="legPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="seatPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="RestPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chair", propOrder = {
    "legPrice",
    "seatPrice",
    "restPrice"
})
public class Chair
    extends Product
{

    @XmlElement(required = true)
    protected BigDecimal legPrice;
    @XmlElement(required = true)
    protected BigDecimal seatPrice;
    @XmlElement(name = "RestPrice", required = true)
    protected BigDecimal restPrice;

    /**
     * Ruft den Wert der legPrice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLegPrice() {
        return legPrice;
    }

    /**
     * Legt den Wert der legPrice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLegPrice(BigDecimal value) {
        this.legPrice = value;
    }

    /**
     * Ruft den Wert der seatPrice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSeatPrice() {
        return seatPrice;
    }

    /**
     * Legt den Wert der seatPrice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSeatPrice(BigDecimal value) {
        this.seatPrice = value;
    }

    /**
     * Ruft den Wert der restPrice-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRestPrice() {
        return restPrice;
    }

    /**
     * Legt den Wert der restPrice-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRestPrice(BigDecimal value) {
        this.restPrice = value;
    }

}
