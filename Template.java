import java.util.ArrayList;
import java.util.List;

public class Template {
    private String Contact;
    private String Subject;
    private String templateType; // the primary key in DB
    public List<Message> Messages;
    public List<Language> Languages;
    private String Content;

    public Template() {
        // you may face an error here, you can create this lists above outside this constructor
        Messages = new ArrayList<>(Messages);
       Languages = new ArrayList<>(Languages);

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

   /* public Template(String contact, String subject, String type, String languages, String content) {
        Contact = contact;
        Subject = subject;
        templateType = type;
        Content = content;
    }*/
}