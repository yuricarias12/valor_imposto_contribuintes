package application;

import entities.TaxPayer;
import entities.Individual;
import entities.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);


        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the numbr of tax payers: ");
        int quantity = ler.nextInt();

        for ( int cont = 1; cont <= quantity; cont++) {

            System.out.println("Tax payer #" + cont + " data: ");
            System.out.print("Individual or Company (i/c)? ");
            char opt = ler.next().charAt(0);
            ler.nextLine();
            System.out.print("Name: ");
            String name = ler.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = ler.nextDouble();

            if (opt == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = ler.nextDouble();

                list.add(new Individual(name, anualIncome, healthExpenditures));

            } else {

                System.out.print("Numbers of employees: ");
                Integer quantity_employees = ler.nextInt();

                list.add(new Company( name, anualIncome, quantity_employees));
            }


        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        for (TaxPayer taxPayer : list) {

            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f",taxPayer.tax()));

        }

        System.out.println();
        double sum = 0.0;
        for (TaxPayer taxPayer : list) {

            sum += taxPayer.tax();
        }

        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

        ler.close();
    }
}
