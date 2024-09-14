package practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


public class CouponCode {

    static HashMap<String, String> categoriesMap = new HashMap<>();
    static HashMap<String, TreeMap<Date, List<String>>> couponMap = new HashMap<>();

    public static String getCategory(String CategoryName) {
        AtomicReference<String> couponName = new AtomicReference<>("");
        if (couponMap.containsKey(CategoryName)) {
            couponMap.get(CategoryName).lastEntry().getValue().forEach(i -> {
                couponName.set(couponName.get() + i + "|");
            });
        } else {
            String catName = CategoryName;
            if (categoriesMap.containsKey(catName)) {
                while (categoriesMap.get(catName) != null) {
                    if (couponMap.containsKey(catName)) {
                        couponMap.get(CategoryName).lastEntry().getValue().forEach(i -> {
                            couponName.set(couponName.get() + i + "|");
                        });
                        break;
                    } else {
                        catName = categoriesMap.get(catName);
                    }
                }
            }
        }
        return couponName.get().equalsIgnoreCase(" ") ? null : couponName.get().substring(0, couponName.get().length() - 1);

    }

    public static void main(String[] args) throws ParseException {
        String[][] Coupons = {
                {"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01"},
                {"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2021-01-01"},
                {"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01"},
                {"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01"},
                {"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01"},
                {"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01"},
                {"CategoryName:Bed & Bath", "CouponName:Big Savings for Bed & Bath", "DateModified:2030-01-01"}
        };

        String[][] Categories = {
                {"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
                {"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
                {"CategoryName:Bed & Bath", "CategoryParentName:None"},
                {"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
                {"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
                {"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
                {"CategoryName:Baby And Kids", "CategoryParentName:None"}
        };


        for (int i = 0; i < Categories.length; i++) {
            categoriesMap.put(Categories[i][0].split(":")[1], Categories[i][1].split(":")[1]);
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < Coupons.length; i++) {
            String catName = Coupons[i][0].split(":")[1];
            String coupName = Coupons[i][1].split(":")[1];
            String coupDate = Coupons[i][2].split(":")[1];
            // you can change format of date
            TreeMap<Date, List<String>> couponInfoTreeMap = couponMap.getOrDefault(catName, new TreeMap<>());
            Date date = formatter.parse(coupDate);
            List<String> coupons = couponInfoTreeMap.getOrDefault(date, new ArrayList<>());
            coupons.add(coupName);
            couponInfoTreeMap.put(date, coupons);
            couponMap.put(catName, couponInfoTreeMap);

        }

//        Comforter Sets
//        Bedding
//        Bathroom Accessories
//        Soap Dispensers
//        Toy Organizers


        Scanner sc = new Scanner(System.in);
        Integer inputSize = Integer.parseInt(sc.nextLine());
        String[] input = new String[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = sc.nextLine();
        }

        for (int i = 0; i < inputSize; i++) {
            System.out.println(getCategory(input[i]));
        }

    }
}
