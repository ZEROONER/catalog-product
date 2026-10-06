package com.budiluhur.repository;

import com.budiluhur.model.Product;
import com.budiluhur.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    // Menambahkan produk
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Mengambil semua produk
    public List<Product> findAll() {
        return productList;
    }

    // Mencari produk berdasarkan ID
    public Product findById(String id) throws ProductNotFoundException {

        for (Product p : productList) {

            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }

        throw new ProductNotFoundException(
            "Produk dengan ID '" + id + "' tidak ditemukan!"
        );
    }
}