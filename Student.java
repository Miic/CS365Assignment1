
public interface Student {
	public int getStudentID();
	public <E> void castVote(iVoteService<E> votingSystem, E answer);
}
