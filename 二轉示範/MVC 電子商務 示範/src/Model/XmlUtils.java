package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlUtils {
	private static final String USER = "user";
	private static final String PRODUCT = "product";

	public static User parseUserByElement(Element userElement) throws ParseException {
		String userName = userElement.getAttribute("name");
		String userAccount = userElement.getAttribute("account");
		String userPassword = userElement.getAttribute("password");
		int userMoney = Integer.valueOf(userElement.getAttribute("money"));
		User user = new User(userName, userAccount, userPassword, userMoney);
		List<Element> productElements = parseProductElementsUnderUserElement(userElement);
		List<Product> products = new ArrayList<>();
		for (Element element : productElements)
			products.add(parseProductByElement(element));
		user.setProducts(products);
		return user;
	}

	public static List<Element> parseProductElementsUnderUserElement(Element userElement) {
		List<Element> elements = new ArrayList<>();
		NodeList nodeList = userElement.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++)
			if (nodeList.item(i) instanceof Element)
				elements.add((Element) nodeList.item(i));
		return elements;
	}

	public static Product parseProductByElement(Element productElement) throws ParseException {
		String name = productElement.getAttribute("name");
		int price = Integer.valueOf(productElement.getAttribute("price"));
		String date = productElement.getAttribute("date");
		return new Product(name, price, date);
	}

	public static Document createDocument(String filename)
			throws SAXException, IOException, ParserConfigurationException {
		File file = new File(filename);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		if (!file.exists()) {
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<MVC></MVC>");
			writer.close();
		}

		return builder.parse(file);
	}

	public static <T> T executeXpath(Document document, QName type, String xpath) throws XPathExpressionException {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPathExpression expr = xPathfactory.newXPath().compile(xpath);
		return (T) expr.evaluate(document, type);
	}

	public static Element userToElement(Document document, User user) {
		Element userElement = document.createElement(USER);
		userElement.setAttribute("name", user.getName());
		userElement.setAttribute("account", user.getAccount());
		userElement.setAttribute("password", user.getPassword());
		userElement.setAttribute("money", String.valueOf(user.getMoney()));
		return userElement;
	}

	public static Element productToElement(Document document, Product product) {
		Element productElement = document.createElement(PRODUCT);
		productElement.setAttribute("name", product.getName());
		productElement.setAttribute("price", String.valueOf(product.getPrice()));
		productElement.setAttribute("date", product.dateToString());
		return productElement;
	}

	public static void saveDom(Document document, String fileName) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(document);
		StreamResult streamResult =  new StreamResult(new File(fileName));
		transformer.transform(source, streamResult);
	}
}
