package com.budiluhur;

import com.budiluhur.servlet.ProductServlet;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Application {

    public static void main(String[] args) throws Exception {

        System.out.println(
            "Menjalankan Embedded Tomcat Server..."
        );

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        Context ctx = tomcat.addContext(
            "",
            new File(".").getAbsolutePath()
        );

        Tomcat.addServlet(
            ctx,
            "ProductServlet",
            new ProductServlet()
        );

        ctx.addServletMappingDecoded(
            "/product",
            "ProductServlet"
        );

        System.out.println(
            "Server berhasil berjalan di: " +
            "http://localhost:8080/product"
        );

        tomcat.start();

        tomcat.getServer().await();
    }
}