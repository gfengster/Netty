package nettyclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class RequestData {
	@Setter
	@Getter
    int intValue;
	
	@Setter
	@Getter
    String stringValue;
    
    // standard getters and setters
}