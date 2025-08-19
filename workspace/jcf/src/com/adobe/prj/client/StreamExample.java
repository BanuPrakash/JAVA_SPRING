package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(); // use generics and interface
        products.add(new Product(92, "Samsung Fold", 1_20_000.00, "mobile"));
        products.add(new Product(71, "LG AC", 45000.00, "electronics"));
        products.add( new Product(76, "Wacom", 4000.00, "computer"));
        products.add(new Product(12, "iPhone", 99_000.00, "mobile"));
        products.add(new Product(34, "Logitech Mouse", 800.00, "computer"));
        // filter takes predicate [ boolean test(T t) ] ;
        // forEach takes Consumer [ void accept(T t); ]
        products.stream()
                .filter(p -> p.getCategory().equals("mobile"))
                .forEach(p -> System.out.println(p));

        System.out.println("***** GET NAMES ***");
//        products.stream()
//                .map(p -> p.getName())
//                .forEach(name -> System.out.println(name));

       List<String> names = products.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());

       names.forEach(name -> System.out.println(name));

        System.out.println("GET Names of Mobiles");
        products.stream()
                .filter(p -> p.getCategory().equals("mobile"))
                .map(p -> p.getName())
                .forEach(name -> System.out.println(name));


        System.out.println("Get Total Cost of all mobiles ");
        double total = products.stream()
                .filter(p -> p.getCategory().equals("mobile"))
                .map(p -> p.getPrice())
                .reduce(0.0, (v1, v2) -> v1 + v2);
        System.out.println("Total : " + total);

        System.out.println("***************");
       Map<String, List<Product>> prodCat =
//               products.stream().collect(Collectors.groupingBy(p -> p.getCategory()));
               products.stream().collect(Collectors.groupingBy(Product::getCategory)); // method reference

       prodCat.forEach( (k,v) -> {
           System.out.println("Category : " + k);
//           v.forEach(p -> System.out.println(p));
           v.forEach(System.out::println); // method reference
       });
    }
}
