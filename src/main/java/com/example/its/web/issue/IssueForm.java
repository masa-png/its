package com.example.its.web.issue;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IssueForm {

    private long id;

    @NotBlank(message = "概要を入力してください")
    @Size(max = 256, message = "概要は256文字以内で入力してください")
    private String summary;

    @NotBlank(message = "詳細を入力してください")
    @Size(max = 256, message = "詳細は256文字以内で入力してください")
    private String description;
}
