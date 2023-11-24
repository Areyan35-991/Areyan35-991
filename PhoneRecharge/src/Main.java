import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class RechargeService {
    private static final Map<String, Map<String, Double>> internetPackages = new HashMap<>();

    static {
        // Sample internet packages for each operator
        Map<String, Double> gpPackages = new HashMap<>();
        gpPackages.put("Daily", 25.0);
        gpPackages.put("Weekly", 140.0);
        gpPackages.put("Monthly", 550.0);
        internetPackages.put("Grameenphone", gpPackages);

        Map<String, Double> robiPackages = new HashMap<>();
        robiPackages.put("Daily", 20.0);
        robiPackages.put("Weekly", 120.0);
        robiPackages.put("Monthly", 500.0);
        internetPackages.put("Robi", robiPackages);

        Map<String, Double> airtelPackages = new HashMap<>();
        airtelPackages.put("Daily", 22.0);
        airtelPackages.put("Weekly", 130.0);
        airtelPackages.put("Monthly", 520.0);
        internetPackages.put("Airtel", airtelPackages);

        Map<String, Double> banglalinkPackages = new HashMap<>();
        banglalinkPackages.put("Daily", 18.0);
        banglalinkPackages.put("Weekly", 100.0);
        banglalinkPackages.put("Monthly", 480.0);
        internetPackages.put("Banglalink", banglalinkPackages);

        Map<String, Double> teletalkPackages = new HashMap<>();
        teletalkPackages.put("Daily", 15.0);
        teletalkPackages.put("Weekly", 100.0);
        teletalkPackages.put("Monthly", 430.0);
        internetPackages.put("Teletalk", teletalkPackages);
    }

    public static boolean recharge(String operator, String phoneNumber, double amount, String paymentMethod, String cardNumber, String accountNumber,String pin) {
        // Dummy implementation for recharge - replace with actual implementation or API call
        if ("Card".equalsIgnoreCase(paymentMethod)) {
            System.out.println("          Recharging " + operator + " number " + phoneNumber + " with amount " + amount +
                    " using " + paymentMethod + " (Card: " + cardNumber + " pin: " + pin + ")");
        } else if ("bKash".equalsIgnoreCase(paymentMethod) || "Rocket".equalsIgnoreCase(paymentMethod) || "Nagad".equalsIgnoreCase(paymentMethod)) {
            System.out.println("          Recharging " + operator + " number " + phoneNumber + " with amount " + amount +
                    " using " + paymentMethod + " (Account: " + accountNumber + ", Pin: " + pin + ")");
        } else {
            // Handle other payment methods
            System.out.println("          Recharging " + operator + " number " + phoneNumber + " with amount " + amount +
                    " using " + paymentMethod);
        }
        return true; // Return success or failure status
    }


    public static boolean purchaseInternetPackage(String operator, String phoneNumber, String packageType, String paymentMethod, String accountNumber, String pin) {
        // Dummy implementation for purchasing internet package - replace with actual implementation or API call
        if (internetPackages.containsKey(operator) && internetPackages.get(operator).containsKey(packageType)) {
            double packageCost = internetPackages.get(operator).get(packageType);
            System.out.println("            Purchasing " + packageType + " internet package for " + operator + " number " + phoneNumber +
                    " with cost " + packageCost + " using " + paymentMethod + " (Account: " + accountNumber + ", Pin: " + pin + ")");
            return true; // Return success or failure status
        } else {
            System.out.println("            Invalid internet package type or operator");
            return false;
        }
    }
}

class TopupExpress {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("            Welcome to Top-up Express");

        boolean continueRecharging = true;

