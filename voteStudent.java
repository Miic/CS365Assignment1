
public class voteStudent implements Student {
	String Sname;
	int StudentID;
	
	public voteStudent(String name, int id) {
		Sname = name;
		StudentID = id;
	}
	
	@Override
	public int getStudentID() {
		return StudentID;
	}

	@Override
	public <E> void castVote(iVoteService<E> votingSystem, E answer) {
		votingSystem.submitVote(this, answer);
	}

	public String getName() {
		return Sname;
	}

	
	
}
