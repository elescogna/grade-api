package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        Team team = gradeDB.getMyTeam();
        String [] members = team.getMembers();
        int grade = 0;
        int count = 0;
        for (String i : members){
            grade += gradeDB.getGrade(i,course).getGrade();
            count+=1;
        }
        return (float) grade /count;
    }
}
