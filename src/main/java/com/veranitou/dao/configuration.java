package com.veranitou.dao;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/* Funcion: Carga la configuración de la aplicación desde un archivo XML
 *  */
public class configuration {
    public void configuration(){
	try{
	File fXmlFile = new File("/gitrepos/veranitouBackend/config.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	doc.getDocumentElement().normalize();
	String srvr =  doc.getElementsByTagName("SQLServer").item(0).getTextContent();
	    
	}
	catch (Exception ex){
	    
	}
    }
}
