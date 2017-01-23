package data.access;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ReutersParser {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Document doc = getAsDocument(new File("resources/reut2-000.sgm"));
		System.out.println(doc.getDocumentElement().toString());
	}
	
	private static Document getAsDocument(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		FileInputStream fis = new FileInputStream(xmlFile);
        BufferedReader r = new BufferedReader(new InputStreamReader(fis,
                "UTF8"));
        int a = 0;
        for (String s = ""; a<2;) {
            System.out.println(r.readLine());
            a++;
        }
		
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		ByteArrayInputStream input =  new ByteArrayInputStream(
		xmlFile.toString().getBytes("UTF-8"));
		return builder.parse(input);
	}
}
