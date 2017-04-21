package com.company;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jinxianhua on 2017/4/20.
 */
public class WPattern {
    public void print(){
                long startdate=new Date().getTime();

        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        String regex = "thunder://[A-Za-z0-9]+|magnet:\\?xt=urn:btih:[A-Za-z0-9&;=\\.\\[\\]]+";
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL("http://www.kan84.net/bdhd/btzhivswanGCxilie.html");
            urlconn = url.openConnection();
            pw = new PrintWriter(new FileWriter("/Users/jinxianhua/IdeaProjects/WebSpider/url.txt"), true);//这里我们把收集到的链接存储在了E盘底下的一个叫做url的txt文件中
            br = new BufferedReader(new InputStreamReader(
                    urlconn.getInputStream()));
            String buf = null;
            int i=0;
            while ((buf = br.readLine()) != null) {
                Matcher buf_m = p.matcher(buf);

                while (buf_m.find()) {
                    pw.println(  buf_m.group());
                }
            }
            System.out.println("获取成功！");
            System.out.println((new Date().getTime()-startdate)/1000);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
