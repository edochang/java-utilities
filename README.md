# <a name='java-utilities'>java-utilities</a>
A repository of useful java utilities.
1. [XSD and XML Validator Form](#xsdxml)

Java Version Notes:  These code files were written in openjdk 17.0.1 2021-10-19.

# <a name='xsdxml'>1. XSD and XML Validator Form</a>
A java program used to validate an Extensible Markup Language (XML) message against its XML Schema Definition (XSD).  This program is used if you need to validate your XML message without using an online hosted tool.  Typically useful if you have sensitive data that cannot be shared over the web.

## How To Use
To use the this Java program you can run the executable .jar file.

    java -jar .\XSDXMLValidator.jar

## References
The creation of this local java executable references Andrew Mouat's validate.java implementation: https://github.com/amouat/xsd-validator.  This project creates a Java Swing UI to quickly copy and paste the XML and XSD data for the validate.java to do the validation.
