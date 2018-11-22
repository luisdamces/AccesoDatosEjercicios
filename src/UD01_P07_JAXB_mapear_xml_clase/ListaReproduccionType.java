//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.11.22 a las 10:08:44 PM CET 
//


package UD01_P07_JAXB_mapear_xml_clase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ListaReproduccionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ListaReproduccionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cancion" type="{}Cancion"/&gt;
 *         &lt;element name="listaReproduccion" type="{}ListaReproduccion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaReproduccionType", propOrder = {
    "cancion",
    "listaReproduccion"
})
public class ListaReproduccionType {

    @XmlElement(required = true)
    protected Cancion cancion;
    @XmlElement(required = true)
    protected ListaReproduccion listaReproduccion;

    /**
     * Obtiene el valor de la propiedad cancion.
     * 
     * @return
     *     possible object is
     *     {@link Cancion }
     *     
     */
    public Cancion getCancion() {
        return cancion;
    }

    /**
     * Define el valor de la propiedad cancion.
     * 
     * @param value
     *     allowed object is
     *     {@link Cancion }
     *     
     */
    public void setCancion(Cancion value) {
        this.cancion = value;
    }

    /**
     * Obtiene el valor de la propiedad listaReproduccion.
     * 
     * @return
     *     possible object is
     *     {@link ListaReproduccion }
     *     
     */
    public ListaReproduccion getListaReproduccion() {
        return listaReproduccion;
    }

    /**
     * Define el valor de la propiedad listaReproduccion.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaReproduccion }
     *     
     */
    public void setListaReproduccion(ListaReproduccion value) {
        this.listaReproduccion = value;
    }

}
