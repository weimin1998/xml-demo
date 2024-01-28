package com.weimin.dom4jDemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

// dom4j，read xml
public class Read {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/resources/book.xml"));

        // org.dom4j.tree.DefaultDocument@1b28cdfa [Document: name file:///E:/javacode/xml-demo/src/main/resources/book.xml]
        System.out.println(document);

        System.out.println(document.getNodeType());

        // 根节点
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getNodeType());
        //bookstore
        System.out.println(rootElement.getName());

        // book element list
        List<Element> elements = rootElement.elements();

//        for (Element element : elements) {
//            System.out.println(element.getName());// book
//            System.out.println(element.elementText("title"));
//            System.out.println(element.elementText("author"));
//            System.out.println(element.elementText("year"));
//            System.out.println(element.elementText("price"));
//        }

        for (Element element : elements) {
            System.out.println(element.getName());
            System.out.println(element.attributeValue("category"));
            List<Element> elementList = element.elements();
            for (Element ele : elementList) {
                System.out.println(ele.getName() + ": " + ele.getText());
            }
        }
    }
}
