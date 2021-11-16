package au.edu.unsw.infs3634.unswgamifiedlearningapp;

public class NotesFireBaseModel {

    public String notesTitle;

    public String notesBody;

    public NotesFireBaseModel() {

    }

    public NotesFireBaseModel(String notesTitle, String notesBody) {
        this.notesTitle = notesTitle;
        this.notesBody = notesBody;
    }

    public String getNotesTitle() {
        return notesTitle;
    }

    public void setNotesTitle(String notesTitle) {
        this.notesTitle = notesTitle;
    }

    public String getNotesBody() {
        return notesBody;
    }

    public void setNotesBody(String notesBody) {
        this.notesBody = notesBody;
    }
}
