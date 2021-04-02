package git.sxymi.simplephone;

public class Message {
    private Contact recipient;
    private String text;

    public Message(Contact recipient, String text) {
        this.recipient = recipient;
        this.text = text;
    }

    public Contact getRecipient() {
        return recipient;
    }

    public void setRecipient(Contact recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}