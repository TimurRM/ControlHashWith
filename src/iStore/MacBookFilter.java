package iStore;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MacBookFilter {

    public static void main(String[] args) {
        Set<MacBook> macBooks = new HashSet<>();
        // Примеры ноутбуков MacBook
        macBooks.add(new MacBook("MacBook Air", "Apple M1", 8, 256, "Space Grey", 2020, 13.3));
        macBooks.add(new MacBook("MacBook Air", "Apple M1", 8, 512, "Silver", 2020, 13.3));
        macBooks.add(new MacBook("MacBook Air", "Apple M1", 16, 512, "Gold", 2020, 13.3));
        macBooks.add(new MacBook("MacBook Pro", "Intel Core i5", 8, 256, "Space Grey", 2020, 13.3));
        macBooks.add(new MacBook("MacBook Pro", "Intel Core i7", 16, 512, "Silver", 2020, 13.3));
        macBooks.add(new MacBook("MacBook Pro", "Apple M1", 16, 512, "Space Grey", 2020, 13.3));
        macBooks.add(new MacBook("MacBook Pro", "Apple M1", 16, 1024, "Space Grey", 2021, 13.3));
        macBooks.add(new MacBook("MacBook Air", "Apple M2", 16, 512, "Silver", 2022, 14.0));
        macBooks.add(new MacBook("MacBook Pro", "Apple M2", 16, 512, "Midnight", 2022, 14.0));
        macBooks.add(new MacBook("MacBook Pro", "Intel Core i9", 32, 2048, "Space Grey", 2023, 16.0));
        macBooks.add(new MacBook("MacBook Air", "Apple M2", 16, 512, "Gold", 2023, 13));
        macBooks.add(new MacBook("MacBook Air", "Apple M3", 8, 256, "Midnight", 2023, 15));
        macBooks.add(new MacBook("MacBook Pro", "Apple M3 Pro", 24, 1024, "Silver", 2023, 14.0));
        macBooks.add(new MacBook("MacBook Pro", "Apple M3 Pro", 36, 2048, "Silver", 2024, 16.0));
        macBooks.add(new MacBook("MacBook Pro", "Apple M3 Max", 48, 4096, "Space Black", 2024, 16.0));
        // Добавьте дополнительные объекты MacBook согласно вашему выбору...

        System.out.println("Исходный список ноутбуков MacBook:");
        macBooks.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nВыберите критерий фильтрации или введите 0 для выхода:");
            System.out.println("1 - Модель");
            System.out.println("2 - Год выпуска");
            System.out.println("3 - Процессор");
            System.out.println("4 - ОЗУ");
            System.out.println("5 - Объем SSD");
            System.out.println("6 - Цвет");
            System.out.println("7 - Диагональ дисплея");
            System.out.println("Введите 0 для выхода.");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера после чтения числа

                if (choice == 0) {
                    System.out.println("Выход из программы.");
                    break;
                }

                Set<MacBook> filteredMacBooks = filterMacBooks(macBooks, choice, scanner);

                if (!filteredMacBooks.isEmpty()) {
                    System.out.println("Отфильтрованный список ноутбуков MacBook:");
                    filteredMacBooks.forEach(System.out::println);
                } else {
                    System.out.println("Ноутбуки, соответствующие критериям, не найдены.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Неверный ввод. Пожалуйста, введите целое число.");
                scanner.nextLine(); // очистка буфера
            }
        } while (true);

        scanner.close();
    }

    private static Set<MacBook> filterMacBooks(Set<MacBook> macBooks, int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Введите модель ноутбука MacBook (например, MacBook Air или MacBook Pro):");
                String model = scanner.nextLine().trim();
                return macBooks.stream()
                        .filter(macBook -> macBook.getModel().equalsIgnoreCase(model))
                        .collect(Collectors.toSet());
            case 2:
                System.out.println("Введите год выпуска:");
                int year = scanner.nextInt();
                return macBooks.stream()
                        .filter(macBook -> macBook.getYear() == year)
                        .collect(Collectors.toSet());
            case 3:
                System.out.println("Введите процессор (например, Apple M1, Apple M2):");
                String processor = scanner.nextLine().trim();
                return macBooks.stream()
                        .filter(macBook -> macBook.getProcessor().equalsIgnoreCase(processor))
                        .collect(Collectors.toSet());
            case 4:
                System.out.println("Введите объем ОЗУ в GB:");
                int memory = scanner.nextInt();
                return macBooks.stream()
                        .filter(macBook -> macBook.getMemory() >= memory)
                        .collect(Collectors.toSet());
            case 5:
                System.out.println("Введите объем SSD в GB:");
                int storage = scanner.nextInt();
                return macBooks.stream()
                        .filter(macBook -> macBook.getStorage() >= storage)
                        .collect(Collectors.toSet());
            case 6:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine().trim();
                return macBooks.stream()
                        .filter(macBook -> macBook.getColor().equalsIgnoreCase(color))
                        .collect(Collectors.toSet());
            case 7:
                System.out.println("Введите диагональ дисплея в дюймах:");
                double displaySize = scanner.nextDouble();
                return macBooks.stream()
                        .filter(macBook -> macBook.getDisplaySize() == displaySize)
                        .collect(Collectors.toSet());
            default:
                System.out.println("Неверный ввод. Пожалуйста, попробуйте снова.");
                return new HashSet<>();
        }
    }
}

