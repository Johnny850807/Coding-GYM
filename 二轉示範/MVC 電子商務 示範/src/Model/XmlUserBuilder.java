package Model;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.SAXException;
import static Model.XmlUtils.*;

public class XmlUserBuilder implements UserBuilder<Element> {
	private static final String FILE_NAME = "MVCµù¥U.xml";
	private Document document;
	private Element userElement;
	
	@Override
	public UserBuilder<Element> register(String name, String account, String password) throws Exception {
		document = createDocument(FILE_NAME);
		String xpath = String.format("//user[@account='%s']", account);
		NodeList result = executeXpath(document, XPathConstants.NODESET, xpath);
		if (result.getLength() != 0)
			throw new AccountDuplicatedException();
		User user = new User(name, account, password, 5000);
		userElement = userToElement(document, user);
		Element root = document.getDocumentElement();
		root.appendChild(userElement);
		return this;
	}

	@Override
	public UserBuilder<Element> signIn(String account, String password)  throws Exception {
		document = createDocument(FILE_NAME);
		String xpath = String.format("//user[@account='%s' and @password='%s']", account, password);
		Node userNode = executeXpath(document, XPathConstants.NODE, xpath);
		if (userNode == null)
			throw new UserNotFoundException();
		userElement = (Element) userNode;
		return this;
	}

	@Override
	public UserBuilder<Element> buyProduct(Product product)  throws Exception {
		Element element = productToElement(document, product);
		userElement.appendChild(element);
		int money = Integer.valueOf(userElement.getAttribute("money"));
		userElement.setAttribute("money", String.valueOf(money - product.getPrice()));
		return this;
	}

	@Override
	public Element build() {
		try {
			saveDom(document, FILE_NAME);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		int length = parseProductElementsUnderUserElement(userElement).size();
		return userElement;
	}
	
}
