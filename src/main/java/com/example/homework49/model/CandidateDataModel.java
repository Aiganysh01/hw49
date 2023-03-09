package work;

import java.util.List;

public class CandidateDataModel {
    private List<Candidate> candidates;
    private int allVotes;

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public CandidateDataModel(List<Candidate> candidates){
        this.candidates = candidates;
    }

    public void generateAllVotes(){
        for (Candidate candidate : candidates) {
            if (candidates.get(1).getVotes() != 0) {
                allVotes = allVotes + candidate.getVotes();
            }
        }
    }

    public void setAllVotes(int allVotes) {
        this.allVotes = allVotes;
    }

    public int getAllVotes() {
        generateAllVotes();
        return allVotes;
    }
}
