/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.baitap01;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author SANGSANG
 */
public class Baitap01 {

    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        int chon;

        do {
            System.out.println("===== CHUONG TRINH QUAN LY SACH =====");
            System.out.println("1. Them 1 cuon sach");
            System.out.println("2. Xoa 1 cuon sach");
            System.out.println("3. Thay doi sach");
            System.out.println("4. Xuat thong tin");
            System.out.println("5. Tim sach Lap trinh");
            System.out.println("6. Lay sach toi da theo gia");
            System.out.println("7. Tim sach theo tac gia");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            chon = x.nextInt();
            x.nextLine(); // clear buffer

            switch (chon) {

                // CASE 1: Thêm sách
                case 1 -> {
                    Book b = new Book();
                    b.input();
                    listBook.add(b);
                }

                // CASE 2: Xóa sách
                case 2 -> {
                    System.out.print("Nhap ma sach can xoa: ");
                    int bookId = x.nextInt();
                    x.nextLine();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);

                    if (find != null) {
                        listBook.remove(find);
                        System.out.println("Da xoa thanh cong");
                    } else {
                        System.out.println("Khong tim thay sach");
                    }
                }

                // CASE 3: Sửa sách
                case 3 -> {
                    System.out.print("NNhap ma sach can sua: ");
                    int bookId = x.nextInt();
                    x.nextLine();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);

                    if (find != null) {
                        find.input();
                        System.out.println("Cap nhat thanh cong");
                    } else {
                        System.out.println("Khong tim thay sach");
                    }
                }

                // CASE 4: Xuất danh sách
                case 4 -> {
                    if (listBook.isEmpty()) {
                        System.out.println("Danh sach sach rong");
                    } else {
                        listBook.forEach(Book::output);
                    }
                }

                // CASE 5: Tìm sách chứa "lập trình"
                case 5 -> {
                    listBook.stream()
                            .filter(b -> b.getTitle().toLowerCase().contains("lap trinh"))
                            .forEach(Book::output);
                }

                // CASE 6: Lấy tối đa K sách có giá <= P
                case 6 -> {
                    System.out.print("Nhap K: ");
                    int k = x.nextInt();

                    System.out.print("Nhap gia P: ");
                    double p = x.nextDouble();
                    x.nextLine();

                    listBook.stream()
                            .filter(b -> b.getPrice() <= p)
                            .limit(k)
                            .forEach(Book::output);
                }

                // CASE 7: Tìm sách theo danh sách tác giả
                case 7 -> {
                    System.out.print("Nhap so tac gia can tim: ");
                    int n = Integer.parseInt(x.nextLine());

                    Set<String> authorSet = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhap tac gia " + (i + 1) + ": ");
                        authorSet.add(x.nextLine().toLowerCase());
                    }

                    listBook.stream()
                            .filter(b -> authorSet.contains(b.getAuthor().toLowerCase()))
                            .forEach(Book::output);
                }

                case 0 -> System.out.println("Da thoat chuong trinh");

                default -> System.out.println("Chuc nang khong hop le");
            }

        } while (chon != 0);
    }
}
