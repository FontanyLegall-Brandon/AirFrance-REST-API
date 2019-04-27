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

    /**
     * To get the response status
     * @return Boolean
     */
    public Boolean getResponse() {
        return response;
    }

    /**
     * Setter to set the response status
     * @param response Boolean
     */
    public void setResponse(Boolean response) {
        this.response = response;
    }

    /**
     * Getter at message status
     * @return String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter at message status
     * @param message String
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
