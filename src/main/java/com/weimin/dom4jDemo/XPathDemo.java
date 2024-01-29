package com.weimin.dom4jDemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XPathDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/resources/book.xml"));

        // 根节点
        Element rootElement = document.getRootElement();

        Node categoryNode = rootElement.selectSingleNode("//book[@category='CHILDREN']");

        System.out.println(categoryNode.getName());

        Element element = (Element) categoryNode;

        System.out.println(element.elementText("title"));
        System.out.println(element.elementText("author"));
        System.out.println(element.elementText("year"));
        System.out.println(element.elementText("price"));

        List<Node> nodes = rootElement.selectNodes("//title");

        for (Node node : nodes) {
            System.out.println(node.getText());
        }

    }
}
