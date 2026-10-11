package com.budiluhur;

import com.budiluhur.servlet.CategoryServlet;
import com.budiluhur.servlet.ProductServlet;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Application {

    public static void main(String[] args) throws Exception {

        System.out.println("Menjalankan Embedded Tomcat Server...");

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());

        // Servlet produk -> /products
        Tomcat.addServlet(ctx, "ProductServlet", new ProductServlet());
        ctx.addServletMappingDecoded("/products", "ProductServlet");

        // Servlet kategori -> /categories
        Tomcat.addServlet(ctx, "CategoryServlet", new CategoryServlet());
        ctx.addServletMappingDecoded("/categories", "CategoryServlet");

        System.out.println("Produk   : http://localhost:8080/products");
        System.out.println("Kategori : http://localhost:8080/categories");

        tomcat.start();
        tomcat.getServer().await();
    }
}
