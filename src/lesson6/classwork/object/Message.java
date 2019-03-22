package lesson6.classwork.object;

public class Message implements Cloneable{
    private String messageText;
    private Author author;

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", author=" + author +
                '}';
    }



    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (messageText != null ? !messageText.equals(message.messageText) : message.messageText != null) return false;
        return author != null ? author.equals(message.author) : message.author == null;
    }

    @Override
    public int hashCode() {
        int result = messageText != null ? messageText.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
class Author{
    private String name;

    public Author(String name) {
        this.name = name;
    }
}