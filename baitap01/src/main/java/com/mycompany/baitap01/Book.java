/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap01;

import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    // Constructor mặc định
    public Book() {
    }

    // Constructor đầy đủ
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // input()
    public void input() {
        Scanner x = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        this.id = Integer.parseInt(x.nextLine());

        System.out.print("Nhap ten sach: ");
        this.title = x.nextLine();

        System.out.print("Nhap tac gia: ");
        this.author = x.nextLine();

        System.out.print("Nhap don gia: ");
        this.price = Double.parseDouble(x.nextLine());
    }

    // output()
    public void output() {
        String msg = """
                Sach: ma sach=%d, ten sach=%s, tac gia=%s, don gia=%.2f
                """.formatted(id, title, author, price);
        System.out.println(msg);
    }
}

