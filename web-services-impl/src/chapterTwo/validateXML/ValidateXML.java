package chapterTwo.validateXML;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class ValidateXML {

	
	public static void main(String[] args) {
		if(args.length != 2) {
			String msg = "\nUsage: java ValidateXML XMLfile XSDfile";
			System.err.println(msg);
			return;
		}
		
		try {
			// Lê e valida o XML Schema (documento XSD)
			final String schema_uri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(schema_uri);
			Schema schema = factory.newSchema(new StreamSource(args[1]));
			
			//Valida o documento XML no XML Schema.
			Validator val =  schema.newValidator();
			val.validate(new StreamSource(args[0]));
		} catch (Exception e) {
			System.err.println(e);
			return;
		}
		System.out.println(args[0] + "validated againt " + args[1]);
	
	}
	
	
	
	
}
