package spring_application_full.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EntityResponse {

    @JsonProperty("message")
    private final String message;

    @JsonProperty("timestamp")
    private final LocalDateTime timestamp;

    @JsonProperty("status_code")
    private final int status;

    public EntityResponse(String message, int status) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }
}
