package ca.sheridancollege.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

	private String from;
    private String to;
    private String subject;
    private String content;
}
