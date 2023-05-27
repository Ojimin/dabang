package mission1.demo.web.dto;

import lombok.Getter;
import lombok.Setter;

public class CommentRequestDto {

    @Getter
    @Setter
    public static class CreateCommentDto{
        private String content;
        private Long userid;
    }
}
