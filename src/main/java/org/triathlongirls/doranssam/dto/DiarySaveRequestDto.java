package org.triathlongirls.doranssam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.triathlongirls.doranssam.constant.DiaryType;
import org.triathlongirls.doranssam.domain.diaries.Diary;
import org.triathlongirls.doranssam.domain.diaries.Text;
import org.triathlongirls.doranssam.domain.user.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiarySaveRequestDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Size(max=45)
    private String title;

    @NotNull(message = "날짜는 필수 입력 값입니다.")
    private LocalDate date;

    @NotBlank(message = "날씨는 필수 입력 값입니다.")
    @Size(max=45)
    private String weather;

    @NotBlank(message = "키워드는 필수 입력 값입니다.")
    private String keywords;

    @NotBlank(message = "일기 글은 필수 입력 값입니다.")
    private String text;

    @NotNull(message = "일기 유형은 필수 입력 값입니다.")
    private DiaryType diaryType;

    @NotNull(message = "코멘트 설정은 필수 입력 값입니다.")
    private Boolean isPrivate;

    @NotNull(message = "맞춤범 교정 설정은 필수 입력 값입니다.")
    private Boolean wantToCorrect;
    
    @NotNull(message = "이미지 추천 설정은 필수 입력 값입니다.")
    private Boolean wantToImage;
    

    public Diary toEntity(User user) {
        Text text = Text.builder()
                .originalText(this.text)
                .correctText("correctText") //TODO: text 처리
                .highlightedText("highlightedText")
                .hasSynonym(true)
                .build();

        return Diary.builder()
                .title(title)
                .date(date)
                .weather(weather)
                .keywords(keywords)
                .diaryType(diaryType)
                .text(text)
                .isPrivate(isPrivate)
                .wantToCorrect(wantToCorrect)
                .wantToImage(wantToImage)
                .hasImage(false)
                .user(user)
                .build();
    }
}