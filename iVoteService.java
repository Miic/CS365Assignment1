import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class iVoteService<E> implements VoteService<E> {
	
	voteQuestion<E> question;
	ArrayList<Student> students;
	
	public iVoteService(String q, List<E> answers) {
		question = new voteQuestion<E>(q, answers);
		students = new ArrayList<Student>();
	}
	
	public List<E> getAnswers() {
		return question.getAnswers();
	}
	
	@Override
	public void endVote() {
		question.finalizeResults();
	}

	@Override
	public void submitVote(Student student, E answer) {
		question.submitAnswer(student, answer);
	}
	
	public voteStudent addStudent(voteStudent student) {
		students.add(student);
		return student;
	}
	
	
	//Simple user print out with visual bars for scaling.
	public String toString() {
		StringBuilder strung = new StringBuilder();
		Map<E, Integer> results = question.printResults();
		Iterator<E> keyItrerator = results.keySet().iterator();
		strung.append("\n::Results::\n\n");
		
		E maxAKey = null;
		int total = 0;
		
		while(keyItrerator.hasNext()) {
			E AKey = keyItrerator.next();
			total += results.get(AKey);
			strung.append(AKey + " ( " + results.get(AKey) + " ) :  ");
			for(int i = 0; i < results.get(AKey); i++) {
				strung.append("+");
			}
			if (maxAKey != null) {
				if (results.get(AKey) > results.get(maxAKey)) {
					maxAKey = AKey;
				}
			} else {
				maxAKey = AKey;
			}
			strung.append("\n");
		}
		strung.append("\n  (!) Winner: " + maxAKey + " " + " ( " + results.get(maxAKey) + ", " +  ( (float) results.get(maxAKey) / (float) total ) * 100 + "% ) " + " : ");
		for(int i = 0; i < results.get(maxAKey); i++) {
			strung.append("+");
		}
		strung.append("\n");
		
		return strung.toString();
	}
}
