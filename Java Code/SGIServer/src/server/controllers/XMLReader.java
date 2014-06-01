package server.controllers;

import java.io.File;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLReader {

	private Document _document;
	
	public XMLReader(String filename) {
		try {
			File file = new File(filename);
			if (file.exists()) {
				DocumentBuilderFactory documentBuilderFactory = 
						DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = 
						documentBuilderFactory.newDocumentBuilder();
				_document = documentBuilder.parse(file);
			}
		} catch (Exception e) {}
	}
	
	public String getValue(String elem) {
		return _document.getElementsByTagName(elem).item(0).getTextContent();
	}

}
