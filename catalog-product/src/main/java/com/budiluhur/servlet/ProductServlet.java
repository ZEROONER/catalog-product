package com.budiluhur.servlet;

import com.budiluhur.model.Product;
import com.budiluhur.repository.ProductRepository;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() {

        // Inisialisasi repository
        productRepository = new ProductRepository();

        // Data produk awal
        productRepository.addProduct(
            new Product(
                "PRD-01",
                "Keyboard Mechanical",
                450000.0
            )
        );

        productRepository.addProduct(
            new Product(
                "PRD-02",
                "Mouse Wireless Silent",
                175000.0
            )
        );

        productRepository.addProduct(
            new Product(
                "PRD-03",
                "Monitor Gaming 24 Inch",
                2100000.0
            )
        );
    }

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        List<Product> products =
            productRepository.findAll();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Katalog Produk Web</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>=== DAFTAR KATALOG PRODUK (WEB) ===</h2>");

        out.println("<table border='1' cellpadding='8'>");

        out.println(
            "<tr>" +
            "<th>ID Produk</th>" +
            "<th>Nama Produk</th>" +
            "<th>Harga Satuan</th>" +
            "</tr>"
        );

        for (Product p : products) {

            out.println("<tr>");

            out.println(
                "<td>" + p.getId() + "</td>"
            );

            out.println(
                "<td>" + p.getName() + "</td>"
            );

            out.println(
                "<td>Rp" + p.getPrice() + "</td>"
            );

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}