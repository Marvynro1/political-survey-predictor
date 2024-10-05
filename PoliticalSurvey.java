import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PoliticalSurvey {
    public static void main(String[] args) {
        // Initialize prior probabilities for each party
        double republicanProb = 0.25;
        double democratProb = 0.25;
        double independentProb = 0.25;
        double libertarianProb = 0.25;

        // Create a scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Initialize the likelihood of each party
        double republicanLikelihood = 1;
        double democratLikelihood = 1;
        double independentLikelihood = 1;
        double libertarianLikelihood = 1;

        // Ask the user 10 questions
        // Q1
        System.out.println("Q1: Should the government increase taxes on the wealthy to fund social programs?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer1 = scanner.next();
        // Q2
        System.out.println("Q2: Should the government provide free healthcare for all citizens?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer2 = scanner.next();
        // Q3
        System.out.println("Q3: Should the government increase regulations on big businesses?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer3 = scanner.next();
        // Q4
        System.out.println("Q4: Should the government decrease military spending?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer4 = scanner.next();
        // Q5
        System.out.println("Q5: Should the government support the right to own a gun?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer5 = scanner.next();
        // Q6
        System.out.println("Q6: Should the government increase funding for environmental protection?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer6 = scanner.next();
        // Q7
        System.out.println("Q7: Should the government increase funding for education?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer7 = scanner.next();
        // Q8
        System.out.println("Q8: Should the government support renewable energy sources?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer8 = scanner.next();
        // Q9
        System.out.println("Q9: Should the government increase the minimum wage?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer9 = scanner.next();
        // Q10
        System.out.println("Q10: Should the government increase gun control?");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("C. Not Sure");
        System.out.println("D. Prefer not to say");
        System.out.print("Answer: ");
        String answer10 = scanner.next();

        // calculate the likelihood of each party given the user's responses
        republicanLikelihood *= calculateRepublicanLikelihood(answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10);
        democratLikelihood *= calculateDemocratLikelihood(answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10);
        independentLikelihood *= calculateIndependentLikelihood(answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10);
        libertarianLikelihood *= calculateLibertarianLikelihood(answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10);

        // calculate the posterior probability of each party
        double republicanPosterior = republicanLikelihood * republicanProb;
        double democratPosterior = democratLikelihood * democratProb;
        double independentPosterior = independentLikelihood * independentProb;
        double libertarianPosterior = libertarianLikelihood * libertarianProb;

        // determine the party with the highest posterior probability
        String party = "Republican";
        double maxPosterior = republicanPosterior;
        if (democratPosterior > maxPosterior) {
            party = "Democrat";
            maxPosterior = democratPosterior;
        }
        if (independentPosterior > maxPosterior) {
            party = "Independent";
            maxPosterior = independentPosterior;
        }
        if (libertarianPosterior > maxPosterior) {
            party = "Libertarian";
            maxPosterior = libertarianPosterior;
        }

        // Print the result
        System.out.println("Based on your answers, it is likely that you are a " + party + ".");
    }

    private static double calculateRepublicanLikelihood(String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String answer7, String answer8, String answer9, String answer10) {
        // Read in the dataset of Republican survey responses
        try (BufferedReader reader = new BufferedReader(new FileReader("republicanResponses.txt"))) {
            String line;
            double count = 0;
            double match = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                if (line.equals(answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7 + answer8 + answer9 + answer10)) {
                    match++;
                }
            }
            // Return the likelihood of the user's responses given that they are a Republican
            return match / count;
        } catch (IOException e) {
            System.err.println("Error reading in Republican survey responses: " + e.getMessage());
            return 0;
        }
    }

    private static double calculateDemocratLikelihood(String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String answer7, String answer8, String answer9, String answer10) {
        // Read in the dataset of Democrat survey responses
        try (BufferedReader reader = new BufferedReader(new FileReader("democratResponses.txt"))) {
            String line;
            double count = 0;
            double match = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                if (line.equals(answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7 + answer8 + answer9 + answer10)) {
                    match++;
                }
            }
            // Return the likelihood of the user's responses given that they are a Democrat
            return match / count;
        } catch (IOException e) {
            System.err.println("Error reading in Democrat survey responses: " + e.getMessage());
            return 0;
        }
    }

    private static double calculateIndependentLikelihood(String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String answer7, String answer8, String answer9, String answer10) {
        // Read in the dataset of Independent survey responses
        try (BufferedReader reader = new BufferedReader(new FileReader("independentResponses.txt"))) {
            String line;
            double count = 0;
            double match = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                if (line.equals(answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7 + answer8 + answer9 + answer10)) {
                    match++;
                }
            }
            // Return the likelihood of the user's responses given that they are a Independent
            return match / count;
        } catch (IOException e) {
            System.err.println("Error reading in Independent survey responses: " + e.getMessage());
            return 0;
        }
    }

    private static double calculateLibertarianLikelihood(String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String answer7, String answer8, String answer9, String answer10) {
        // Read in the dataset of Libertarian survey responses
        try (BufferedReader reader = new BufferedReader(new FileReader("libertarianResponses.txt"))) {
            String line;
            double count = 0;
            double match = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                if (line.equals(answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7 + answer8 + answer9 + answer10)) {
                    match++;
                }
            }
            // Return the likelihood of the user's responses given that they are a Libertarian
            return match / count;
        } catch (IOException e) {
            System.err.println("Error reading in Libertarian survey responses: " + e.getMessage());
            return 0;
        }
    }
}











