import java.util.ArrayList;
import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;

public class Assignment1 {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter initial Question: ");
		String question = kb.nextLine();
		int numStudents = -1;
		do {
			System.out.println("Enter Maximum Number of Students (5 - 1000): ");
			numStudents = Integer.parseInt((kb.nextLine()));
		} while (numStudents < 5 || numStudents > 1000);
		// Add limiters to prevent user from taking up entire ram space
		ArrayList<String> answers = new ArrayList<String>();
		String lastAnswer = "";
		do {
			System.out.println("Enter a possible answer for your question (Type \"Exit\" or \"\" to quit Answer mode): ");
			lastAnswer = kb.nextLine();
			if (!(lastAnswer.equals("exit") || lastAnswer.equals((""))))
				answers.add(lastAnswer);
		} while (!(lastAnswer.toLowerCase().equals("exit") || lastAnswer.toLowerCase().equals("")) && answers.size() != 0);
		//Prevent scenario = no answers.
		kb.close();
		
		
		iVoteSimulationDriver<String> votingSim = new iVoteSimulationDriver<String>(question, answers, numStudents); //ThreadLocalRandom.current().nextInt(5, numStudents) );
		votingSim.startSimulation();
		votingSim.endSimulation();
	}
}
