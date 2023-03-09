package com.example.homework49.service;

import com.example.homework49.model.Candidate;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CandidateDataModel {
    private static List<Candidate> candidates;
    private static int allVotes = 5;

    public static List<Candidate> getCandidates() {
        return candidates;
    }

    public static void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public CandidateDataModel(List<Candidate> candidates){
        this.candidates = candidates;
    }

    public static void generateAllVotes(){
        for (Candidate candidate : candidates) {
            if (candidates.get(1).getVotes() != 0) {
                allVotes = allVotes + candidate.getVotes();
            }
        }
    }

    public static void setAllVotes(int allVotes) {
        this.allVotes = allVotes;
    }

    public static int getAllVotes() {
        generateAllVotes();
        return allVotes;
    }


    public static Candidate checkCandidate(String candidateName){
        Candidate candidate = null;
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).getName().equals(candidateName)){
                candidate = candidates.get(i);
                allVotes++;
            }
        }
        candidate.setPercentVotes((candidate.getVotes()*100)/allVotes);
        return candidate;
    }

}
