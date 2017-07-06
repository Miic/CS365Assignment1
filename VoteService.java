
public interface VoteService<E> {
	public void submitVote(Student student, E answer);
	public void endVote();
}