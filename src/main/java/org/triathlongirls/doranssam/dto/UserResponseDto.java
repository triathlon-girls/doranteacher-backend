package org.triathlongirls.doranssam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.triathlongirls.doranssam.domain.user.User;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
    private String nickname;
    private int writingStep;

    public static UserResponseDto of(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getCreated_at(),
                user.getUpdated_at(),
                user.getUsername(),
                user.getNickname(),
                user.getWritingStep().getValue()
        );
    }
}