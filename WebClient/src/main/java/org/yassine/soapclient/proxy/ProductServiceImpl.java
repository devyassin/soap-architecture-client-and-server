
package org.yassine.soapclient.proxy;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ProductServiceImpl", targetNamespace = "http://impl.services.webservice.yassine.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProductServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns org.yassine.soapclient.proxy.Product
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateProduct", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.UpdateProduct")
    @ResponseWrapper(localName = "updateProductResponse", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.UpdateProductResponse")
    @Action(input = "http://impl.services.webservice.yassine.org/ProductServiceImpl/updateProductRequest", output = "http://impl.services.webservice.yassine.org/ProductServiceImpl/updateProductResponse")
    public Product updateProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Product arg0);

    /**
     * 
     * @return
     *     returns java.util.List<org.yassine.soapclient.proxy.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllProducts", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.GetAllProducts")
    @ResponseWrapper(localName = "getAllProductsResponse", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.GetAllProductsResponse")
    @Action(input = "http://impl.services.webservice.yassine.org/ProductServiceImpl/getAllProductsRequest", output = "http://impl.services.webservice.yassine.org/ProductServiceImpl/getAllProductsResponse")
    public List<Product> getAllProducts();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteProduct", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.DeleteProduct")
    @ResponseWrapper(localName = "deleteProductResponse", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.DeleteProductResponse")
    @Action(input = "http://impl.services.webservice.yassine.org/ProductServiceImpl/deleteProductRequest", output = "http://impl.services.webservice.yassine.org/ProductServiceImpl/deleteProductResponse")
    public boolean deleteProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param price
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sellingPrice", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.SellingPrice")
    @ResponseWrapper(localName = "sellingPriceResponse", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.SellingPriceResponse")
    @Action(input = "http://impl.services.webservice.yassine.org/ProductServiceImpl/sellingPriceRequest", output = "http://impl.services.webservice.yassine.org/ProductServiceImpl/sellingPriceResponse")
    public Double sellingPrice(
        @WebParam(name = "Price", targetNamespace = "")
        Double price);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.yassine.soapclient.proxy.Product
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProduct", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.GetProduct")
    @ResponseWrapper(localName = "getProductResponse", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.GetProductResponse")
    @Action(input = "http://impl.services.webservice.yassine.org/ProductServiceImpl/getProductRequest", output = "http://impl.services.webservice.yassine.org/ProductServiceImpl/getProductResponse")
    public Product getProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addProduct", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.AddProduct")
    @ResponseWrapper(localName = "addProductResponse", targetNamespace = "http://impl.services.webservice.yassine.org/", className = "org.yassine.soapclient.proxy.AddProductResponse")
    @Action(input = "http://impl.services.webservice.yassine.org/ProductServiceImpl/addProductRequest", output = "http://impl.services.webservice.yassine.org/ProductServiceImpl/addProductResponse")
    public boolean addProduct(
        @WebParam(name = "arg0", targetNamespace = "")
        Product arg0);

}