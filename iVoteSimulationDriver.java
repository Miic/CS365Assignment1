import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class iVoteSimulationDriver<E> implements SimulationDriver {

	iVoteService<E> iVote;
	voteStudent[] students;
	
	public iVoteSimulationDriver(String question, List<E> answers, int numberOfStudents){
		iVote = new iVoteService<E>(question, answers);
		students = new voteStudent[numberOfStudents];
		for(int i = 0; i < numberOfStudents; i++) {
			students[i] = iVote.addStudent(new voteStudent("Student #" + i, i));
		}
	}
	
	@Override
	public void startSimulation() {
		for(int i = 0; i < students.length; i++) {
			//Make each simulated student cast a random vote for an available answer.
			students[i].castVote(iVote, iVote.getAnswers().get( ThreadLocalRandom.current().nextInt(0, (iVote.getAnswers().size()))) );
			System.out.println(students[i].getName() + " has cast their vote!");
		}
	}

	@Override
	public void endSimulation() {
		iVote.endVote();
		System.out.println(iVote);
	}
}
