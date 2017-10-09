package com.veranitou.dao;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.apache.log4j.Logger;

/* Funcion: Carga la configuración de la aplicación desde un archivo XML
 *  */
public class configuration {

    final static Logger logger = Logger.getLogger(configuration.class);

    public static String SQLServer;
    public static String SQLDB;
    public static String SQLUser;
    public static String SQLPassword;
    
    public configuration(){

    	/*
    	if(SQLServer){
			logger.info("configuration was already loaded!");
			return;
    	}*/

		logger.info("Loading configuration...");

		try{
		File fXmlFile = new File("./config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();
		String srvr =  doc.getElementsByTagName("SQLServer").item(0).getTextContent();
		String db =  doc.getElementsByTagName("SQLDB").item(0).getTextContent();
		String user =  doc.getElementsByTagName("SQLUser").item(0).getTextContent();
		String psw =  doc.getElementsByTagName("SQLPassword").item(0).getTextContent();

		logger.info("SQLServer: "+srvr);
		logger.info("SQLDB: "+db);
		logger.info("SQLUser: "+user);

		}
		catch (Exception ex){
		    logger.error("Excepcion loading configuration",ex);
		}

    }
}
