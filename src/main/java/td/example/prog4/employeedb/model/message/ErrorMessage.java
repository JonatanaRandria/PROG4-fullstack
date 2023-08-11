package td.example.prog4.employeedb.model.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String message;
    private int code;
}
