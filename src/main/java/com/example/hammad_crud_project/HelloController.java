package com.example.hammad_crud_project;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Scanner;


public class HelloController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstname = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastname = scanner.nextLine();
        scanner.close();

        System.out.println("Hello " + firstname + " " + lastname);

    }
}
