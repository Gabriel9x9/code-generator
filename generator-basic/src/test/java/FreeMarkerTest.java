import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {
    public static void main(String[] args) throws IOException, TemplateException {

        // object
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_32);

        // point to path
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // charset
        configuration.setDefaultEncoding("utf-8");

        // create and load template
        Template template = configuration.getTemplate("myweb.html.ftl");

        // data model
        Map<String,Object> dataModel=new HashMap<>();
        dataModel.put("currentYear",2025);
        List<Map<String,Object>> menuItens=new ArrayList<>();
        Map<String,Object> menuItem1=new HashMap<>();
        menuItem1.put("url","https://blog.csdn.net/2302_79135465");
        menuItem1.put("label","CSDN");
        Map<String,Object> menuItem2=new HashMap<>();
        menuItem2.put("url","https://juejin.cn/user/1819006196264012");
        menuItem2.put("label","稀土掘金");
        menuItens.add(menuItem1);
        menuItens.add(menuItem2);
        dataModel.put("menuItems",menuItens);

        FileWriter out = new FileWriter("myweb.html");

        template.process(dataModel,out);
        out.close();
    }
}
