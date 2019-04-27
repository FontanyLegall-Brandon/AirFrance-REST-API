package core.communication.container;

import lombok.Data;

/**
 * A container for responses that contain a boolean and a message of return
 */
@Data
public class ResponseContainer {
    public Boolean response;
    public String message;

    public ResponseContainer() {
        this.response = null;
        this.message = null;
    }

    public ResponseContainer(boolean b, String msg) {
        this.response = b;
        this.message = msg;
    }

    @Override
    public String toString() {
        return "ResponseContainer{" +
                "response=" + response +
                ", message='" + message + '\'' +
                '}';
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
