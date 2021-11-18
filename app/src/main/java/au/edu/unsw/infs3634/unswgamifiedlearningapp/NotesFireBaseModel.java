package au.edu.unsw.infs3634.unswgamifiedlearningapp;

public class NotesFireBaseModel {

    public String titleNotes;

    public String bodyNotes;

    public NotesFireBaseModel() {

    }

    public NotesFireBaseModel(String titleNotes, String bodyNotes) {
        this.titleNotes = titleNotes;
        this.bodyNotes = bodyNotes;
    }

    public String getTitleNotes() {
        return titleNotes;
    }

    public void setTitleNotes(String titleNotes) {
        this.titleNotes = titleNotes;
    }

    public String getBodyNotes() {
        return bodyNotes;
    }

    public void setBodyNotes(String bodyNotes) {
        this.bodyNotes = bodyNotes;
    }
}