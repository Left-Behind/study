package work.azhu.springbootrocketmq.model;


import java.io.Serializable;

public class Message implements Serializable {

    private Long createTime;

    private String content;

    public Message(Long createTime, String content) {
        this.createTime = createTime;
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