        while (continueRecharging) {


            // Display operator options
        System.out.println("            Select Operator:");
        System.out.println("            1. Grameenphone");
        System.out.println("            2. Robi");
        System.out.println("            3. Airtel");
        System.out.println("            4. Banglalink");
        System.out.println("            5. Teletalk");

        // Get user input for operator selection
        System.out.print("          Enter operator number: ");
        int operatorChoice = scanner.nextInt();

        // Get user input for phone number
        System.out.print("          Enter phone number: ");
        String phoneNumber = scanner.next();


        boolean continueTransaction = true;

        while (continueTransaction) {
                // Get user input for recharge or internet package
                System.out.println("            Choose Action:");
                System.out.println("            1. Recharge");
                System.out.println("            2. Purchase Internet Package");
                System.out.println("            3. Go back to operator selection");

                System.out.print("          Enter action number: ");
                int actionChoice = scanner.nextInt();


        if (actionChoice == 1) {
            // Get user input for recharge amount
            System.out.print("          Enter recharge amount: ");
            double amount = scanner.nextDouble();

            // Get user input for payment method
            System.out.println("            Select Payment Method:");
            System.out.println("            1. Card");
            System.out.println("            2. bKash");
            System.out.println("            3. Rocket");
            System.out.println("            4. Nagad");

            System.out.print("            Enter payment method number: ");
            int paymentMethodChoice = scanner.nextInt();

            String paymentMethod = getPaymentMethodName(paymentMethodChoice);

            // Request card details if the user chooses the card as the payment method
            String cardNumber = "";
            String pin = "";
            String accountNumber = "";

            if (paymentMethod.equalsIgnoreCase("Card")) {
                System.out.print("          Enter card number: ");
                cardNumber = scanner.next();
                System.out.print("          Enter pin: ");
                pin = scanner.next();
            }else if ("bKash".equalsIgnoreCase(paymentMethod) || "Rocket".equalsIgnoreCase(paymentMethod) || "Nagad".equalsIgnoreCase(paymentMethod)) {
                System.out.print("          Enter " + paymentMethod + " account number: ");
                accountNumber = scanner.next();
                System.out.print("          Enter pin: ");
                pin = scanner.next();
            }

            // Perform recharge based on user input
            boolean rechargeSuccess = RechargeService.recharge(
                    getOperatorName(operatorChoice), phoneNumber, amount, paymentMethod, cardNumber, accountNumber, pin);

            // Display recharge status
            if (rechargeSuccess) {
                System.out.println("            Recharge successful!");
            } else {
                System.out.println("            Recharge failed. Please try again.");
            }
        } else if (actionChoice == 2) {
            // Get user input for internet package type
            System.out.println("            Grameenphone  1GB BDT25   Robi  1GB BDT20    Airtel  1GB BDT22    Banglalink  1GB BDT18     Teletalk    1GB BDT15");
            System.out.println("            Grameenphone  7GB BDT140  Robi  7GB BDT120   Airtel  7GB BDT130   Banglalink  7GB BDT100    Teletalk    7GB BDT100");
            System.out.println("            Grameenphone 30GB BDT550  Robi 30GB BDT500   Airtel 30GB BDT520   Banglalink 30GB BDT480    Teletalk   30GB BDT430");


            System.out.println("            Select Internet Package:");
            System.out.println("            1. Daily Package-1GB");
            System.out.println("            2. Weekly Package-7GB");
            System.out.println("            3. Monthly Package-30GB");

            System.out.print("          Enter package number: ");
            int packageChoice = scanner.nextInt();

            String packageType = getInternetPackageType(packageChoice);

            // Get user input for payment method
            System.out.println("            Select Payment Method:");
            System.out.println("            1. Card");
            System.out.println("            2. bKash");
            System.out.println("            3. Rocket");
            System.out.println("            4. Nagad");

            System.out.print("          Enter payment method number: ");
            int paymentMethodChoice = scanner.nextInt();

            String paymentMethod = getPaymentMethodName(paymentMethodChoice);

            // Request mobile banking details if the user chooses bKash, Rocket, or Nagad as the payment method
            String accountNumber = "";
            String pin = "";
            if (paymentMethod.equalsIgnoreCase("bKash") || paymentMethod.equalsIgnoreCase("Rocket") || paymentMethod.equalsIgnoreCase("Nagad") || paymentMethod.equalsIgnoreCase("Card")) {
                System.out.print("          Enter " + paymentMethod + " account number: ");
                accountNumber = scanner.next();
                System.out.print("          Enter pin: ");
                pin = scanner.next();
            }

            // Perform internet package purchase based on user input
            boolean packagePurchaseSuccess = RechargeService.purchaseInternetPackage(
                    getOperatorName(operatorChoice), phoneNumber, packageType, paymentMethod, accountNumber, pin);

            // Display internet package purchase status
            if (packagePurchaseSuccess) {
                System.out.println("            Internet package purchase successful!");
            } else {
                System.out.println("            Internet package purchase failed. Please try again.");
            }
            } else if (actionChoice == 3) {
            continueTransaction = false; // Go back to operator selection
            } else {
            System.out.println("            Invalid action choice");
         }

        }
        System.out.print("          Do you want to go back to the main menu? (1 for Yes, 0 for No): ");
        int continueChoice = scanner.nextInt();
        continueRecharging = continueChoice == 1;
    }

    // Close scanner
        scanner.close();
}

    private static String getOperatorName(int operatorChoice) {
        return switch (operatorChoice) {
            case 1 -> "Grameenphone";
            case 2 -> "Robi";
            case 3 -> "Airtel";
            case 4 -> "Banglalink";
            case 5 -> "Teletalk";
            default -> "";
        };
    }

    private static String getInternetPackageType(int packageChoice) {
        return switch (packageChoice) {
            case 1 -> "Daily";
            case 2 -> "Weekly";
            case 3 -> "Monthly";
            default -> "";
        };
    }

    private static String getPaymentMethodName(int paymentMethodChoice) {
        return switch (paymentMethodChoice) {
            case 1 -> "Card";
            case 2 -> "bKash";
            case 3 -> "Rocket";
            case 4 -> "Nagad";
            default -> "";
        };
    }
}
