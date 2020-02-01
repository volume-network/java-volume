package vlm.http;

import com.google.gson.JsonElement;
import vlm.VolumeException;

public final class ParameterException extends VolumeException {

    private final JsonElement errorResponse;

    public ParameterException(JsonElement errorResponse) {
        this.errorResponse = errorResponse;
    }

    JsonElement getErrorResponse() {
        return errorResponse;
    }

}
