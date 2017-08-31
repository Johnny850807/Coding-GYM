import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String link = "http://teampathy.tk:8080/TriMago/Index?query=5&query2=10&query3=10&query4=10";
		/*                ﹚    ://  呼办                   (?:)  Port  (?:)  呼        (?:)      癬繷把计                  (?:)& ぇ把计                                 */
		final String regex = "(http|https|ftp|market)"
				+ "://([\\w\\.]+)(?::(\\d+))?(?:([/\\w]+)?(\\?(?:[\\w]+=[\\w]{1,5})(?:&[\\w]+=[\\w]{1,5})*)?)";

		Scanner scanner = new Scanner(System.in);
		String input;
		while(!(input = scanner.nextLine()).isEmpty()){
			List<WebLink> webLinks = parseWebLinks(regex,input);
			for ( WebLink webLink : webLinks)
				System.out.println(webLink);
		}
	}
	
	private static List<WebLink> parseWebLinks(String patternStr, String text){
		Pattern pattern = Pattern.compile(patternStr);
	    Matcher matcher = pattern.matcher(text);
	    List<WebLink> webLinks = new ArrayList<>();
	    while(matcher.find()) 
	    {
	    	WebLink webLink = new WebLink();
		    webLink.setUrl(matcher.group(0));
		    webLink.setProtocol(matcher.group(1));
		    webLink.setDomain(matcher.group(2));
		    webLink.setPort(matcher.group(3));
		    webLink.setAddress(matcher.group(4));
		    webLink.setParameters(matcher.group(5));
		    webLinks.add(webLink);
	    }
	    
	    return webLinks;
	}
}
