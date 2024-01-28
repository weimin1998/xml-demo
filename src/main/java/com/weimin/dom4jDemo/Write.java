package com.weimin.dom4jDemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Write {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/resources/book.xml"));

        // 根节点
        Element rootElement = document.getRootElement();

        List<Element> elements = rootElement.elements();

        Element book = elements.get(0);

        Element price = book.element("price");

        System.out.println(price.getText());

        price.setText("40.00");

        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/main/resources/Write_book.xml"), OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
