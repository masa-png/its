package com.example.its.web.user;

import com.example.its.web.validation.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

    @NotBlank(message = "ユーザー名を入力してください")
    @UniqueUsername
    private String username;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 12, max = 128, message = "パスワードは12文字以上、256文字以内で入力してください")
    private String password;

    @NotBlank(message = "権限を選択してください")
    private String authority;

}
