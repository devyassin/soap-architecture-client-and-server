
package org.yassine.soapclient.proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "ProductWS", targetNamespace = "http://impl.services.webservice.yassine.org/", wsdlLocation = "http://localhost:8080/webservice?wsdl")
public class ProductWS
    extends Service
{

    private static final URL PRODUCTWS_WSDL_LOCATION;
    private static final WebServiceException PRODUCTWS_EXCEPTION;
    private static final QName PRODUCTWS_QNAME = new QName("http://impl.services.webservice.yassine.org/", "ProductWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/webservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRODUCTWS_WSDL_LOCATION = url;
        PRODUCTWS_EXCEPTION = e;
    }

    public ProductWS() {
        super(__getWsdlLocation(), PRODUCTWS_QNAME);
    }

    public ProductWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCTWS_QNAME, features);
    }

    public ProductWS(URL wsdlLocation) {
        super(wsdlLocation, PRODUCTWS_QNAME);
    }

    public ProductWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCTWS_QNAME, features);
    }

    public ProductWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProductServiceImpl
     */
    @WebEndpoint(name = "ProductServiceImplPort")
    public ProductServiceImpl getProductServiceImplPort() {
        return super.getPort(new QName("http://impl.services.webservice.yassine.org/", "ProductServiceImplPort"), ProductServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductServiceImpl
     */
    @WebEndpoint(name = "ProductServiceImplPort")
    public ProductServiceImpl getProductServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.services.webservice.yassine.org/", "ProductServiceImplPort"), ProductServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCTWS_EXCEPTION!= null) {
            throw PRODUCTWS_EXCEPTION;
        }
        return PRODUCTWS_WSDL_LOCATION;
    }

}
