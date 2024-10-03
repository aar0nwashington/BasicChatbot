import java.util.Scanner;
import java.util.List;
import java.util.Arrays;


public class Main{

    //filter some words that throw off the conversation
    private static final List<String> badWords = Arrays.asList("idk", "nothing", "whatever", "asdf","what is life", "i love you",
    "null","true","exit","false","shutdown","throw new exception","exit"); 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mood;
        System.out.print("Hi, how are you? (good/bad): ");
        while (true) {
            mood = scan.nextLine();  // Capture user input

            if (mood.equalsIgnoreCase("goodbye") || mood.equalsIgnoreCase("bye") || mood.equalsIgnoreCase("see you")) {
                System.out.println("Goodbye! Have a great day!");
                break;  // Exit the loop and end the conversation
            }

            switch (mood.toLowerCase()) {
                case "good":
                    System.out.println("Glad to hear that!  What made your day good?");
                    handleGoodResponse(scan);
                    break;

                case "bad":
                    System.out.println("I'm sorry to hear that. How can I help?");
                    handleBadResponse(scan);
                    break;

                default:
                    System.out.println("I didn't understand that. Could you clarify?");
                    handleDefaultResponse(scan);
                    break;
            }

            // Prompt the user to keep the conversation going
            System.out.println("\nWhat would you like to talk about next?");
        }

        scan.close(); // Close the scanner
    }

    private static void handleGoodResponse(Scanner scan) {
        String goodResponse = scan.nextLine();
        
        // Check for custom phrases or bad words
        if (containsBadWords(goodResponse)) {
            System.out.println("Let's keep the conversation positive!  What else made your day good?");
        } else if (goodResponse.toLowerCase().contains("i love you")) {
            System.out.println("I don't.");
        } else if (goodResponse.toLowerCase().contains("tell me a joke")) {
            System.out.println("Why don't skeletons fight each other? They don't have the guts. ");
        } else if (goodResponse.toLowerCase().contains("how are you")) {
            System.out.println("I'm just a bunch of code, but thanks for asking! How about you?");
        } else {
            System.out.println("That's great! What do you like about your job?");
            String jobResponse = scan.nextLine();

            if(containsBadWords(jobResponse)){
                System.out.println("Lets keep it proffessional");
            }else{
                System.out.println("Ok, sounds interesting!");

            }
            }


        }
    

    private static void handleBadResponse(Scanner scan) {
        String badResponse = scan.nextLine();

        // Check for custom phrases or bad words
        if (containsBadWords(badResponse)) {
            System.out.println("Let's focus on the good things! What's something positive happening?");
        } else if (badResponse.toLowerCase().contains("i love you")) {
            System.out.println("I don't.");
        } else if (badResponse.toLowerCase().contains("tell me a joke")) {
            System.out.println("Why don't skeletons fight each other? They don't have the guts. ");
        } else if (badResponse.toLowerCase().contains("how are you")) {
            System.out.println("I'm just a bunch of code, but thanks for asking! How about you?");
        } else {
            System.out.println("I understand. Sometimes talking about it helps. Want to share?");
        }
    }

    private static void handleDefaultResponse(Scanner scan) {
        String unclearResponse = scan.nextLine();
        
        // Check for custom phrases or words that throw off the conversation
        if (containsBadWords(unclearResponse)) {
            System.out.println("Let's keep things respectful! What would you like to talk about instead?");
        } else if (unclearResponse.toLowerCase().contains("i love you")) {
            System.out.println("I don't.");
        } else if (unclearResponse.toLowerCase().contains("tell me a joke")) {
            System.out.println("Why don't skeletons fight each other? They don't have the guts. ");
        } else if (unclearResponse.toLowerCase().contains("how are you")) {
            System.out.println("I'm just a bunch of code, but thanks for asking! How about you?");
        } else {
            System.out.println("Thanks for explaining! How about sharing something interesting?");
        }
    }

    private static boolean containsBadWords(String input) {
        // Check if the input contains any flagged words
        for (String badWord : badWords) {
            if (input.toLowerCase().contains(badWord)) {
                return true;
            }
        }
        return false;
    }   
       
}