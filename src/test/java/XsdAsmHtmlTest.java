import org.junit.Assert;
import org.junit.Test;
import org.xmlet.htmlFaster.Element;
import org.xmlet.htmlFaster.EnumTypeContentType;
import org.xmlet.htmlFaster.Html;

public class XsdAsmHtmlTest {

    @Test
    public void testGeneratedClassesIntegrity() throws Exception {
        CustomVisitorHtml customVisitor = new CustomVisitorHtml();

        new Html<>(customVisitor)
            .head()
                .comment("This is a comment.")
                .meta().attrCharset("UTF-8").__()
                .title()
                    .text("Title").__()
                .link().attrType(EnumTypeContentType.TEXT_CSS).attrHref("/assets/images/favicon.png").__()
                .link().attrType(EnumTypeContentType.TEXT_CSS).attrHref("/assets/styles/main.css").__().__()
            .body().attrClass("clear")
                .div()
                    .header()
                        .section()
                            .div()
                                .img().attrId("brand").attrSrc("./assets/images/logo.png").__()
                                .aside()
                                    .em()
                                        .text("Advertisement")
                                    .span()
                                        .text("HtmlApi is great!")
                                    .__()
                                .__()
                            .__()
                        .__()
                    .__()
                .__()
            .__()
        .__().__();

        String result = customVisitor.getResult();

        String expected =   "<html>\n" +
                                "\t<head>\n" +
                                    "\t\t<!-- This is a comment. -->\n" +
                                    "\t\t<meta charset=\"UTF-8\">\n" +
                                    "\t\t</meta>\n" +
                                    "\t\t<title>\n" +
                                        "\t\t\tTitle\n" +
                                    "\t\t</title>\n" +
                                    "\t\t<link type=\"text/css\" href=\"/assets/images/favicon.png\">\n" +
                                    "\t\t</link>\n" +
                                    "\t\t<link type=\"text/css\" href=\"/assets/styles/main.css\">\n" +
                                    "\t\t</link>\n" +
                                "\t</head>\n" +
                                "\t<body class=\"clear\">\n" +
                                    "\t\t<div>\n" +
                                        "\t\t\t<header>\n" +
                                            "\t\t\t\t<section>\n" +
                                                "\t\t\t\t\t<div>\n" +
                                                    "\t\t\t\t\t\t<img id=\"brand\" src=\"./assets/images/logo.png\">\n" +
                                                    "\t\t\t\t\t\t</img>\n" +
                                                    "\t\t\t\t\t\t<aside>\n" +
                                                        "\t\t\t\t\t\t\t<em>\n" +
                                                            "\t\t\t\t\t\t\t\tAdvertisement\n" +
                                                            "\t\t\t\t\t\t\t\t<span>\n" +
                                                                "\t\t\t\t\t\t\t\t\tHtmlApi is great!\n" +
                                                            "\t\t\t\t\t\t\t\t</span>\n" +
                                                        "\t\t\t\t\t\t\t</em>\n" +
                                                    "\t\t\t\t\t\t</aside>\n" +
                                                "\t\t\t\t\t</div>\n" +
                                            "\t\t\t\t</section>\n" +
                                        "\t\t\t</header>\n" +
                                    "\t\t</div>\n" +
                                "\t</body>\n" +
                            "</html>";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void customAttribute(){
        CustomVisitorHtml visitor = new CustomVisitorHtml();

        Html<Element> html = new Html<>(visitor);

        html.addAttr("attr1", "value1").__();

        String result = visitor.getResult();

        String expected =
                "<html attr1=\"value1\">\n" +
                "</html>";

        Assert.assertEquals(expected, result);
    }
}
