package es.uc3m.g3.bean;

import java.util.Date;

public class MessageBean {
  private String idConversation;
  private String idCreator;
  private Date timeStamp;
  private String content;
  private boolean recived;
  private boolean read;

  public MessageBean(String idConversation, String idCreator, String content) {
    super();
    this.idConversation = idConversation;
    this.idCreator = idCreator;
    this.timeStamp = new Date();
    this.content = content;
    this.recived = false;
    this.read = false;
  }

  public String getIdConversation() { return idConversation; }

  public void setIdConversation(String idConversation) {
    this.idConversation = idConversation;
  }

  public String getIdCreator() { return idCreator; }

  public void setIdCreator(String idCreator) { this.idCreator = idCreator; }

  public Date getTimeStamp() { return timeStamp; }

  public void setTimeStamp(Date timeStamp) { this.timeStamp = timeStamp; }

  public String getContent() { return content; }

  public void setContent(String content) { this.content = content; }

  public boolean isRecived() { return recived; }

  public void setRecived(boolean recived) { this.recived = recived; }

  public boolean isRead() { return read; }

  public void setRead(boolean read) { this.read = read; }
}
