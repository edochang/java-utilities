package org.xsdxmlvalidator;

/*
 * XSD Validator.
 * 
 * Copyright 2013 Adrian Mouat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class validate {
  
    /**
     * @param args
     */
    public static String validtateXMLXSD(String stringXML, String stringXSD) {
        
        //parseArgs(args);
        SchemaFactory factory = SchemaFactory.newInstance(
                "http://www.w3.org/2001/XMLSchema");
        
        String strResult = "";
        
        try {
        	Source sourceXSD = new StreamSource(new StringReader(stringXSD));
        	
        	Schema schema = factory.newSchema(sourceXSD);
            Validator validator = schema.newValidator();

            Source source = new StreamSource(new StringReader(stringXML));

            try {
                validator.validate(source);
                strResult = "XML validates";
                System.out.println(strResult);
            }
            catch (SAXParseException ex) {
                strResult = "XML fails to validate because: \n";            	
            	System.out.println(strResult);
            	strResult = strResult + ex.getMessage() + "\n";
                System.out.println(ex.getMessage());
                strResult = strResult + "At: " + ex.getLineNumber() 
                + ":" + ex.getColumnNumber() + "\nVALIDATION_FAIL";
                System.out.println("At: " + ex.getLineNumber() 
                        + ":" + ex.getColumnNumber());
                System.out.println();
            }
            catch (SAXException ex) {
            	strResult = "XML fails to validate because: \n";
                System.out.println(strResult);
                strResult = strResult + ex.getMessage() + "\nVALIDATION_FAIL";
                System.out.println(ex.getMessage());
                System.out.println();                
            }
            catch (IOException io) {
                strResult = "Error reading XML source \n" + io.getMessage() + "\nERROR_READING_XML";
            	System.err.println(strResult);
            }

        } catch (SAXException sch) {
            strResult = "Error reading XML Schema from input \n";
        	System.err.println(strResult);
        	strResult = strResult + sch.getMessage() + "\nERROR_READING_SCHEMA";
            System.err.println(sch.getMessage());
        }
        
        return strResult;

    }
}