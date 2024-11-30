//javac --release 21 --enable-preview InterpolationDemo.java
//java --enable-preview InterpolationDemo

String title = "My Web Page";
String text  = "Hello, world";

String html = STR.""" 	
	<html>
	  <head>
	    <title>\{title}</title>
	  </head>
	  <body>
	    <p>\{text}</p>
	  </body>
	</html>""";
String json = STR."""
		{
			"username": "Makarand"
		}
		""";

void main() {
	System.out.println(html);
	System.out.println(json);
}

class A{
public static void main(String argsp[]) {
	System.out.println("""
			--------------------------------------
			""");
//	System.out.println(html);
	System.out.println("""
			--------------------------------------
			--------------------------------------
			""");
//	System.out.println(json);
	System.out.println("""
			--------------------------------------
			""");
}
}