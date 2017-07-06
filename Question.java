import java.util.List;
import java.util.Map;

public interface Question<E> {	
	public Map<E, Integer> printResults();
	public List<E> getAnswers();
	
	public void finalizeResults();
	public boolean isOpen();
	public void submitAnswer(Student studentID, E answer);
}
