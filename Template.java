import java.util.ArrayList;
import java.util.List;

public class Template {
    private String Contact;
    private String Subject;
    private String templateType; // the primary key in DB
    public List<String> Messages;
    public List<String> Languages;
    private String Content;

    public Template() {
        // you may face an error here, you can create this lists above outside this constructor
        Messages = new ArrayList<>();
       Languages = new ArrayList<>();

    }

    public void setMessages(List<String> messages) {
        Messages = messages;
    }

    public void setLanguages(List<String> languages) {
        Languages = languages;
    }

    public String getContact() {
        return Contact;
    }

    public String getSubject() {
        return Subject;
    }

    @Override
    public String toString() {
        return "Template{" +
                "Contact='" + Contact + '\n' +
                ", Subject='" + Subject + '\n' +
                ", Type='" + templateType + '\n' +
                ", Msgs='" + Content + '\n' +
                '}';
    }

    public String getType() {
        return templateType;
    }


    public String getContent() {
        return Content;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setType(String type) {
        templateType = type;
    }



    public void setContent(String content) {
        Content = content;
    }

    public int getMessageIndexByLanguage(String language){
        for(int i=0;i<Languages.size();i++){
            if(Languages.get(i).equals(language)){
                return i;
            }
        }
        return -1;
    }

    public int countParametersSize(String language){
        // find message index from language list

        int index = getMessageIndexByLanguage(language);
        int count = ( Messages.get(index).split("XXX", -1).length ) - 1;
        return count;
    }

    public boolean isLanguageAvailable(String language){
        if(getMessageIndexByLanguage(language) == -1)return false;
        return true;
    }
}