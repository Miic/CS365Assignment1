import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class voteQuestion<E> implements Question<E> {

	private String question;
	private List<E> answers;
	private HashMap<Integer, E> submittedAnswers;
	private boolean openQuestion;
	
	public voteQuestion(String question, List<E> answers) {
		this.question = question;
		this.answers = answers;
		openQuestion = true;
		submittedAnswers = new HashMap<Integer,E>();
	}
	
	public String getQuestion() {
		return question;
	}
	
	@Override
	public Map<E, Integer> printResults() {
		HashMap<E,Integer> result = new HashMap<E, Integer>(); 
		Iterator<Integer> keyItrerator = submittedAnswers.keySet().iterator();
		while (keyItrerator.hasNext()) {
			int aKey = keyItrerator.next();
			if (result.containsKey(submittedAnswers.get(aKey))) {
				result.put(submittedAnswers.get(aKey), result.get(submittedAnswers.get(aKey)) + 1 );
			} else {
				result.put(submittedAnswers.get(aKey), 1);
			}
		}
		return result;
	}

	@Override
	public List<E> getAnswers() {
		return answers;
	}

	@Override
	public void submitAnswer(Student studentID, E answer) {
		if (openQuestion) 
			submittedAnswers.put(studentID.getStudentID(), answer);
	}

	@Override
	public void finalizeResults() {
		openQuestion = false;
	}

	@Override
	public boolean isOpen() {
		return openQuestion;
	}
	
	public int numberOfAnswers() {
		return submittedAnswers.size();
	}
}
